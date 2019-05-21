package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.SensorNowdata;
import com.zb.util.PageUtil;

@Controller
public class SensorNowdataC {

	@Autowired
	private SensorNowdataBiz sensorNowBiz;
	
	@RequestMapping("/addNowData")
	public Map<String,String> addNowData(SensorNowdata sensorNow) {
		boolean f = sensorNowBiz.addNowData(sensorNow);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
		
	}
	
	@RequestMapping("/updateNowData")
	public Map<String,String> updateNowData(SensorNowdata sensorNow) {
		boolean f = sensorNowBiz.updateNowData(sensorNow);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","修改成功!");
		}else {
			map.put("no","修改失败!");
		}
		return map;
	}
	

	@ResponseBody
	@RequestMapping("/searchNowData")
	public PageUtil<SensorNowdata> searchNowData(String deviceNum,Integer pid){
		PageUtil<SensorNowdata> page = new PageUtil<SensorNowdata>();
	
		PageUtil<SensorNowdata> pageUtil = sensorNowBiz.searchNowData(deviceNum,pid);
		return pageUtil;
	}
}
