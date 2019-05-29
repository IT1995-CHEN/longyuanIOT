package com.zb.entity;

import java.util.List;


public class SensorCount {
	private  String tableNameString;
	private  List<String> sensorNameList;
	private  List<Integer> sensorCountList;
	
	public String getTableNameString() {
		return tableNameString;
	}
	public void setTableNameString(String tableNameString) {
		this.tableNameString = tableNameString;
	}
	public List<String> getSensorNameList() {
		return sensorNameList;
	}
	public void setSensorNameList(List<String> sensorNameList) {
		this.sensorNameList = sensorNameList;
	}
	public List<Integer> getSensorCountList() {
		return sensorCountList;
	}
	public void setSensorCountList(List<Integer> sensorCountList) {
		this.sensorCountList = sensorCountList;
	}
	
	
}
