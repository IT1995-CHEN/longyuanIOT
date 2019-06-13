package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlBiz;
import com.zb.entity.Control;
import com.zb.entity.ControlDev;

@Controller
public class ControlC {

	@Autowired
	private ControlBiz controlBiz;
	
	@ResponseBody
	@RequestMapping("/addControl")
	public Map<String,String> addControl(Control control) {
		boolean f = controlBiz.addControl(control);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","添加成功!");
		}else {
			map.put("ok","添加失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/updateControl")
	public Map<String,String> updateControl(Control control) {
		boolean f = controlBiz.updateControl(control);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","修改成功!");
		}else {
			map.put("ok","修改失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/deleteControlCid")
	public Map<String,String> deleteControlCid(Integer cid) {
		boolean f = controlBiz.deleteControlCid(cid);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","删除成功!");
		}else {
			map.put("ok","删除失败!");
		}
		return map;
		
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteControlDeviceNum")
	public Map<String,String> deleteControlDeviceNum(String deviceNum) {
		boolean f = controlBiz.deleteControlDeviceNum(deviceNum);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","删除成功!");
		}else {
			map.put("ok","删除失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/selectControl")
	public List<Control> selectControl(String deviceNum) {
		List<Control> controls = controlBiz.selectControl(deviceNum);
		
		return controls;
		
	}
	
	@ResponseBody
	@RequestMapping("/selectControlDev")
	public List<ControlDev> selectControlDev(String deviceNum,Integer pid,String deviceName) {
		List<ControlDev> controlDevs = controlBiz.selectControlDev(deviceNum,pid,deviceName);
		
		return controlDevs;
		
	}
}

