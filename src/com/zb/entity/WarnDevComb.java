package com.zb.entity;

import java.util.List;

public class WarnDevComb {

	private String deviceNum;
	private String deviceName;
	private String deviceDes;
	private List<Warn> wlist;
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceDes() {
		return deviceDes;
	}
	public void setDeviceDes(String deviceDes) {
		this.deviceDes = deviceDes;
	}
	public List<Warn> getWlist() {
		return wlist;
	}
	public void setWlist(List<Warn> wlist) {
		this.wlist = wlist;
	}
	
}
