package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.ControlRunBiz;
import com.zb.entity.ControlLogComb;
import com.zb.entity.ControlRun;
import com.zb.entity.ControlRunComb;
import com.zb.mapper.ControlRunMapper;
import com.zb.util.PageUtil;

@Service("db_controlrun")
public class ControlRunBizImpl implements ControlRunBiz {

	@Autowired
	private ControlRunMapper controlRunMapper;
	
	@Override
	public List<ControlRun> selectControlRun() {
		// TODO Auto-generated method stub
		return controlRunMapper.selectControlRun();
	}

	@Override
	public PageUtil<ControlRunComb> searchControlRun(String deviceNum,
			String beginTime, String endTime, PageUtil<ControlRunComb> page) {
		// TODO Auto-generated method stub
		List<ControlRunComb> controlRunCombs = controlRunMapper.searchControlRun(deviceNum, beginTime, endTime,(page.getIndex() - 1) * page.getSize(), page.getSize());
		
		page.setPage(controlRunCombs);
		
		int count = controlRunMapper.countControlRun(deviceNum, beginTime, endTime);
		page.setCount(count);
		
		return page;
	}

	@Override
	public boolean addControlRun(ControlRun controlRun) {
		// TODO Auto-generated method stub
		boolean flag = controlRunMapper.addControlRun(controlRun);
	
		return flag;
	}



}
