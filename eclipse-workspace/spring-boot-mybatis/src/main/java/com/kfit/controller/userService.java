package com.kfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

	@Autowired
	private userMapper usermapper;
	public List<user> likeName(String name)
	{
		return usermapper.likeName(name);
	}
	
	
}
