package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.WarnBiz;
import com.zb.entity.Warn;
import com.zb.entity.WarnComb;
import com.zb.mapper.WarnMapper;
import com.zb.util.PageUtil;

@Service("db_warn")
public class WarnBizImpl implements WarnBiz {
	@Autowired
	private WarnMapper warnMapper;

	public boolean addWarn(Warn warn){
		boolean flag = warnMapper.addWarn(warn);
		
		return flag;
	}

	public PageUtil<WarnComb> searchWarn(String deviceNum,Integer pid,PageUtil<WarnComb> page,String warnInfo){
		List<WarnComb> warnCombs = warnMapper.searchWarn(deviceNum, pid, (page.getIndex() - 1) * page.getSize(), page.getSize(), warnInfo);
		page.setPage(warnCombs);
		
		int count = warnMapper.searchCount(deviceNum, pid, warnInfo);
		page.setCount(count);
		
		return page;
	}
	
}
