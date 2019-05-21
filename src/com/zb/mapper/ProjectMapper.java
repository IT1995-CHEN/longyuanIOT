package com.zb.mapper;

import java.util.List;

import com.zb.entity.Project;

public interface ProjectMapper {
	
	public boolean addProject(Project project);
	
	public boolean updateProject(Project project);
	
	public boolean deleteProject(Integer pid);
	
	public List<Project> searchProject(String projectName,Integer index,Integer size);
	
	public List<Project> selectProject();

}
