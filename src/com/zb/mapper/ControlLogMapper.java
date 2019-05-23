package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.ControlLog;
import com.zb.entity.ControlLogComb;

public interface ControlLogMapper {
	
	public boolean addControlLog(ControlLog controlLog);
	
	public Integer searchCount(@Param("deviceNum")String deviceNum,@Param("hisstate")String hisstate,@Param("hisinfo")String hisinfo,
			@Param("taskNum")Integer taskNum,@Param("operationOrder")String operationOrder,@Param("person")String person,
			@Param("kind")String kind,@Param("qualConfig")String qualConfig,@Param("minVal")String minVal,@Param("maxVal")String maxVal,
			@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("duration")String duration);
	
	public List<ControlLogComb> searchControlLog(@Param("deviceNum")String deviceNum,@Param("hisstate")String hisstate,@Param("hisinfo")String hisinfo,
			@Param("taskNum")Integer taskNum,@Param("operationOrder")String operationOrder,@Param("person")String person,
			@Param("kind")String kind,@Param("qualConfig")String qualConfig,@Param("minVal")String minVal,@Param("maxVal")String maxVal,
			@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("duration")String duration,@Param("index")Integer index,@Param("size")Integer size);
	

}
