package com.zb.biz;

import java.util.List;

import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorHisdataComb;
import com.zb.util.PageUtil;

public interface SensorHisdataBiz {

	public boolean addHisData(SensorHisdata sensorHis);

	public PageUtil<SensorHisdataComb> searchHisData(Integer pid,PageUtil<SensorHisdataComb> page,String deviceNum,String beginTime,String endTime);

	public List<SensorHisdataComb> selectHisData(Integer pid,String deviceDes);
}
