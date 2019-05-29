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
	@RequestMapping(value="redirect")
	public Map<String,String> Redirect(String gate, String op) {
		gate="Reg0000001";
		op ="atFeedQualEn=1,2,1";
	

		Map<String,String> map1=new HashMap<>();
		map1.put("ok", "控制表联动出现异常");
		
		
		//操作命令和操作历史
		String[] operation = op.split("=");
		for (int i = 0; i < operation.length; i++) {
			System.out.println(operation[i]);
		}
		//操作命令
		System.out.println(operation[0]);
		//开关状态
		String nowState = operation[1].substring(operation[1].length()-1, operation[1].length());
		System.out.println(operation[1].substring(operation[1].length()-1, operation[1].length()));
	
		//查询当前操作的历史状态值
		List<Control> nclist= controlBiz.selectControl(gate);
		String hisDeviceNum= nclist.get(0).getDeviceNum();
		String hisOperationState=nclist.get(0).getOperationState();
				
		//历史控制表中数据插入
		ControlLog controlLog = new ControlLog();
		controlLog.setHisinfo(op);
		controlLog.setDeviceNum(gate);
/*		controlLog*/
		//操作指令判断存入历史控制表中的数据格式
		switch (operation[0]) {
		//手动投料
		case "atFeedManual":
			System.out.println("case one");
			
			break;
		//定量投料
		case "atFeedQualEn":
			System.out.println("case two");
			break;
		//定时投料
		case "atFeedTimerEn":
			System.out.println("case three");
			break;
		//定量投料任务配置
		case "atFeedQualConfig":
			System.out.println("case four");
			break;
		//定时投料任务配置
		case "atFeedTimerConfig":
			System.out.println("case four");
			break;
		
		//手动排污
		case "atSewageManual":
			System.out.println("case five");
			break;
		//自动排污及自动排污定时配置
		case "atSewageAuto":
			System.out.println("case six");
			break;
			
		//外塘增氧
		case "atDoOutManual":
			System.out.println("case seven");
			break;
		//推水增氧
		case "DoSufaceManual":
			System.out.println("case eight");
			break;
		//爆气增氧
		case "atDoGasManual":
			System.out.println("case nine");
			break;
		//阈值增氧
		case "atDoThreshold":
			System.out.println("case ten");
			break;
		//定时增氧
		case "atDoTimerConfig":
			System.out.println("case ten");
			break;
	}
	//实时操作指令放入数据库
		Control control = new Control();
		control.setDeviceNum(gate);
		control.setOperationState(nowState);
		boolean cflag=controlBiz.updateControl(control);
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
