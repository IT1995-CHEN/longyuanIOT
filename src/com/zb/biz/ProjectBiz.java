package com.zb.biz;

import java.util.List;

import com.zb.entity.Project;
import com.zb.util.PageUtil;

public interface ProjectBiz {

	public boolean addProject(Project project);
	
	public boolean updateProject(Project project);
	
	public boolean deleteProject(Integer pid);
	
	public Integer searchCount(String projectName);
	
	public PageUtil<Project> searchProject(String projectName,PageUtil<Project> page);
	
	public List<Project> selectProject();
}
