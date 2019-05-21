package com.zb.biz;

import com.zb.entity.SensorNowdata;
import com.zb.util.PageUtil;

public interface SensorNowdataBiz {

	public boolean addNowData(SensorNowdata sensorNow);

	public boolean updateNowData(SensorNowdata sensorNow);

	public PageUtil<SensorNowdata> searchNowData(String deviceNum,Integer pid);

}
