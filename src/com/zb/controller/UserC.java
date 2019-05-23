package com.zb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.UserBiz;
import com.zb.entity.User;
import com.zb.entity.UserComb;
import com.zb.util.PageUtil;

@Controller
public class UserC {

	@Autowired
	private UserBiz userBiz;
	
	@ResponseBody
	@RequestMapping("/addUser")
	public Map<String,String> addUser(User user) {
		boolean f = userBiz.addUser(user);
		Map<String,String> map = new HashMap<String,String>();
		if(f==true) {
			map.put("yes", "添加成功");
		}else {
			map.put("no", "添加失败");
		}
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping("/updateUser")
	public Map<String,String> updateProject(User user) {
		boolean f = userBiz.updateUser(user);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","修改成功!");
		}else {
			map.put("no","修改失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/deleteUser")
	public Map<String,String> deleteUser(Integer uid) {
		boolean f = userBiz.deleteUser(uid);
		Map<String,String> map = new HashMap<String, String>();
		if(f==true) {
			map.put("yes","删除成功!");
		}else {
			map.put("no","删除失败!");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/searchUser")
	public PageUtil<UserComb> searchUser(String name,Integer pid,Integer index,Integer size,Integer uid){
		PageUtil<UserComb> page = new PageUtil<UserComb>();
		if(index!=null&&!index.equals("")) {
			page.setIndex(index);
		}
		if(size!=null&&!size.equals("")) {
			page.setSize(size);
		}
		PageUtil<UserComb> pageUtil = userBiz.searchUser(name, pid, page, uid);
		return pageUtil;
	}

}
