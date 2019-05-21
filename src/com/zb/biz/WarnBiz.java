package com.zb.biz;

import com.zb.entity.Warn;
import com.zb.util.PageUtil;

public interface WarnBiz {

	public boolean addWarn(Warn warn);

	public PageUtil<Warn> searchWarn(Integer pid,Integer index,Integer size,String deviceNum,String warnInfo);
	
}
