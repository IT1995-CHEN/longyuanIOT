package com.zb.biz;

import java.util.List;

import com.zb.entity.ControlRun;
import com.zb.entity.ControlRunComb;
import com.zb.util.PageUtil;

public interface ControlRunBiz {

	public List<ControlRun> selectControlRun();
	
	public PageUtil<ControlRunComb> searchControlRun(String deviceNum,String beginTime,String endTime,PageUtil<ControlRunComb> page);
	
	public boolean addControlRun(ControlRun controlRun);
}
