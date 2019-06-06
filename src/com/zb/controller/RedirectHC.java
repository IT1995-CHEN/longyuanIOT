package com.zb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.zb.biz.ControlBiz;
import com.zb.biz.ControlLogBiz;
import com.zb.biz.ControlRunBiz;
import com.zb.biz.DeviceInfoBiz;
import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.Control;
import com.zb.entity.ControlLog;
import com.zb.entity.ControlRun;
import com.zb.entity.SensorInfo;
import com.zb.entity.SensorNowdata;
import com.zb.entity.Warn;
import com.zb.mapper.ControlMapper;
import com.zb.mapper.DeviceInfoMapper;
import com.zb.mapper.SensorNowdataMapper;


@Controller
public class RedirectHC {

	@Autowired
	private ControlBiz controlBiz;
	@Autowired
	private ControlLogBiz controlLogBiz;
	@Autowired
	private ControlRunBiz controlRunBiz;
	@Autowired
	private SensorNowdataBiz sensorNowdataBiz;
	@Autowired
	private DeviceInfoBiz deviceInfoBiz;
	@Autowired
	private SensorNowdataMapper sensorNowdataMapper;
	
	@Autowired
	private DeviceInfoMapper deviceinfomapper;
	@Autowired
	private ControlMapper controlMapper;
	
	@ResponseBody
	@RequestMapping(value="redirectHControl")
	public Map<String,String> Redirect(String gate,String device ,String op,String task,String run,String warn) {
//		gate="Reg0000001";
//		device="11,1,1";
//		op ="1,1";
//		task=""; 
		System.out.println(gate);
		System.out.println(device);
		System.out.println(op);
		System.out.println(task);
		System.out.println(run);
		String deviceNum = gate+","+device;
		System.out.println(deviceNum);
		
		if (gate==null || gate =="") {
			Map<String, String> mapGate = new HashMap<>();
			mapGate.put("ok", "请输入gate参数");
			return mapGate;
		}
		if (device==null || device =="") {
			Map<String, String> mapDevice = new HashMap<>();
			mapDevice.put("ok", "请输入device参数");
			return mapDevice; 
		}
		
		if (op!=null&&!op.equals("")) {
			String[] opstring= op.split(",");
			switch (opstring[0]) {
			case "0":
				SensorNowdata sensorNowdata  = new SensorNowdata();
				if (sensorNowdataMapper.countSensorNowdata(deviceNum)==0) {
				
					sensorNowdata.setDeviceNum(deviceNum);
					sensorNowdata.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());
					sensorNowdata.setVal("0");	
					sensorNowdataBiz.addNowData(sensorNowdata);
				}
				
				sensorNowdata.setDeviceNum(deviceNum);
				sensorNowdata.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());
				sensorNowdata.setVal(opstring[1]);
				System.out.println(opstring[1]);
				sensorNowdataBiz.updateNowData(sensorNowdata);
				break;
			case "1":
				Control control = new Control();
				if (controlMapper.countControlByDeviceNum(deviceNum)==0) {
					control.setDeviceNum(deviceNum);
					control.setOperationState("0");
					control.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());	
					controlBiz.addControl(control);
				}
				ControlLog controlLog = new ControlLog();
				controlLog.setDeviceNum(deviceNum);
				controlLog.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"0/1手动操作");
				controlLog.setHisstate(opstring[1]);
				controlLog.setOperationOrder("gate="+gate+","+"device="+device+","+"op="+op);
				controlLog.setHisinfo(controlBiz.selectControl(deviceNum).get(0).toString());
				controlLog.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLog);
			
				control.setDeviceNum(deviceNum);
				control.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());
				control.setOperationState(opstring[1]);
				controlBiz.updateControl(control);
				break;
			case "2":
				Control control2 = new Control();
				if (controlMapper.countControlByDeviceNum(deviceNum)==0) {
					control2.setDeviceNum(deviceNum);
					control2.setOperationState("0");
					control2.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());	
					controlBiz.addControl(control2);
				}
				ControlLog controlLog2 = new ControlLog();
				controlLog2.setDeviceNum(deviceNum);
				controlLog2.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"0/1手动操作");
				controlLog2.setHisstate(opstring[1]);
				controlLog2.setOperationOrder("gate="+gate+","+"device="+device+","+"op="+op);
				controlLog2.setHisinfo(controlBiz.selectControl(deviceNum).get(0).toString());
				controlLog2.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLog2);

				control2.setDeviceNum(deviceNum);
				control2.setPid(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getPid());
				control2.setOperationState(opstring[1]);
				controlBiz.updateControl(control2);
				break;
			default:
				Map<String, String> mapOP = new HashMap<>();
				mapOP.put("ok", "op参数输入错误");
				return mapOP;
			}
		}
		
		if (task!=null&&!task.equals("")) {
			String[] tasksStrings= task.split(",");
			System.out.println("==============="+tasksStrings[0]);
			System.out.println("+++++++++++="+tasksStrings.length);
			switch (tasksStrings[0]) {
			case "SewageConfig":
				if (tasksStrings.length<7) {
					Map<String, String> mapTask1 = new HashMap<>();
					mapTask1.put("ok", "task参数中SewageConfig参数输入错误");
					return mapTask1;
				}
				ControlLog controlLogS = new ControlLog();
				controlLogS.setTaskNum(Integer.parseInt(tasksStrings[1]));
				controlLogS.setBeginTime(tasksStrings[2]+":"+tasksStrings[3]);
				controlLogS.setEndTime(tasksStrings[4]+":"+tasksStrings[5]);
				controlLogS.setHisstate(tasksStrings[6]);
				controlLogS.setDeviceNum(deviceNum);
				controlLogS.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"定时排污");
				controlLogS.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogS.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLogS);
				break;
			case "FeedTimerConfig":
				if (tasksStrings.length<7) {
					Map<String, String> mapTask2 = new HashMap<>();
					mapTask2.put("ok", "task参数中FeedTimerConfig参数输入错误");
					return mapTask2;
				}
				ControlLog controlLogFt = new ControlLog();
				controlLogFt.setTaskNum(Integer.parseInt(tasksStrings[1]));
				controlLogFt.setBeginTime(tasksStrings[2]+":"+tasksStrings[3]);
				controlLogFt.setEndTime(tasksStrings[4]+":"+tasksStrings[5]);
				controlLogFt.setHisstate(tasksStrings[6]);
				controlLogFt.setDeviceNum(deviceNum);
				controlLogFt.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"定时投料");
				controlLogFt.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogFt.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLogFt);
				break;
			case "FeedQualConfig":
				if (tasksStrings.length<6) {
					Map<String, String> mapTask3 = new HashMap<>();
					mapTask3.put("ok", "task参数中FeedQualConfig参数输入错误");
					return mapTask3;
				}
				ControlLog controlLogFq = new ControlLog();
				controlLogFq.setTaskNum(Integer.parseInt(tasksStrings[1]));
				controlLogFq.setBeginTime(tasksStrings[2]+":"+tasksStrings[3]);
				controlLogFq.setQualConfig(tasksStrings[4]);
				controlLogFq.setHisstate(tasksStrings[5]);
				controlLogFq.setDeviceNum(deviceNum);
				controlLogFq.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"定量投料");
				controlLogFq.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogFq.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLogFq);
				break;
			case "DoTimerConfig":
				
				if (tasksStrings.length<7) {
					Map<String, String> mapTask4 = new HashMap<>();
					mapTask4.put("ok", "task参数中DoTimerConfig参数输入错误");
					return mapTask4;
				}
				ControlLog controlLogDt = new ControlLog();
				controlLogDt.setTaskNum(Integer.parseInt(tasksStrings[1]));
				controlLogDt.setBeginTime(tasksStrings[2]+":"+tasksStrings[3]);
				controlLogDt.setEndTime(tasksStrings[4]+":"+tasksStrings[5]);
				controlLogDt.setHisstate(tasksStrings[6]);
				controlLogDt.setDeviceNum(deviceNum);
				controlLogDt.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"定时爆气增氧");
				controlLogDt.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogDt.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLogDt);
				break;
			case "DoThreshold":
				if (tasksStrings.length<4) {
					Map<String, String> mapTask5= new HashMap<>();
					mapTask5.put("ok", "task参数中DoThreshold参数输入错误");
					return mapTask5;
				}
				ControlLog controlLogDts = new ControlLog();
				controlLogDts.setMinVal(tasksStrings[1]);
				controlLogDts.setMaxVal(tasksStrings[2]);
				controlLogDts.setHisstate(tasksStrings[3]);
				controlLogDts.setDeviceNum(deviceNum);
				controlLogDts.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"阈值增氧");
				controlLogDts.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogDts.setPerson("硬件回传");
				controlLogBiz.addControlLog(controlLogDts);
				break;
			default:
				Map<String, String> mapTask = new HashMap<>();
				mapTask.put("ok", "task参数输入错误");
				return mapTask;
			}
		}
		if (run!=null&&!run.equals("")) {
			String[] runstStrings = run.split(",");
			if (runstStrings.length<9) {
				Map<String, String> mapRun1 = new HashMap<>();
				mapRun1.put("ok", "run参数长度输入错误");
				return mapRun1;
			}
			ControlRun controlRun = new ControlRun();
			switch (runstStrings[0]) {
			case "sewage":
				controlRun.setKind("排污");
				break;
			case "feed":
				controlRun.setKind("投料");
				break;
			case "Do":
				controlRun.setKind("增氧");
				break;
			default:
				Map<String, String> mapRun = new HashMap<>();
				mapRun.put("ok", "Run参数类型输入错误");
				return mapRun;   
			}
			controlRun.setDeviceNum(deviceNum);
			controlRun.setNum("gate="+gate+","+"device="+device+","+"run="+run);
			controlRun.setDoStatus(runstStrings[1]);
			controlRun.setOperator(runstStrings[2]);
			controlRun.setYear(runstStrings[3]);
			controlRun.setMonth(runstStrings[4]);
			controlRun.setDay(runstStrings[5]);
			controlRun.setHour(runstStrings[6]);
			controlRun.setMin(runstStrings[7]);
			controlRun.setSecond(runstStrings[8]);
			controlRunBiz.addControlRun(controlRun);
			}
	
		
		if (warn!=null&&!warn.equals("")) {
			String[] warnstStrings = warn.split(",");
			Warn warns =new Warn();
			switch (warnstStrings[0]) {
			case "atwarn":
				warns.setDeviceNum(deviceNum);
				warns.setPid(deviceinfomapper.searchDevice("", "", deviceNum, "", 1, 1).get(0).getProject().getPid());
				warns.setWarnInfo("电力报警："+warnstStrings[1]);
				break;
			case "atAlarm":
				warns.setDeviceNum(deviceNum);
				warns.setPid(deviceinfomapper.searchDevice("", "", deviceNum, "", 1, 1).get(0).getProject().getPid());
				warns.setWarnInfo("气体管路压力报警:"+warnstStrings[1]);
				break;
			
			default:
				Map<String, String> mapRun = new HashMap<>();
				mapRun.put("ok", "warn参数输入错误");
				return mapRun;
			}
			}	
		Map<String, String> mapSuccess = new HashMap<>();
		mapSuccess.put("ok", "成功获取参数");
		return mapSuccess;
	
	}
		
}
