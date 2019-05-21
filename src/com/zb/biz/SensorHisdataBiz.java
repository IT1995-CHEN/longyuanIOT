package com.zb.biz;

import java.util.List;

import com.zb.entity.SensorHisdata;
import com.zb.util.PageUtil;

public interface SensorHisdataBiz {

	public boolean addHisData(SensorHisdata sensorHis);

	public PageUtil<SensorHisdata> searchHisData(Integer pid,Integer index,Integer size,String deviceNum,String beginTime,String endTime);

	public List<SensorHisdata> selectHisData(Integer pid,String deviceDes);
}
