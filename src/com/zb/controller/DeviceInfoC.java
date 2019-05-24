package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.DeviceInfoBiz;
import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;
import com.zb.util.PageUtil;

@Controller
public class DeviceInfoC {

	@Autowired
	private DeviceInfoBiz deviceBiz;
	
	@ResponseBody
	@RequestMapping(value="addDevice",method=RequestMethod.POST)
	public Map<String,String> addDevice(DeviceInfo device) {
		boolean f = deviceBiz.addDevice(device);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping(value="updateDevice",method=RequestMethod.PUT)
	public Map<String,String> updateDevice(DeviceInfo device) {
		boolean f = deviceBiz.updateDevice(device);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","修改成功!");
		}else {
			map.put("no","修改失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteDevice",method=RequestMethod.DELETE)
	public Map<String,String> deleteDevice(Integer did) {
		boolean f = deviceBiz.deleteDevice(did);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","删除成功!");
		}else {
			map.put("no","删除失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="countDevice",method=RequestMethod.GET)
	public Integer searchCount(String projectName,String deviceName,String deviceNum){
		Integer cnt = deviceBiz.searchCount(projectName, deviceName, deviceNum);
		return cnt;
	}
	
	
	@ResponseBody
	@RequestMapping(value="searchDevice",method=RequestMethod.GET)
	public PageUtil<DeviceComb> searchDevice(String projectName,String deviceName,String deviceNum,Integer index,Integer size){
		PageUtil<DeviceComb> page = new PageUtil<DeviceComb>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<DeviceComb> pageUtil = deviceBiz.searchDevice(projectName, deviceName, deviceNum,page);
		return pageUtil;
	}
	

}
