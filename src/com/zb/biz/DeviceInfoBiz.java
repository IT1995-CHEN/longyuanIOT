package com.zb.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;
import com.zb.util.PageUtil;

public interface DeviceInfoBiz {

	public boolean addDevice(DeviceInfo device);

	public boolean updateDevice(DeviceInfo device);

	public boolean deleteDevice(Integer did);

	public Integer searchCount(String projectName,String deviceName,String deviceNum,String deviceDes);
	
	public PageUtil<DeviceComb> searchDevice(String projectName,String deviceName,String deviceNum,String deviceDes,PageUtil<DeviceComb> page);

	public List<DeviceInfo> selectDevice(Integer did,Integer pid,String projectName,String deviceName,String deviceNum,String deviceDes);
}
