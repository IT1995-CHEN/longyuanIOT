package com.zb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.SensorInfoBiz;
import com.zb.entity.SensorInfo;

@Controller
public class SensorInfoC {

	@Autowired
	private SensorInfoBiz sensorInfoBiz;
	
	@ResponseBody
	@RequestMapping(value="/selectAllSensorName")
	public List<SensorInfo> selectAllSensorName(){
		return sensorInfoBiz.selectAllSensorName();
	}
}
