package com.zb.biz;

import java.util.List;

import com.zb.entity.Warn;
import com.zb.entity.WarnComb;
import com.zb.util.PageUtil;

public interface WarnBiz {

	public boolean addWarn(Warn warn);

	public PageUtil<WarnComb> searchWarn(String deviceNum,String deviceDes,Integer pid,PageUtil<WarnComb> page,String warnInfo);
	
	public List<WarnComb> selectWarn(String deviceNum,String deviceDes);
	
	public List<WarnComb> selectDevWarn(Integer pid,String deviceDes);
	
	public List<String> selectDesWarn(Integer pid);
}
