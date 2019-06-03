package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.MenuBiz;
import com.zb.entity.Menu;
import com.zb.mapper.MenuMapper;


@Service("db_menu")
public class MenuBizImpl implements MenuBiz {

	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selectMenu(Integer pid) {
		// TODO Auto-generated method stub
		List<Menu> mList=menuMapper.selectMenu(pid);
		for (int i = 0; i < mList.size(); i++) {
			System.out.println();
		}
		return mList;
	}

	
}
