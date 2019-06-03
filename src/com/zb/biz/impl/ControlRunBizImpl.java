package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.ControlRunBiz;
import com.zb.entity.ControlRun;
import com.zb.mapper.ControlRunMapper;

@Service("db_controlrun")
public class ControlRunBizImpl implements ControlRunBiz {

	@Autowired
	private ControlRunMapper controlRunMapper;
	
	@Override
	public List<ControlRun> selectControlRun() {
		// TODO Auto-generated method stub
		return controlRunMapper.selectControlRun();
	}

}
