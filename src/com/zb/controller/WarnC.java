package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.WarnBiz;
import com.zb.entity.Warn;
import com.zb.util.PageUtil;

@Controller
public class WarnC {

	@Autowired
	private WarnBiz warnBiz;

	@ResponseBody
	@RequestMapping("/addWarn")
	public Map<String,String> addWarn(Warn warn) {
		boolean f = warnBiz.addWarn(warn);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;

	}

	@ResponseBody
	@RequestMapping("/searchWarn")
	public PageUtil<Warn> searchWarn(Integer index,Integer size,Integer pid,String deviceNum,String warnInfo){
		PageUtil<Warn> page = new PageUtil<Warn>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<Warn> pageUtil = warnBiz.searchWarn(index, size,pid,deviceNum,warnInfo);
		return pageUtil;
	}
}
