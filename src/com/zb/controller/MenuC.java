package com.zb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.MenuBiz;
import com.zb.entity.Menu;

@Controller
public class MenuC {

	@Autowired
	private MenuBiz menuBiz;
	
	@ResponseBody
	@RequestMapping(value="/selectMenu",method=RequestMethod.GET)
	public List<Menu> selectMenu(Integer pid){
		
		return menuBiz.selectMenu(pid);
	}
}
