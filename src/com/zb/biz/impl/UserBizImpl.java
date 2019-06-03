package com.zb.biz.impl;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.UserBiz;
import com.zb.entity.User;
import com.zb.entity.UserComb;
import com.zb.mapper.UserMapper;
import com.zb.util.PageUtil;

@Service("db_user")
public class UserBizImpl implements UserBiz {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public boolean addUser(User user){
		boolean flag = userMapper.addUser(user);
		
		return flag;
	}

	@Transactional
	public boolean updateUser(User user){
		boolean flag = userMapper.updateUser(user);
		
		return flag;
	}

	@Transactional
	public boolean deleteUser(Integer uid){
		boolean flag = userMapper.deleteUser(uid);
		
		return flag;
	}

	@Transactional
	public boolean login(String name,String password){
		if(name==null||password==null||"".equals(name)||"".equals(password)){
			return false;
		}
		if(userMapper.searchUserByName(name)!=null){
			if (password.equals(userMapper.searchUserByName(name).getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	
	public Integer searchCount(String name,Integer pid,Integer uid){
		Integer cnt = userMapper.searchCount(name, pid, uid);
		
		return cnt;
	}
	
	public PageUtil<UserComb> searchUser(String name,Integer pid,PageUtil<UserComb> page,Integer uid){
		List<UserComb> userCombs = userMapper.searchUser(name,pid,(page.getIndex() - 1) * page.getSize(), page.getSize(),uid);
		page.setPage(userCombs);
		
		int count = userMapper.searchCount(name,pid,uid);
		page.setCount(count);
		
		return page;
		

	}

	@Override
	public List<UserComb> selectUser(String name) {
		// TODO Auto-generated method stub
		List<UserComb> userCombs= userMapper.selectUser(name);
		return userCombs;
	}

	@Override
	public List<User> selectUserByUid(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUid(uid);
	}





}

