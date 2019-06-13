package com.zb.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zb.biz.ControlBiz;
import com.zb.biz.ControlLogBiz;
import com.zb.entity.ControlComb;
import com.zb.entity.ControlLog;
import com.zb.entity.ControlLogComb;
import com.zb.entity.SensorHisdata;
import com.zb.entity.SensorNowdata;
import com.zb.mapper.ControlLogMapper;
import com.zb.mapper.ControlMapper;
import com.zb.util.PageUtil;
@Service("db_controllog")
public class ControlLogBizImpl implements ControlLogBiz {
	@Autowired
	private ControlLogMapper controlLogMapper;
	@Autowired
	private ControlMapper controlMapper;

	
	@Transactional
	public boolean addControlLog(ControlLog controlLog){
	
		boolean flag = controlLogMapper.addControlLog(controlLog);
		return flag;
	}
	
	
	public PageUtil<ControlLogComb> searchControlLog(String deviceNum,String hisstate,String hisinfo,
			Integer taskNum,String operationOrder,String person,
			String kind,String qualConfig,String minVal,String maxVal,
			String beginTime,String endTime,String duration,PageUtil<ControlLogComb> page){
		List<ControlLogComb> controlLogCombs = controlLogMapper.searchControlLog(deviceNum,hisstate,hisinfo,
				taskNum,operationOrder,person,kind,qualConfig,minVal,maxVal,
				beginTime,endTime,duration,(page.getIndex() - 1) * page.getSize(), page.getSize());
		page.setPage(controlLogCombs);
		
		int count = controlLogMapper.searchCount(deviceNum, hisstate, hisinfo, taskNum, operationOrder, person, 
				kind, qualConfig, minVal, maxVal, beginTime, endTime, duration);
		page.setCount(count);
		
		return page;
	}


	@Override
	public ControlComb selectControlComb(String deviceNum) {
		// TODO Auto-generated method stub
		ControlComb controlComb = new ControlComb();
		controlComb.setDeviceNum(deviceNum);
		controlComb.setHandControl(controlMapper.selectControl(deviceNum));
		//任务1
		List<ControlLogComb> controlLogL1 = new ArrayList<>();
		ControlLogComb controlLog1 = new ControlLogComb();
		if (controlLogMapper.selectControlComb(deviceNum,1).size()!=0) {
			controlLog1 = controlLogMapper.selectControlComb(deviceNum,1).get(0);
			controlLogL1.add(controlLog1);
		}else {
			controlLog1.setBeginTime("00:00");
			controlLog1.setEndTime("00:00");
			controlLog1.setHisstate("0");
			controlLogL1.add(controlLog1);
		}
		//任务2
		List<ControlLogComb> controlLogL2= new ArrayList<>();
		ControlLogComb controlLog2 = new ControlLogComb();
		if (controlLogMapper.selectControlComb(deviceNum,2).size()!=0) {
			System.out.println(controlLogMapper.selectControlComb(deviceNum,2).size());
		   controlLog2 = controlLogMapper.selectControlComb(deviceNum,2).get(0);
			controlLogL2.add(controlLog2);
		}else {
			controlLog2.setBeginTime("00:00");
			controlLog2.setEndTime("00:00");
			controlLog2.setHisstate("0");
			controlLogL2.add(controlLog2);
		}
	
		
		//任务3
		List<ControlLogComb> controlLogL3= new ArrayList<>();
		ControlLogComb controlLog3 = new ControlLogComb();
		if (controlLogMapper.selectControlComb(deviceNum,3).size()!=0) {
			
		 controlLog3 = controlLogMapper.selectControlComb(deviceNum,3).get(0);
			controlLogL3.add(controlLog3);
		}else{
			controlLog3.setBeginTime("00:00");
			controlLog3.setEndTime("00:00");
			controlLog3.setHisstate("0");
			controlLogL3.add(controlLog3);
		}
		controlComb.setTask1(controlLogL1);
		controlComb.setTask2(controlLogL2);
		controlComb.setTask3(controlLogL3);
		
		return controlComb;
	}


	@Override
	public List<ControlLog> selectOneControlLog(String deviceNum) {
		// TODO Auto-generated method stub
		List<ControlLog> controlLogs= new ArrayList<>();
		ControlLog controlLog = new ControlLog();
		if (controlLogMapper.selectControlLog(deviceNum).size()!=0) {
			controlLog =  controlLogMapper.selectControlLog(deviceNum).get(0);
			controlLogs.add(controlLog);
			return controlLogs;
		}else {
			controlLog.setDeviceNum(deviceNum);
			controlLog.setMinVal("0");
			controlLog.setMaxVal("0");
			controlLogs.add(controlLog);
			return controlLogs;
		}
		
	}
		

}
