package com.zb.biz;

import com.zb.entity.User;
import com.zb.entity.UserComb;
import com.zb.util.PageUtil;

public interface UserBiz {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(Integer uid);

	public PageUtil<UserComb> searchUser(String name,Integer pid,PageUtil<UserComb> page,Integer uid);

}
