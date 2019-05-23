package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.SensorHisdataBiz;
import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorHisdataComb;
import com.zb.mapper.SensorHisdataMapper;
import com.zb.util.PageUtil;

@Service("db_sensorHisdata")
public class SensorHisdataBizImpl implements SensorHisdataBiz {
	@Autowired
	private SensorHisdataMapper hisdataMapper;

	@Transactional
	public boolean addHisData(SensorHisdata sensorHis){
		boolean flag = hisdataMapper.addHisData(sensorHis);
		
		return flag;
	}

	public PageUtil<SensorHisdataComb> searchHisData(Integer pid,PageUtil<SensorHisdataComb> page,String deviceNum,String beginTime,String endTime){
		List<SensorHisdataComb> sensorHisdataCombs = hisdataMapper.searchHisData(pid,(page.getIndex() - 1) * page.getSize(), page.getSize(),deviceNum,beginTime,endTime);
		page.setPage(sensorHisdataCombs);
		
		int count = hisdataMapper.searchCount(pid, deviceNum, beginTime, endTime);
		page.setCount(count);
		
		return page;
	}

	public List<SensorHisdataComb> selectHisData(Integer pid,String deviceDes){
		List<SensorHisdataComb> sensorHisdataCombs = hisdataMapper.selectHisData(pid, deviceDes);
		
		return sensorHisdataCombs;
	}
}
