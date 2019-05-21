package com.zb.biz.impl;

import org.springframework.stereotype.Service;

import com.zb.biz.DeviceInfoBiz;
import com.zb.entity.DeviceInfo;
import com.zb.util.PageUtil;

@Service("db_deviceInfo")
public class DeviceInfoBizImpl implements DeviceInfoBiz {

	public boolean addDevice(DeviceInfo device){
		return false;
	}

	public boolean updateDevice(DeviceInfo device){
		return false;
	}

	public boolean deleteDevice(Integer did){
		return false;
	}

	public PageUtil<DeviceInfo> searchDevice(String projectName,String deviceName,String deviceNum,Integer index,Integer size){
		return null;
	}
}
