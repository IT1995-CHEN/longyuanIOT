package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Warn;
import com.zb.entity.WarnComb;

public interface WarnMapper {

	public boolean addWarn(Warn warn);

	public Integer searchCount(@Param("deviceNum")String deviceNum,@Param("pid")Integer pid,@Param("warnInfo")String warnInfo);
	
	public List<WarnComb> searchWarn(@Param("deviceNum")String deviceNum,@Param("pid")Integer pid,@Param("index")Integer index,@Param("size")Integer size,@Param("warnInfo")String warnInfo);
}
