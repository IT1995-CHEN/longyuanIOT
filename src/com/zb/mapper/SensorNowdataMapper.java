package com.zb.mapper;

import java.util.List;

import com.zb.entity.SensorNowdata;

public interface SensorNowdataMapper {

	public boolean addNowData(SensorNowdata sensorNow);

	public boolean updateNowData(SensorNowdata sensorNow);

	public List<SensorNowdata> searchNowData(String deviceNum,Integer pid);

	public void linkHisData();
}
