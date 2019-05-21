package com.zb.mapper;

import java.util.List;

import com.zb.entity.Warn;

public interface WarnMapper {

	public boolean addWarn(Warn warn);

	public List<Warn> searchWarn(Integer pid,Integer index,Integer size,String deviceNum,String warnInfo);
}
