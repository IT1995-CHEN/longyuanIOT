package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.DeviceInfoBiz;
import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;
import com.zb.mapper.DeviceInfoMapper;
import com.zb.util.PageUtil;

@Service("db_deviceInfo")
public class DeviceInfoBizImpl implements DeviceInfoBiz {
	@Autowired
	private DeviceInfoMapper deviceInfoMapper;

	public boolean addDevice(DeviceInfo device){
		boolean flag = deviceInfoMapper.addDevice(device);
		
		return flag;
	}

	public boolean updateDevice(DeviceInfo device){
		boolean flag = deviceInfoMapper.updateDevice(device);
		
		return flag;
	}

	public boolean deleteDevice(Integer did){
		boolean flag = deviceInfoMapper.deleteDevice(did);
		
		return flag;
	}

	public Integer searchCount(String projectName,String deviceName,String deviceNum){
		Integer cnt = deviceInfoMapper.searchCount(projectName, deviceName, deviceNum);
		return cnt;
	}
	
	public PageUtil<DeviceComb> searchDevice(String projectName,String deviceName,String deviceNum,PageUtil<DeviceComb> page){
		List<DeviceComb> deviceCombs = deviceInfoMapper.searchDevice(projectName,deviceName,deviceNum,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(deviceCombs);
		
		int count = deviceInfoMapper.searchCount(projectName, deviceName, deviceNum);
		page.setCount(count);
		
		return page;
	}
}
