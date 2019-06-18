package com.zb.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.WarnBiz;
import com.zb.entity.Warn;
import com.zb.entity.WarnComb;
import com.zb.mapper.WarnMapper;
import com.zb.util.PageUtil;
import com.zb.util.RemoveDupList;

@Service("db_warn")
public class WarnBizImpl implements WarnBiz {
	@Autowired
	private WarnMapper warnMapper;

	@Transactional
	public boolean addWarn(Warn warn){
		boolean flag = warnMapper.addWarn(warn);
		
		return flag;
	}

	public PageUtil<WarnComb> searchWarn(String deviceNum,String deviceDes,Integer pid,PageUtil<WarnComb> page,String warnInfo){
		List<WarnComb> warnCombs = warnMapper.searchWarn(deviceNum,deviceDes, pid, (page.getIndex() - 1) * page.getSize(), page.getSize(), warnInfo);
		page.setPage(warnCombs);
		
		int count = warnMapper.searchCount(deviceNum,deviceDes, pid, warnInfo);
		page.setCount(count);
		
		return page;
	}

	@Override
	public List<WarnComb> selectWarn(String deviceNum, String deviceDes) {
		// TODO Auto-generated method stub
		return warnMapper.selectWarn(deviceNum, deviceDes);
	}

	@Override
	public List<WarnComb> selectDevWarn(Integer pid, String deviceDes) {
		// TODO Auto-generated method stub
		List<WarnComb> wclistCombs = new ArrayList<>();
	    wclistCombs = warnMapper.selectByPidDWarn(pid,deviceDes);
		List<String> dList = new ArrayList<>();
		for (int i = 0; i < wclistCombs.size(); i++) {
			String deviceNum =wclistCombs.get(i).getDeviceInfo().getDeviceNum();
			dList.add(deviceNum);
			System.out.println(deviceNum);
		}
		RemoveDupList removeDupList = new RemoveDupList();
		removeDupList.removeDupString(dList);
		List<WarnComb> wcList = new ArrayList<>();
		for (int i = 0; i < dList.size(); i++) {
			System.out.println(dList.get(i));
			List<WarnComb> warnCombs = new ArrayList<>();
			if (deviceDes==null || deviceDes.equals("")) {
				warnCombs =  warnMapper.selectWarn(dList.get(i),"");
			}else {
				warnCombs =  warnMapper.selectWarn(dList.get(i), deviceDes);
			}
			
		    WarnComb warnComb = new WarnComb();
//		    if (!warnComb.getDeviceInfo().getDeviceName().equals("")||warnComb.getDeviceInfo().getDeviceName()!=null) {
//		    	   warnComb = warnCombs.get(0);
//			}
		    warnComb = warnCombs.get(0);
		    System.out.println("======="+warnCombs.size());
		   
		    wcList.add(warnComb);
		}
		
		
		return wcList;
	}

	@Override
	public List<String> selectDesWarn(Integer pid) {
		// TODO Auto-generated method stub
		List<WarnComb> wclistCombs= warnMapper.selectByPidDWarn(pid,"");
		List<String> dList = new ArrayList<>();
		for (int i = 0; i < wclistCombs.size(); i++) {
			String deviceDes =wclistCombs.get(i).getDeviceInfo().getDeviceDes();
			dList.add(deviceDes);
			System.out.println(deviceDes);
		}
		RemoveDupList removeDupList = new RemoveDupList();
		removeDupList.removeDupString(dList);
		return dList;
	}


}
