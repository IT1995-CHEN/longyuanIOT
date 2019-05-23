package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;

public interface SensorNowdataMapper {

	public boolean addNowData(SensorNowdata sensorNow);

	public boolean updateNowData(SensorNowdata sensorNow);

	public SensorNowdata selectNowDataByNid(@Param("nid")Integer nid);
	
	public List<SensorNowdataComb> selectNowData(@Param("deviceNum")String deviceNum,@Param("pid")Integer pid);

}
