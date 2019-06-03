package com.zb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zb.entity.ControlRun;
import com.zb.util.PageUtil;



@Repository
public interface ControlRunMapper {

	public List<ControlRun> selectControlRun();
	
//	public PageUtil<ControlRun> searchControlRun(String deviceNum,String kind,String operator,Integer index,Integer size);
//	
//	public  int  countControlRun(String deviceNum,String kind,String operator);
//	
//	public  boolean  addControlRun(ControlRun controlRun);
	
}
