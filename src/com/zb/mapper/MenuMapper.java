package com.zb.mapper;

import java.util.List;

import com.zb.entity.Menu;

public interface MenuMapper {
	
	public List<Menu> selectMenu(Integer pid);
}
