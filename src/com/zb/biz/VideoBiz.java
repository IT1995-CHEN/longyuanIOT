package com.zb.biz;

import java.util.List;

import com.zb.entity.Video;
import com.zb.entity.VideoComb;
import com.zb.util.PageUtil;

public interface VideoBiz {

	public boolean addVideo(Video video);

	public boolean updateVideo(Video video);

	public boolean deleteVideo(Integer vid);
	
	public Integer searchCount(Integer pid,String monitorName,String monitorAdd,String monitorArea,Integer vid);

	public PageUtil<VideoComb> searchVideo(Integer pid,String monitorName,String monitorAdd,String monitorArea,Integer vid,PageUtil<VideoComb> page);

	public List<VideoComb> selectVideo(Integer pid,String monitorName,String monitorAdd,String monitorArea,Integer vid);
}
