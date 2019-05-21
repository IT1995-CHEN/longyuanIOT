package com.zb.biz.impl;

import org.springframework.stereotype.Service;

import com.zb.biz.VideoBiz;
import com.zb.entity.Video;
import com.zb.util.PageUtil;

@Service("video")
public class VideoBizImpl implements VideoBiz {

	public boolean addVideo(Video video){
		return false;
	}

	public boolean updateVideo(Video video){
		return false;
	}

	public boolean deleteVideo(Integer vid){
		return false;
	}

	public PageUtil<Video> searchVideo(String monitorName,Integer vid,Integer pid,Integer index,Integer size){
		return null;
	}

}
