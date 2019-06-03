package com.zb.entity;

import java.util.List;

public class Menu {
	private Integer fid;
	private Integer pid;
	private List<SecondMenu> list;
	private String icon;
	private String nurl;
	private String mname;

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public List<SecondMenu> getList() {
		return list;
	}
	public void setList(List<SecondMenu> list) {
		this.list = list;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getNurl() {
		return nurl;
	}
	public void setNurl(String nurl) {
		this.nurl = nurl;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
