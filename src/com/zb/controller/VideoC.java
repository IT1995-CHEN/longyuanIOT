package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.VideoBiz;
import com.zb.entity.Video;
import com.zb.util.PageUtil;

@Controller
public class VideoC {

	
	@Autowired
	private VideoBiz videoBiz;
	
	@ResponseBody
	@RequestMapping("/addVideo")
	public Map<String,String> addVideo(Video video) {
		boolean f = videoBiz.addVideo(video);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/updateVideo")
	public Map<String,String> updateVideo(Video video) {
		boolean f = videoBiz.updateVideo(video);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","修改成功!");
		}else {
			map.put("no","修改失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/deleteVideo")
	public Map<String,String> deleteVideo(Integer vid) {
		boolean f = videoBiz.deleteVideo(vid);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","删除成功!");
		}else {
			map.put("no","删除失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/searchVideo")
	public PageUtil<Video> searchVideo(String monitorName,Integer vid,Integer pid,Integer index,Integer size){
		PageUtil<Video> page = new PageUtil<Video>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<Video> pageUtil = videoBiz.searchVideo(monitorName, vid,pid,index, size);
		return pageUtil;
	}
	
	
}
