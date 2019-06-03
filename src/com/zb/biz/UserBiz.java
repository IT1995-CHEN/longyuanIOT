package com.zb.biz;

import java.util.List;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.zb.entity.User;
import com.zb.entity.UserComb;
import com.zb.util.PageUtil;

public interface UserBiz {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(Integer uid);

	public boolean login(String name,String password);
	
	public Integer searchCount(String name,Integer pid,Integer uid);
	
	public PageUtil<UserComb> searchUser(String name,Integer pid,PageUtil<UserComb> page,Integer uid);

	public List<UserComb> selectUser(String name);
	
	public List<User> selectUserByUid(Integer uid);


}
