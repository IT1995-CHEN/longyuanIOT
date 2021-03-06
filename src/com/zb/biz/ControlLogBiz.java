package com.zb.biz;

import java.util.List;

import com.zb.entity.ControlComb;
import com.zb.entity.ControlLog;
import com.zb.entity.ControlLogComb;
import com.zb.util.PageUtil;

public interface ControlLogBiz {

	public boolean addControlLog(ControlLog controlLog);
	
	public PageUtil<ControlLogComb> searchControlLog(String deviceNum,String hisstate,String hisinfo,
			Integer taskNum,String operationOrder,String person,
			String kind,String qualConfig,String minVal,String maxVal,
			String beginTime,String endTime,String duration,PageUtil<ControlLogComb> page);
		
	public ControlComb selectControlComb(String deviceNum);
	
	public List<ControlLog> selectOneControlLog(String deviceNum);
}
