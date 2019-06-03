package com.zb.biz;

import java.util.List;

import com.zb.entity.Menu;

public interface MenuBiz {

	public List<Menu> selectMenu(Integer pid);
}
