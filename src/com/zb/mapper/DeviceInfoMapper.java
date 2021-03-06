package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;

public interface DeviceInfoMapper {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(DeviceInfo device);

	public boolean deleteDevice(@Param("did")Integer did);

	public Integer searchCount(@Param("projectName")String projectName,@Param("deviceName")String deviceName,@Param("deviceNum")String deviceNum,@Param("deviceDes")String deviceDes);
	
	public List<DeviceComb> searchDevice(@Param("projectName")String projectName,@Param("deviceName")String deviceName,@Param("deviceNum")String deviceNum,@Param("deviceDes")String deviceDes,@Param("index")Integer index,@Param("size")Integer size);
	
	public List<DeviceInfo> selectDevice(@Param("did")Integer did,@Param("pid")Integer pid,@Param("projectName")String projectName,@Param("deviceName")String deviceName,@Param("deviceNum")String deviceNum,@Param("deviceDes")String deviceDes);

	public List<DeviceInfo> selectByDeviceNum(@Param("deviceNum") String deviceNum);
}
