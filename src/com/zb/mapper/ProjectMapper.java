package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Project;

public interface ProjectMapper {
	
	public boolean addProject(Project project);
	
	public boolean updateProject(Project project);
	
	public boolean deleteProject(@Param("pid")Integer pid);
	
	public Integer searchCount(@Param("projectName")String projectName);
	
	public List<Project> searchProject(@Param("projectName")String projectName,@Param("index")Integer index,@Param("size")Integer size);
	
	public List<Project> selectProject();

}
