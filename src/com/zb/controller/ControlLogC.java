package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlLogBiz;
import com.zb.entity.ControlComb;
import com.zb.entity.ControlLog;
import com.zb.entity.ControlLogComb;
import com.zb.util.PageUtil;

@Controller
public class ControlLogC {

	@Autowired
	private ControlLogBiz controlLogBiz;
	
	@ResponseBody
	@RequestMapping("/addControlLog")
	public Map<String,String> addControlLog(ControlLog controlLog) {
		boolean f = controlLogBiz.addControlLog(controlLog);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","添加成功!");
		}else {
			map.put("ok","添加失败!");
		}
		return map;
		
	}
	

	@ResponseBody
	@RequestMapping("/searchControlLog")
	public PageUtil<ControlLogComb> searchControlLog(String deviceNum,String hisstate,String hisinfo,
			Integer taskNum,String operationOrder,String person,
			String kind,String qualConfig,String minVal,String maxVal,
			String beginTime,String endTime,String duration,Integer index,Integer size){
		PageUtil<ControlLogComb> page = new PageUtil<ControlLogComb>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<ControlLogComb> pageUtil = controlLogBiz.searchControlLog(deviceNum, hisstate, hisinfo, taskNum, operationOrder,
				person, kind, qualConfig, minVal, maxVal, beginTime, endTime, duration, page);
		return pageUtil;
	}

	@ResponseBody
	@RequestMapping("/selectControlComb")
	public ControlComb selectControlComb(String deviceNum){
		System.out.println(deviceNum);
		return controlLogBiz.selectControlComb(deviceNum);
		
	}
	
	@ResponseBody
	@RequestMapping("/selectOneControlLog")
	public List<ControlLog> selectOneControlLog(String deviceNum){
		System.out.println(deviceNum);
		return controlLogBiz.selectOneControlLog(deviceNum);
		
	}
}
