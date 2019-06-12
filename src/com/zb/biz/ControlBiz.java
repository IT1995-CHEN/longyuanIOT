package com.zb.biz;

import java.util.List;

import com.zb.entity.Control;
import com.zb.entity.ControlDev;

public interface ControlBiz {

	public boolean addControl(Control control);

	public boolean updateControl(Control control);
	
	public boolean deleteControlCid(Integer cid);
	
	public boolean deleteControlDeviceNum(String deviceNum);
	
	public List<Control> selectControl(String deviceNum);
	
	public List<ControlDev> selectControlDev(String deviceNum,Integer pid);
}
