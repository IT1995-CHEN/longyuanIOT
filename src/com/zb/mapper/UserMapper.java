package com.zb.mapper;

import java.util.List;


import com.zb.entity.User;

public interface UserMapper {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(Integer uid);

	public List<User> searchUser(String Name,Integer pid,Integer index,Integer size,Integer uid);

}
