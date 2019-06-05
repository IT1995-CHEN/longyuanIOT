package com.zb.biz.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.SensorCount;
import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;
import com.zb.mapper.SensorHisdataMapper;
import com.zb.mapper.SensorNowdataMapper;
import com.zb.util.RemoveDupList;

@Service("db_sensorNowdata")
public class SensorNowdataBizImpl implements SensorNowdataBiz {

	@Autowired
	private SensorNowdataMapper sensorNowdataMapper;
	@Autowired
	private SensorHisdataMapper hisdataMapper;
	
	@Transactional
	public boolean addNowData(SensorNowdata sensorNow){
		boolean flag = sensorNowdataMapper.addNowData(sensorNow);
		return flag;
	}

	@Transactional
	public boolean updateNowData(SensorNowdata sensorNow){
		//在修改 当前数据前，把当前数据保存入历史数据表中
		SensorNowdata sensorNowdata = sensorNowdataMapper.selectNowDataByDeviceNum(sensorNow.getDeviceNum());
		if(sensorNowdata!=null){
			SensorHisdata sensorHisdata = new SensorHisdata();
			sensorHisdata.setPid(sensorNowdata.getPid());
			sensorHisdata.setDeviceNum(sensorNowdata.getDeviceNum());
			sensorHisdata.setHisVal(sensorNowdata.getVal());
			hisdataMapper.addHisData(sensorHisdata);
		}
		boolean flag = sensorNowdataMapper.updateNowData(sensorNow);
		return flag;
	}

	public List<SensorNowdataComb> selectNowData(String deviceNum,Integer pid){
		List<SensorNowdataComb> sensorNowdataCombs = sensorNowdataMapper.selectNowData(deviceNum, pid);
		return sensorNowdataCombs;
	}

	@Override
	public  SensorCount pSensorCount() {
		// TODO Auto-generated method stub
		List<SensorNowdataComb> sensorNowdata=  sensorNowdataMapper.selectSensorName(null);
		List<String> nameList=new ArrayList<>();
		List<Integer> countList=new ArrayList<>();
		for (int i = 0; i < sensorNowdata.size(); i++) {
			String deviceNameString=sensorNowdata.get(i).getDeviceInfo().getDeviceName();
			System.out.println(sensorNowdata.get(i).getDeviceInfo().getDeviceName());
			nameList.add(deviceNameString);
		}
		nameList=new RemoveDupList().removeDupString(nameList);
		for (int i = 0; i < nameList.size(); i++) {
			String deviceNameString=nameList.get(i);
			Integer count = sensorNowdataMapper.pSensorCount(deviceNameString);
			countList.add(count);
		}
		SensorCount sensorCount = new SensorCount();
		sensorCount.setTableNameString("正在使用的传感器数量");
		sensorCount.setSensorNameList(nameList);
		sensorCount.setSensorCountList(countList);
		
		return sensorCount;
	}

	

	

}
