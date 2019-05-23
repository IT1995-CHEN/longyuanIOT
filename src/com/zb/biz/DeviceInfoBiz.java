package com.zb.biz;

import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;
import com.zb.util.PageUtil;

public interface DeviceInfoBiz {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(DeviceInfo device);

	public boolean deleteDevice(Integer did);

	public Integer searchCount(String projectName,String deviceName,String deviceNum);
	
	public PageUtil<DeviceComb> searchDevice(String projectName,String deviceName,String deviceNum,PageUtil<DeviceComb> page);
}
