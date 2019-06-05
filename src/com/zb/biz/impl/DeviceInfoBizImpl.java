package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.DeviceInfoBiz;
import com.zb.entity.Control;
import com.zb.entity.DeviceComb;
import com.zb.entity.DeviceInfo;
import com.zb.mapper.ControlMapper;
import com.zb.mapper.DeviceInfoMapper;
import com.zb.util.PageUtil;

@Service("db_deviceInfo")
public class DeviceInfoBizImpl implements DeviceInfoBiz {
	@Autowired
	private DeviceInfoMapper deviceInfoMapper;
	@Autowired
	private ControlMapper controlMapper;
	@Transactional
	public boolean addDevice(DeviceInfo device){
		try {
			boolean flag = deviceInfoMapper.addDevice(device);
			
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	
	}

	@Transactional
	public boolean updateDevice(DeviceInfo device){
		boolean flag = deviceInfoMapper.updateDevice(device);
		
		return flag;
	}

	@Transactional
	public boolean deleteDevice(Integer did){
		boolean flag = deviceInfoMapper.deleteDevice(did);
		return flag;
	}

	public Integer searchCount(String projectName,String deviceName,String deviceNum,String deviceDes){
		Integer cnt = deviceInfoMapper.searchCount(projectName, deviceName, deviceNum,deviceDes);
		return cnt;
	}
	
	public PageUtil<DeviceComb> searchDevice(String projectName,String deviceName,String deviceNum,String deviceDes,PageUtil<DeviceComb> page){
		List<DeviceComb> deviceCombs = deviceInfoMapper.searchDevice(projectName,deviceName,deviceNum,deviceDes,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(deviceCombs);
		
		int count = deviceInfoMapper.searchCount(projectName, deviceName, deviceNum,deviceDes);
		page.setCount(count);
		
		return page;
	}

	@Override
	public List<DeviceInfo> selectDevice(Integer did, Integer pid,
			String projectName, String deviceName, String deviceNum ,String deviceDes) {
		// TODO Auto-generated method stub
		return deviceInfoMapper.selectDevice(did, pid, projectName, deviceName, deviceNum,deviceDes);
	}
}
