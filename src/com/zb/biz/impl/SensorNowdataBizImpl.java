package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;
import com.zb.mapper.SensorHisdataMapper;
import com.zb.mapper.SensorNowdataMapper;

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
		SensorNowdata sensorNowdata = sensorNowdataMapper.selectNowDataByNid(sensorNow.getNid());
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

}
