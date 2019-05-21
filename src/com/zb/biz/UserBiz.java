package com.zb.biz;

import com.zb.entity.User;
import com.zb.util.PageUtil;

public interface UserBiz {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(Integer uid);

	public PageUtil<User> searchUser(String name,Integer pid,Integer index,Integer size,Integer uid);

}
