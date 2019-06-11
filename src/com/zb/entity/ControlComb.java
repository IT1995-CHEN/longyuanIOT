package com.zb.entity;

import java.util.List;

public class ControlComb {

	private String deviceNum;
	private List<Control>    handControl;
	private List<ControlLog> task1;
	private List<ControlLog> task2;
	private List<ControlLog> task3;

	public List<Control> getHandControl() {
		return handControl;
	}
	public void setHandControl(List<Control> handControl) {
		this.handControl = handControl;
	}
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public List<ControlLog> getTask1() {
		return task1;
	}
	public void setTask1(List<ControlLog> task1) {
		this.task1 = task1;
	}
	public List<ControlLog> getTask2() {
		return task2;
	}
	public void setTask2(List<ControlLog> task2) {
		this.task2 = task2;
	}
	public List<ControlLog> getTask3() {
		return task3;
	}
	public void setTask3(List<ControlLog> task3) {
		this.task3 = task3;
	}
	
}
