package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlBiz;
import com.zb.entity.Control;

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
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
		
	}
}
