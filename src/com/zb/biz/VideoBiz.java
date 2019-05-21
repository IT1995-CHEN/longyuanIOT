package com.zb.biz;

import com.zb.entity.Video;
import com.zb.util.PageUtil;

public interface VideoBiz {


	public boolean addVideo(Video video);

	public boolean updateVideo(Video video);

	public boolean deleteVideo(Integer vid);

	public PageUtil<Video> searchVideo(String monitorName,Integer vid,Integer pid,Integer index,Integer size);

}
