package com.zb.mapper;

import java.util.List;

import com.zb.entity.Video;

public interface VideoMapper {

	public boolean addVideo(Video video);

	public boolean updateVideo(Video video);

	public boolean deleteVideo(Integer vid);

	public List<Video> searchVideo(String monitorName,Integer vid,Integer pid,Integer index,Integer size);

	
}
