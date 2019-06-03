package com.zb.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zb.biz.SensorInfoBiz;
import com.zb.entity.SensorInfo;
import com.zb.mapper.SensorInfoMapper;


@Service("db_sensorinfo")
public class SensorInfoBizImpl implements SensorInfoBiz{

	@Autowired
	private SensorInfoMapper sensorInfoMapper;
	@Override
	public List<SensorInfo> selectAllSensorName() {
		// TODO Auto-generated method stub
		return sensorInfoMapper.selectAllSensorName();
	}

}
