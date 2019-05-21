package com.zb.biz;

import com.zb.entity.DeviceInfo;
import com.zb.util.PageUtil;

public interface DeviceInfoBiz {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(DeviceInfo device);

	public boolean deleteDevice(Integer did);

	public PageUtil<DeviceInfo> searchDevice(String projectName,String deviceName,String deviceNum,Integer index,Integer size);
}
