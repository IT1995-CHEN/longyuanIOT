package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zb.entity.ControlRun;
import com.zb.entity.ControlRunComb;
import com.zb.util.PageUtil;



@Repository
public interface ControlRunMapper {

	public List<ControlRun> selectControlRun();
	
	public List<ControlRunComb> searchControlRun(@Param("deviceNum")String deviceNum,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("index")Integer index,@Param("size")Integer size);
	
	public  int  countControlRun(@Param("deviceNum")String deviceNum,@Param("beginTime")String beginTime,@Param("endTime")String endTime);

	public  boolean  addControlRun(ControlRun controlRun);
	
}
