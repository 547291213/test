package com.kfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;


@RestController
public class userController {

	@Autowired
	private userService userservice;
	
	@RequestMapping("/likename")
	public List<user> likeName(String name){
		
		/**
		 * 第一个参数pagenumber   第二个参数page条数
		 */
		PageHelper.startPage(1,2);
		return userservice.likeName(name);
	}
}
