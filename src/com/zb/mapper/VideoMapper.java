package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Video;
import com.zb.entity.VideoComb;

public interface VideoMapper {

	public boolean addVideo(Video video);

	public boolean updateVideo(Video video);

	public boolean deleteVideo(@Param("vid")Integer vid);
	
	public Integer searchCount(@Param("pid")Integer pid,@Param("monitorName")String monitorName,@Param("monitorAdd")String monitorAdd,@Param("monitorArea")String monitorArea,@Param("vid")Integer vid);

	public List<VideoComb> searchVideo(@Param("pid")Integer pid,@Param("monitorName")String monitorName,@Param("monitorAdd")String monitorAdd,@Param("monitorArea")String monitorArea,@Param("vid")Integer vid,@Param("index")Integer index,@Param("size")Integer size);

	public List<VideoComb> selectVideo(@Param("pid")Integer pid,@Param("monitorName")String monitorName,@Param("monitorAdd")String monitorAdd,@Param("monitorArea")String monitorArea,@Param("vid")Integer vid);
}
