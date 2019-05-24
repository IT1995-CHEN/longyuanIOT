
package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="addHisData",method=RequestMethod.POST)
	public Map<String,String> addHisData(SensorHisdata sensorHis) {
		boolean f = sensorHisBiz.addHisData(sensorHis);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("ok","添加成功!");
		}else {
			map.put("ok","添加失败!");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value="searchHisData",method=RequestMethod.GET)
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
	@RequestMapping(value="selectHisData",method=RequestMethod.GET)
	public List<SensorHisdataComb> selectSensorHis(Integer pid,String deviceDes){
		List<SensorHisdataComb> sensorHisdataCombs = sensorHisBiz.selectHisData(pid, deviceDes);

		return sensorHisdataCombs;
	}

}
