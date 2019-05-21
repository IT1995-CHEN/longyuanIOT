package com.zb.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zb.biz.ProjectBiz;
import com.zb.entity.Project;
import com.zb.util.PageUtil;

@Service("db_project")
public class ProjectBizImpl implements ProjectBiz {

	public boolean addProject(Project project){
		return false;
	}
	
	public boolean updateProject(Project project){
		return false;
	}
	
	public boolean deleteProject(Integer pid){
		return false;
	}
	
	public PageUtil<Project> searchProject(String projectName,Integer index,Integer size){
		return null;
	}
	
	public List<Project> selectProject(){
		return null;
	}
}
