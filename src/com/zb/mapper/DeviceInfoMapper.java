package com.zb.mapper;

import java.util.List;

import com.zb.entity.DeviceInfo;

public interface DeviceInfoMapper {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(DeviceInfo device);

	public boolean deleteDevice(Integer did);

	public List<DeviceInfo> searchDevice(String projectName,String deviceName,String deviceNum,Integer index,Integer size);

}
