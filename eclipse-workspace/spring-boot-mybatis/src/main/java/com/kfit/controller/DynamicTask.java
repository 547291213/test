package com.kfit.controller;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class DynamicTask {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	private ScheduledFuture<?> future;
	
	@Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler()
    {
		return new ThreadPoolTaskScheduler();
    }
	
	/**
	 * 定义一个方法 startTask 启动定时任务
	 */
	
	@RequestMapping("/start/task")
	public String startTask() 
	{
	 future = threadPoolTaskScheduler.schedule
			 (new MyRunnable(),new CronTrigger("0/5 * * * * *"));
	 System.out.println("startTask");
	 return "startTask";
    }
	
	private class MyRunnable implements Runnable{
		@Override
		public void run()
		{
			System.out.println("MyRunablerun"+new Date());
		}
	}
	/**
	 * 定义一个方法 stopTask 停止定时任务  
	 */
	
	@RequestMapping("/stop/task")
	public String stopTask()
	{
		if(future != null)
		{
			future.cancel(true);
		}
		return "stopTask";
	}
	/**
	 *定义一个方法 修改定时任务时间 
	 */
	@RequestMapping("/change/cron")
	public String changeCron()
	{
		//先停止定时器
		stopTask();
		//再启动定时器
		future =threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/10 * * * * *"));
		
		System.out.println("change Cron");
		return "changeCron";
	}
	
}
