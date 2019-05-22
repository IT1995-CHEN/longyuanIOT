package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorHisdataComb;

public interface SensorHisdataMapper {

	public boolean addHisData(SensorHisdata sensorHis);

	public Integer searchCount(@Param("pid")Integer pid,@Param("deviceNum")String deviceNum,@Param("beginTime")String beginTime,@Param("endTime")String endTime);
	
	public List<SensorHisdataComb> searchHisData(@Param("pid")Integer pid,@Param("index")Integer index,@Param("size")Integer size,@Param("deviceNum")String deviceNum,@Param("beginTime")String beginTime,@Param("endTime")String endTime);
	
	public List<SensorHisdataComb> selectHisData(@Param("pid")Integer pid,@Param("deviceDes")String deviceDes);
}
