package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.ProjectBiz;
import com.zb.entity.Project;
import com.zb.mapper.ProjectMapper;
import com.zb.util.PageUtil;

@Service("db_project")
public class ProjectBizImpl implements ProjectBiz {
	@Autowired
	private ProjectMapper projectMapper;

	@Transactional
	public boolean addProject(Project project){
		boolean flag = projectMapper.addProject(project); 
		
		return flag;
	}
	
	@Transactional
	public boolean updateProject(Project project){
		boolean flag = projectMapper.updateProject(project); 
		
		return flag;
	}
	
	@Transactional
	public boolean deleteProject(Integer pid){
		boolean flag = projectMapper.deleteProject(pid); 
		
		return flag;
	}
	
	public Integer searchCount(String projectName){
		Integer  cnt = projectMapper.searchCount(projectName);
		return cnt;
	}
	
	public PageUtil<Project> searchProject(String projectName,PageUtil<Project> page){
		List<Project> projects = projectMapper.searchProject(projectName,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(projects);
		
		int count = projectMapper.searchCount(projectName);
		page.setCount(count);
		
		return page;
	}
	
	public List<Project> selectProject(){
		List<Project> projects = projectMapper.selectProject();
		
		return projects;
	}
}
