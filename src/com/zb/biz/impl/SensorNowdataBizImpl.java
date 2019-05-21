package com.zb.biz.impl;

import org.springframework.stereotype.Service;

import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.SensorNowdata;
import com.zb.util.PageUtil;

@Service("db_sensorNowdata")
public class SensorNowdataBizImpl implements SensorNowdataBiz {

	public boolean addNowData(SensorNowdata sensorNow){
		return false;
	}

	public boolean updateNowData(SensorNowdata sensorNow){
		return false;
	}

	public PageUtil<SensorNowdata> searchNowData(String deviceNum,Integer pid){
		return null;
	}

}
