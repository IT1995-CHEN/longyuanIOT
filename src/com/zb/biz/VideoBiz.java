package com.zb.biz;

import com.zb.entity.Video;
import com.zb.entity.VideoComb;
import com.zb.util.PageUtil;

public interface VideoBiz {


	public boolean addVideo(Video video);

	public boolean updateVideo(Video video);

	public boolean deleteVideo(Integer vid);
	
	public Integer searchCount(Integer pid,String monitorName,String monitorAdd,Integer vid);

	public PageUtil<VideoComb> searchVideo(Integer pid,String monitorName,String monitorAdd,Integer vid,PageUtil<VideoComb> page);

}
