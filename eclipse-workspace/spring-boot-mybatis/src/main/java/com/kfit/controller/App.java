package com.kfit.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
   //@Configuration
@MapperScan("com.*")  //扫描mybatis的持久化类
public class App 
{
    public static void main( String[] args )
    {
      
    	SpringApplication.run(App.class, args);
    }
}
