package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.DeviceInfo;

public interface DeviceInfoMapper {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(@Param("did")Integer did,@Param("deviceName")String deviceName,@Param("deviceDes")String deviceDes);

	public boolean deleteDevice(Integer did);

	public List<DeviceInfo> searchDevice(String projectName,String deviceName,String deviceNum,Integer index,Integer size);

}
