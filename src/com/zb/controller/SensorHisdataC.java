
package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.SensorHisdataBiz;
import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorHisdataComb;
import com.zb.util.PageUtil;

@Controller
public class SensorHisdataC {

	@Autowired
	private SensorHisdataBiz sensorHisBiz;

	@ResponseBody
	@RequestMapping("/addHisData")
	public Map<String,String> addHisData(SensorHisdata sensorHis) {
		boolean f = sensorHisBiz.addHisData(sensorHis);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping("/searchHisData")
	public PageUtil<SensorHisdataComb> searchHisData(Integer pid,Integer index,Integer size,String deviceNum,String beginTime,String endTime){
		PageUtil<SensorHisdataComb> page = new PageUtil<SensorHisdataComb>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<SensorHisdataComb> pageUtil = sensorHisBiz.searchHisData(pid,page,deviceNum,beginTime,endTime);
		return pageUtil;
	}

	@ResponseBody
	@RequestMapping("/selectHisData")
	public List<SensorHisdataComb> selectSensorHis(Integer pid,String deviceDes){
		List<SensorHisdataComb> sensorHisdataCombs = sensorHisBiz.selectHisData(pid, deviceDes);

		return sensorHisdataCombs;
	}

}
