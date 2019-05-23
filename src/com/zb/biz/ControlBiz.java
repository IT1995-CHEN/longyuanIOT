package com.zb.biz;

import java.util.List;

import com.zb.entity.Control;

public interface ControlBiz {

	public boolean addControl(Control control);

	public boolean updateControl(Control control);
	
	public boolean deleteControlCid(Integer cid);
	
	public boolean deleteControlDeviceNum(String deviceNum);
	
	public List<Control> selectControl(String deviceNum);
}
