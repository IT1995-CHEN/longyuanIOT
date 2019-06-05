package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;

public interface SensorNowdataMapper {

	public boolean addNowData(SensorNowdata sensorNow);

	public boolean updateNowData(SensorNowdata sensorNow);

	public SensorNowdata selectNowDataByDeviceNum(@Param("deviceNum")String deviceNum);
	
	public List<SensorNowdataComb> selectNowData(@Param("deviceNum")String deviceNum,@Param("pid")Integer pid);

	public Integer pSensorCount(@Param("deviceName")String deviceName);
	
	public List<SensorNowdataComb> selectSensorName(@Param("deviceNum")String deviceNum);
	
	public Integer countSensorNowdata(@Param("deviceNum") String deviceNum);
}
