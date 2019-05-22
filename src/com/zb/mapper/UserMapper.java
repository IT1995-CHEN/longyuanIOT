package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.User;

public interface UserMapper {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(@Param("uid")Integer uid);

	public Integer searchCount(@Param("name")String name,@Param("pid")Integer pid,@Param("uid")Integer uid);
	
	public List<User> searchUser(@Param("name")String name,@Param("pid")Integer pid,@Param("index")Integer index,@Param("size")Integer size,@Param("uid")Integer uid);

}
