package com.zb.entity;

import java.util.List;

public class ControlComb {

	private String deviceNum;
	private List<Control>    handControl;
	private List<ControlLogComb> task1;
	private List<ControlLogComb> task2;
	private List<ControlLogComb> task3;
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public List<Control> getHandControl() {
		return handControl;
	}
	public void setHandControl(List<Control> handControl) {
		this.handControl = handControl;
	}
	public List<ControlLogComb> getTask1() {
		return task1;
	}
	public void setTask1(List<ControlLogComb> task1) {
		this.task1 = task1;
	}
	public List<ControlLogComb> getTask2() {
		return task2;
	}
	public void setTask2(List<ControlLogComb> task2) {
		this.task2 = task2;
	}
	public List<ControlLogComb> getTask3() {
		return task3;
	}
	public void setTask3(List<ControlLogComb> task3) {
		this.task3 = task3;
	}

}
