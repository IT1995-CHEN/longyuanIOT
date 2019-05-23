package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.ControlBiz;
import com.zb.entity.Control;
import com.zb.mapper.ControlMapper;

@Service("db_control")
public class ControlBizImpl implements ControlBiz {

	@Autowired
	private ControlMapper controlMapper;
	
	@Transactional
	public boolean addControl(Control control){
		Boolean flag = controlMapper.addControl(control);
		
		return flag;
	}

	@Transactional
	public boolean updateControl(Control control){
		Boolean flag = controlMapper.updateControl(control);
		
		return flag;
	}
	
	@Transactional
	public boolean deleteControlCid(Integer cid){
		Boolean flag = controlMapper.deleteControlCid(cid);
		
		return flag;
	}
	
	@Transactional
	public boolean deleteControlDeviceNum(String deviceNum){
		Boolean flag = controlMapper.deleteControlDeviceNum(deviceNum);
		
		return flag;
	}
	
	public List<Control> selectControl(String deviceNum){
		List<Control> controls = controlMapper.selectControl(deviceNum);
		
		return controls;
	}

}
