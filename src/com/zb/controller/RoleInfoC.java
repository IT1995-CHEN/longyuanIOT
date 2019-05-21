package com.zb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.RoleInfoBiz;
import com.zb.entity.RoleInfo;

@Controller
public class RoleInfoC {
	
	@Autowired
	private RoleInfoBiz roleBiz;

	@ResponseBody
	@RequestMapping("/selectRole")
	public List<RoleInfo> selectRole(){
		List<RoleInfo> roleList = roleBiz.selectRole();
		
		return roleList;
	}
}
