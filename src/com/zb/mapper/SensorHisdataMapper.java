package com.zb.mapper;

import java.util.List;

import com.zb.entity.SensorHisdata;

public interface SensorHisdataMapper {

	public boolean addHisData(SensorHisdata sensorHis);

	public List<SensorHisdata> searchHisData(Integer pid,Integer index,Integer size,String deviceNum,String beginTime,String endTime);
	
	public List<SensorHisdata> selectHisData(Integer pid,String deviceDes);
}
