package com.zb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlRunBiz;
import com.zb.entity.ControlRun;

@Controller  
public class ControlRunC {

	@Autowired
	private ControlRunBiz controlRunBiz;
	
	@ResponseBody
	@RequestMapping("/selectControlRun")
	public List<ControlRun> selectControlRun(){
		return controlRunBiz.selectControlRun();
	}
}
