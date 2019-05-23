package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.ControlLogBiz;
import com.zb.entity.ControlLog;
import com.zb.entity.ControlLogComb;
import com.zb.mapper.ControlLogMapper;
import com.zb.util.PageUtil;
@Service("db_controllog")
public class ControlLogBizImpl implements ControlLogBiz {
	@Autowired
	private ControlLogMapper controlLogMapper;

	public boolean addControlLog(ControlLog controlLog){
		boolean flag = controlLogMapper.addControlLog(controlLog);
		return flag;
	}
	
	
	public PageUtil<ControlLogComb> searchControlLog(String deviceNum,String hisstate,String hisinfo,
			Integer taskNum,String operationOrder,String person,
			String kind,String qualConfig,String minVal,String maxVal,
			String beginTime,String endTime,String duration,PageUtil<ControlLogComb> page){
		List<ControlLogComb> controlLogCombs = controlLogMapper.searchControlLog(deviceNum,hisstate,hisinfo,
				taskNum,operationOrder,person,kind,qualConfig,minVal,maxVal,
				beginTime,endTime,duration,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(controlLogCombs);
		
		int count = controlLogMapper.searchCount(deviceNum, hisstate, hisinfo, taskNum, operationOrder, person, 
				kind, qualConfig, minVal, maxVal, beginTime, endTime, duration);
		page.setCount(count);
		
		return page;
	}
		

}
