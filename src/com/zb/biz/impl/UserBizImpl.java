package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.UserBiz;
import com.zb.entity.Project;
import com.zb.entity.User;
import com.zb.mapper.UserMapper;
import com.zb.util.PageUtil;

@Service("db_user")
public class UserBizImpl implements UserBiz {
	@Autowired
	private UserMapper userMapper;

	public boolean addUser(User user){
		boolean flag = userMapper.addUser(user);
		
		return flag;
	}

	public boolean updateUser(User user){
		boolean flag = userMapper.updateUser(user);
		
		return flag;
	}

	public boolean deleteUser(Integer uid){
		boolean flag = userMapper.deleteUser(uid);
		
		return flag;
	}

	public PageUtil<User> searchUser(String name,Integer pid,PageUtil<User> page,Integer uid){
		List<User> users = userMapper.searchUser(name,pid,(page.getIndex() - 1) * page.getSize(), page.getSize(),uid);
		page.setPage(users);
		
		int count = userMapper.searchCount(name,pid,uid);
		page.setCount(count);
		
		return page;
	}

}
