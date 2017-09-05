//package com.kfit.controller;
//
//import java.util.Date;
//
//import org.springframework.scheduling.Trigger;
//import org.springframework.scheduling.TriggerContext;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Component
//@RestController
//@EnableScheduling
//public class TaskCronChange implements SchedulingConfigurer {
//
//	// 初始化为没五秒执行一次
//	private String expression = "0/5 * * * * *";
//
//	@RequestMapping("/change/expression")
//	public String changeExpression() {
//    
//		expression = "0/10 * * * * *";
//		return expression;
//	}
//
//	@Override
//	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//		Runnable task = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("configureTasks.run," + new Date());
//			}
//		};
//		Trigger trigger = new Trigger() {
//			@Override
//			public Date nextExecutionTime(TriggerContext triggerContext) {
//				CronTrigger cronTrigger = new CronTrigger(expression);
//				return cronTrigger.nextExecutionTime(triggerContext);
//			}
//		};
//		taskRegistrar.addTriggerTask(task, trigger);
//	}
//}
