package com.zb.biz.impl;

import org.springframework.stereotype.Service;

import com.zb.biz.WarnBiz;
import com.zb.entity.Warn;
import com.zb.util.PageUtil;

@Service("db_warn")
public class WarnBizImpl implements WarnBiz {

	public boolean addWarn(Warn warn){
		return false;
	}

	public PageUtil<Warn> searchWarn(Integer pid,Integer index,Integer size,String deviceNum,String warnInfo){
		return null;
	}
	
}
