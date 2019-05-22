package com.zb.biz;

import java.util.List;

import com.zb.entity.SensorNowdata;
import com.zb.entity.SensorNowdataComb;

public interface SensorNowdataBiz {

	public boolean addNowData(SensorNowdata sensorNow);

	public boolean updateNowData(SensorNowdata sensorNow);

	public List<SensorNowdataComb> selectNowData(String deviceNum,Integer pid);

}
