package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlRunBiz;
import com.zb.entity.ControlLogComb;
import com.zb.entity.ControlRun;
import com.zb.entity.ControlRunComb;
import com.zb.util.PageUtil;

@Controller  
public class ControlRunC {

	@Autowired
	private ControlRunBiz controlRunBiz;
	
	@ResponseBody
	@RequestMapping("/selectControlRun")
	public List<ControlRun> selectControlRun(){
		return controlRunBiz.selectControlRun();
	}
	
	@ResponseBody
	@RequestMapping("/searchControlRun")
	public PageUtil<ControlRunComb> searchControlRun(String deviceNum,String beginTime,String endTime,Integer index,Integer size){
		PageUtil<ControlRunComb> page = new PageUtil<>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<ControlRunComb> pageUtil=controlRunBiz.searchControlRun(deviceNum, beginTime, endTime, page);
		return pageUtil;
	}
	
	@ResponseBody
	@RequestMapping("/addControlRun")
	public Map<String, String> addControlRun(ControlRun controlRun){
		Map<String, String>	map = new HashMap<String, String>();
		map.put("ok", "添加成功");
		boolean flag = controlRunBiz.addControlRun(controlRun);
		if (flag==true) {
			return map;
		}
		Map<String, String>	map1 = new HashMap<String, String>();
		map1.put("ok", "添加失败");
		return  map1;
	}
}
