package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.VideoBiz;
import com.zb.entity.Video;
import com.zb.entity.VideoComb;
import com.zb.mapper.VideoMapper;
import com.zb.util.PageUtil;

@Service("db_video")
public class VideoBizImpl implements VideoBiz {
	@Autowired
	private VideoMapper videoMapper;

	@Transactional
	public boolean addVideo(Video video){
		boolean flag = videoMapper.addVideo(video);
		
		return flag;
	}

	@Transactional
	public boolean updateVideo(Video video){
		boolean flag = videoMapper.updateVideo(video);
		
		return flag;
	}

	@Transactional
	public boolean deleteVideo(Integer vid){
		boolean flag = videoMapper.deleteVideo(vid);
		
		return flag;
	}

	public Integer searchCount(Integer pid,String monitorName,String monitorAdd,Integer vid) {
		Integer cnt = videoMapper.searchCount(pid, monitorName, monitorAdd, vid);
		return cnt;
	}

	public PageUtil<VideoComb> searchVideo(Integer pid,String monitorName,String monitorAdd,Integer vid,PageUtil<VideoComb> page){
		List<VideoComb> videoCombs = videoMapper.searchVideo(pid,monitorName,monitorAdd,vid,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(videoCombs);
		
		int count = videoMapper.searchCount(pid, monitorName, monitorAdd, vid);
		page.setCount(count);
		
		return page;
	}

}
