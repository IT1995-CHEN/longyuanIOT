package com.zb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zb.entity.Control;
import com.zb.entity.ControlDev;

public interface ControlMapper {

	public boolean addControl(Control control);
	
	public boolean updateControl(Control control);
	
	public boolean deleteControlCid(@Param("cid")Integer cid);
	
	public boolean deleteControlDeviceNum(@Param("deviceNum")String deviceNum);

	public List<Control> selectControl(@Param("deviceNum")String deviceNum);
	
	public Integer countControlByDeviceNum(@Param("deviceNum")String deviceNum);
	
	public List<ControlDev> selectControlDev(@Param("deviceNum")String deviceNum,@Param("pid")Integer pid);

}
