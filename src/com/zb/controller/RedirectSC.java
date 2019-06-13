package com.zb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zb.biz.ControlBiz;
import com.zb.biz.ControlLogBiz;
import com.zb.biz.ControlRunBiz;
import com.zb.biz.DeviceInfoBiz;
import com.zb.biz.SensorNowdataBiz;
import com.zb.entity.Control;
import com.zb.entity.ControlLog;
import com.zb.mapper.ControlMapper;
import com.zb.mapper.DeviceInfoMapper;
import com.zb.mapper.SensorNowdataMapper;

@Controller
public class RedirectSC {

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
	@RequestMapping(value="/redirectSControl")
	public Map<String, String> redirectSControl(String deviceNum,String op,String task,HttpServletRequest request,HttpServletResponse response) throws IOException{
		if (deviceNum==null||deviceNum.equals("")) {
			Map<String, String> mapd = new HashMap<>();
			mapd.put("ok", "请输入deviceNum");
			return mapd;
		}
		boolean b =deviceNum.contains(",");
		System.err.println(deviceNum.length());
		if (deviceNum.length()<11||b==false) {
			Map<String, String> mapd = new HashMap<>();
			mapd.put("ok", "deviceNum参数错误");
			return mapd;
		}
		System.out.println(deviceNum);
		String[] deviceNumStr= deviceNum.split(",");
		String gate=deviceNumStr[0];
		System.out.println(gate);
		String device=deviceNum.substring(11, deviceNum.length());
		System.out.println(device);
		String url="http://"+request.getServerName()+":8000?"+"gate="+gate+"&device="+device+"&";
		
		if (op!=null&&!op.equals("")) {
			if (op.length()<3) {
				Map<String, String> mapError = new HashMap<>();
				mapError.put("ok", "请输入正确的op参数");
				return mapError;
			}
			String[] opstring= op.split(",");
			switch (opstring[0]) {
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
				controlLog.setPerson("软件操作");
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
				controlLog2.setPerson("软件操作");
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
			String urlOp=url+"op="+op;
			try {
				request.getRequestDispatcher(url);
				Map<String, String> map1 =new HashMap<>();
				map1.put("ok", "操作成功");
				return map1;
			} catch (Exception e) {
				// TODO: handle exception
				Map<String, String> map2 = new HashMap<>();
				map2.put("ok", "操作失败");
				return map2;
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
				controlLogS.setPerson("软件操作");
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
				controlLogFt.setPerson("软件操作");
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
				controlLogFq.setPerson("软件操作");
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
				controlLogDt.setPerson("软件操作");
				controlLogBiz.addControlLog(controlLogDt);
				break;
				case "PullTimerConfig":
				
				if (tasksStrings.length<7) {
					Map<String, String> mapTask4 = new HashMap<>();
					mapTask4.put("ok", "task参数中PullTimerConfig参数输入错误");
					return mapTask4;
				}
				ControlLog controlLogPt = new ControlLog();
				controlLogPt.setTaskNum(Integer.parseInt(tasksStrings[1]));
				controlLogPt.setBeginTime(tasksStrings[2]+":"+tasksStrings[3]);
				controlLogPt.setEndTime(tasksStrings[4]+":"+tasksStrings[5]);
				controlLogPt.setHisstate(tasksStrings[6]);
				controlLogPt.setDeviceNum(deviceNum);
				controlLogPt.setKind(deviceinfomapper.selectByDeviceNum(deviceNum).get(0).getDeviceName()+"定时表面增氧");
				controlLogPt.setOperationOrder("gate="+gate+","+"device="+device+","+"task="+task);
				controlLogPt.setPerson("软件操作");
				controlLogBiz.addControlLog(controlLogPt);
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
				controlLogDts.setPerson("软件操作");
				controlLogBiz.addControlLog(controlLogDts);
				break;
			default:
				Map<String, String> mapTask = new HashMap<>();
				mapTask.put("ok", "task参数输入错误");
				return mapTask;
			}
			String urlTask=url+"task="+task;
			try {
				request.getRequestDispatcher(url);
				Map<String, String> map1 =new HashMap<>();
				map1.put("ok", "操作成功");
				return map1;
			} catch (Exception e) {
				// TODO: handle exception
				Map<String, String> map2 = new HashMap<>();
				map2.put("ok", "操作失败");
				return map2;
			}
		}
		Map<String, String> mapAll =new HashMap<>();
		mapAll.put("ok", "请输入其他参数");
		return mapAll;
	
		
	
		
	}
}
