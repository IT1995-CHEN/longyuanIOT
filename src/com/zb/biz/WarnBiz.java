package com.zb.biz;

import com.zb.entity.Warn;
import com.zb.entity.WarnComb;
import com.zb.util.PageUtil;

public interface WarnBiz {

	public boolean addWarn(Warn warn);

	public PageUtil<WarnComb> searchWarn(String deviceNum,Integer pid,PageUtil<WarnComb> page,String warnInfo);
	
}
