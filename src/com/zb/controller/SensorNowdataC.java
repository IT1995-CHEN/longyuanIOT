package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;

@Controller
public class SensorNowdataC {

	@Autowired
	private SensorNowdataBiz sensorNowBiz;
	
	@ResponseBody
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
	
	@ResponseBody
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
	@RequestMapping("/selectNowData")
	public List<SensorNowdataComb> selectNowData(String deviceNum,Integer pid){
		List<SensorNowdataComb> sensorNowdataCombs = sensorNowBiz.selectNowData(deviceNum, pid);
		return sensorNowdataCombs;
	}
}
