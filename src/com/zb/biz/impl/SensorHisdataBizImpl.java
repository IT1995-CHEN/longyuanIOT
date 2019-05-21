package com.zb.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zb.biz.SensorHisdataBiz;
import com.zb.entity.SensorHisdata;
import com.zb.util.PageUtil;

@Service("db_sensorHisdata")
public class SensorHisdataBizImpl implements SensorHisdataBiz {

	public boolean addHisData(SensorHisdata sensorHis){
		return false;
	}

	public PageUtil<SensorHisdata> searchHisData(Integer pid,Integer index,Integer size,String deviceNum,String beginTime,String endTime){
		return null;
	}

	public List<SensorHisdata> selectHisData(Integer pid,String deviceDes){
		return null;
	}
}
