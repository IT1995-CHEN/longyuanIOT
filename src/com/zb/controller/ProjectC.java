package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ProjectBiz;
import com.zb.entity.Project;
import com.zb.util.PageUtil;

@Controller
public class ProjectC {

	@Autowired
	private ProjectBiz projectBiz;
	
	@ResponseBody
	@RequestMapping("/addProject")
	public Map<String,String> addProject(Project project) {
		boolean f = projectBiz.addProject(project);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","添加成功!");
		}else {
			map.put("no","添加失败!");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/updateProject")
	public Map<String,String> updateProject(Project project) {
		boolean f = projectBiz.updateProject(project);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","修改成功!");
		}else {
			map.put("no","修改失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/deleteProject")
	public Map<String,String> deleteProject(Integer pid) {
		boolean f = projectBiz.deleteProject(pid);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","删除成功!");
		}else {
			map.put("no","删除失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/searchProject")
	public PageUtil<Project> searchProject(String projectName,Integer index,Integer size){
		PageUtil<Project> page = new PageUtil<Project>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<Project> pageUtil = projectBiz.searchProject(projectName,page);
		return pageUtil;
	}
	
	@ResponseBody
	@RequestMapping("/selectProject")
	public List<Project> selectProject(){
		List<Project> projectList = projectBiz.selectProject();
		
		return projectList;
	}
}
