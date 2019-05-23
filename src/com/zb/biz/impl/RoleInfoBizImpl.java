package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.RoleInfoBiz;
import com.zb.entity.RoleInfo;
import com.zb.mapper.RoleInfoMapper;

@Service("db_roleInfo")
public class RoleInfoBizImpl implements RoleInfoBiz {
	@Autowired
	private RoleInfoMapper roleInfoMapper;

	public List<RoleInfo> selectRole(){
		List<RoleInfo> roleInfos = roleInfoMapper.selectRole();
		
		return roleInfos;
	}
}
