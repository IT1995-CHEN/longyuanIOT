package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Control;

public interface ControlMapper {

	public boolean addControl(Control control);
	
	public boolean updateControl(Control control);
	
	public boolean deleteControlCid(@Param("cid")Integer cid);
	
	public boolean deleteControlDeviceNum(@Param("deviceNum")String deviceNum);

	public List<Control> selectControl(@Param("deviceNum")String deviceNum);

}
