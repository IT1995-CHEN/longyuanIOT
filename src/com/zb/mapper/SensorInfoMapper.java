package com.zb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zb.entity.SensorInfo;


@Repository
public interface SensorInfoMapper {

	public List<SensorInfo> selectAllSensorName();
}
