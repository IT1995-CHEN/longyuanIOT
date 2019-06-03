package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.servlet.ModelAndView;

import com.zb.biz.ControlBiz;
import com.zb.biz.ControlLogBiz;
import com.zb.entity.Control;
import com.zb.entity.ControlLog;


@Controller
public class RedirectC {

	@Autowired
	private ControlBiz controlBiz;
	@Autowired
	private ControlLogBiz controlLogBiz;
	
	@ResponseBody
	@RequestMapping(value="redirectControl")
	public Map<String,String> Redirect(String gate, String op) {
		gate="Reg0000001";
		op ="atFeedTimerConfig=4,15,24,1200,1";
	

		Map<String,String> map1=new HashMap<>();
		map1.put("ok", "控制表联动出现异常");
		
		
		//操作命令和操作历史
		String[] operation = op.split("=");
		for (int i = 0; i < operation.length; i++) {
			System.out.println(operation[i]);
		}
		//操作命令
		System.out.println(operation[0]);
		//操作命令最后一位（开关状态）
		String nowState = operation[1].substring(operation[1].length()-1, operation[1].length());
		System.out.println(operation[1].substring(operation[1].length()-1, operation[1].length()));
	
		//查询当前操作的历史状态值
		List<Control> nclist= controlBiz.selectControl(gate);
		String hisDeviceNum= nclist.get(0).getDeviceNum();
		System.out.println(hisDeviceNum);
		String hisOperationState=nclist.get(0).getOperationState();
		System.out.println(hisOperationState);
				
//		//历史控制表中数据插入
//		ControlLog controlLog = new ControlLog();
//		controlLog.setHisinfo(op);
//		controlLog.setDeviceNum(gate);
/*		controlLog*/
		//操作指令判断存入历史控制表中的数据格式
		switch (operation[0]) {
		//手动投料
		case "atFeedManual":
			System.out.println("atFeedManual1");
			//历史控制表中数据插入
			ControlLog controlLog = new ControlLog();
			controlLog.setHisinfo(op);
			controlLog.setDeviceNum(gate);
			controlLog.setHisstate(nowState);
			controlLog.setKind("手动投料开关");
			controlLog.setPerson("硬件操作");
			controlLog.setOperationOrder(operation[0]);
			controlLog.setOperationOrder(operation[0]);
			controlLogBiz.addControlLog(controlLog);
			//实时表中数据修改
			Control control = new Control();
			control.setDeviceNum(gate);
			control.setOperationState(nowState);
			boolean cflag=controlBiz.updateControl(control);
			if (cflag==false) {
				return map1;
			}
			break;
		//定量投料总启动
		case "atFeedQualEn":
			System.out.println("atFeedQualEn2");
			//历史控制表中数据插入
			ControlLog controlLog1 = new ControlLog();
			controlLog1.setHisinfo(op);
			controlLog1.setDeviceNum(gate);
			controlLog1.setHisstate(nowState);
			controlLog1.setKind("定量投料总启动开关");
			controlLog1.setPerson("硬件操作");
			controlLog1.setOperationOrder(operation[0]);
			controlLogBiz.addControlLog(controlLog1);
			//实时表中数据修改
			Control control1 = new Control();
			control1.setDeviceNum(gate);
			control1.setOperationState(nowState);
			boolean cflag1=controlBiz.updateControl(control1);
			if (cflag1==false) {
				return map1;
			}
			break;
		//定时投料总启动
		case "atFeedTimerEn":
			System.out.println("atFeedTimerEn3");
			//历史控制表中数据插入
			ControlLog controlLog2 = new ControlLog();
			controlLog2.setHisinfo(op);
			controlLog2.setDeviceNum(gate);
			controlLog2.setHisstate(nowState);
			controlLog2.setKind("定时投料总启动开关");
			controlLog2.setPerson("硬件操作");
			controlLog2.setOperationOrder(operation[0]);
			controlLogBiz.addControlLog(controlLog2);
			//实时表中数据修改
			Control control2 = new Control();
			control2.setDeviceNum(gate);
			control2.setOperationState(nowState);
			boolean cflag2=controlBiz.updateControl(control2);
			if (cflag2==false) {
				return map1;
			}
			break;
			
		//定量投料任务配置
		case "atFeedQualConfig":
			System.out.println("atFeedQualConfig4");
			String[] valueStrings1 = operation[1].split(",");
			for (int i = 0; i < valueStrings1.length; i++) {
				System.out.println(valueStrings1[i]);
			}
			
			//历史控制表中数据插入
			ControlLog controlLog3 = new ControlLog();
			controlLog3.setHisinfo(op);
			controlLog3.setDeviceNum(gate);
			controlLog3.setHisstate(nowState);
			controlLog3.setKind("定量投料任务配置");
			controlLog3.setPerson("硬件操作");
			controlLog3.setOperationOrder(operation[0]);
			controlLog3.setTaskNum(Integer.parseInt(valueStrings1[0]));
			String beginTimeString1 = valueStrings1[1]+":"+valueStrings1[2];
			controlLog3.setBeginTime(beginTimeString1);
			controlLog3.setQualConfig(valueStrings1[3]);
			controlLogBiz.addControlLog(controlLog3);
			break;
			
		case "atFeedTimerConfig":
			System.out.println("atFeedTimerConfig5");
			String[] valueStrings2 = operation[1].split(",");
			for (int i = 0; i < valueStrings2.length; i++) {
				System.out.println(valueStrings2[i]);
			}
			
			//历史控制表中数据插入
			ControlLog controlLog4 = new ControlLog();
			controlLog4.setHisinfo(op);
			controlLog4.setDeviceNum(gate);
			controlLog4.setHisstate(nowState);
			controlLog4.setKind("定时投料任务配置");
			controlLog4.setPerson("硬件操作");
			controlLog4.setOperationOrder(operation[0]);
			controlLog4.setTaskNum(Integer.parseInt(valueStrings2[0]));
			String beginTimeString2 = valueStrings2[1]+":"+valueStrings2[2];
			controlLog4.setBeginTime(beginTimeString2);
			controlLog4.setDuration(valueStrings2[3]);
			controlLogBiz.addControlLog(controlLog4);
			break;
			
			case "atFeedRun":
			System.out.println("atFeedRun6");
			
			break;
			
			
		//手动排污
		case "atSewageManual":
			System.out.println("atSewageManual1");
			break;
		//自动排污
		case "atSewageAuto":
			System.out.println("atSewageAuto2");
			break;
		//排污任务设置
		case "atSewageConfig":
			System.out.println("atSewageConfig3");
			break;
		//运行状态上传
		case "atSewageRun":
			System.out.println("atSewageRun4");
			break;
			
			
		//推水增氧手动控制
		case "DoSufaceManual":
			System.out.println("DoSufaceManual1");
			break;
		//爆气增氧手动控制
		case "atDoGasManual":
			System.out.println("atDoGasManual2");
			break;
		//阈值增氧
		case "atDoThreshold":
			System.out.println("atDoThreshold3"); 
			break;
		//定时增氧模式配置
		case "atDoTimerEn":
			System.out.println("atDoTimerEn4");
		//定时增氧任务配置
		case "atDoTimerConfig":
			System.out.println("atDoTimerConfig5");
			break;
		//除外塘增氧运行状态上传
		case "atDoRun":
			System.out.println("atDoRun6");
			
			
		//外塘增氧手动
		case "atDoOutManual":
			System.out.println("atDoOutManual1");
			break;
		//外塘增氧运行状态上传
		case "atDoOutRun":
			System.out.println("atDoOutRun2");
			break;
		

		}
		
	//实时操作指令放入数据库
		
		Map<String,String> map=new HashMap<>();
		map.put("ok", "获取成功");
		return map;


	}
	
	
	@ResponseBody
	@RequestMapping(value="redirectSensor")
	public Map<String, String> redirectSensor(String gate,String op){
		//操作命令和操作历史
				String[] operation = op.split("=");
				for (int i = 0; i < operation.length; i++) {
					System.out.println(operation[i]);
				}
				//操作命令
				System.out.println(operation[0]);
				
		switch (operation[0]) {
		
		//报警系统信息上传
		//电力报警信息上传
		case "atWarn":
			System.out.println("atWarn1");
			break;
		//气体管路压力异常报警信息上传
		case "atAlarm":
			System.out.println("atAlarm2");
			break;
		//气象信息
		case "atweather":
			System.out.println("atweather");
			break;
		
			
		//传感器数据信息上传
		case "atsensor":
			System.out.println("atsensor");
			break;
	}
		//报警、传感器、气象数据获取成功返回

		Map<String,String> map=new HashMap<>();
		map.put("ok", "获取成功");
		return map;
}
		
		

	
	
	
	
	
	
	
	
	@RequestMapping(value="index")
	public ModelAndView back(ModelAndView mv){
		Map<String, String> map = new HashMap<>();
		map.put("ok", "lixiang");
//		mv.addAllObjects(map);
		mv.addObject("day", "lixiang");
		mv.setViewName("index");  	
		return mv;
	}
	
}
