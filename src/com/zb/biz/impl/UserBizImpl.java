package com.zb.biz.impl;

import org.springframework.stereotype.Service;

import com.zb.biz.UserBiz;
import com.zb.entity.User;
import com.zb.util.PageUtil;

@Service("db_user")
public class UserBizImpl implements UserBiz {

	public boolean addUser(User user){
		return false;
	}

	public boolean updateUser(User user){
		return false;
	}

	public boolean deleteUser(Integer uid){
		return false;
	}

	public PageUtil<User> searchUser(String name,Integer pid,Integer index,Integer size,Integer uid){
		return null;
	}

}
