package com.kfit.controller;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface userMapper {

	
	@Select("select * from user where name=#{name}")
	public List<user> likeName(String name);
	
	@Select("select * from user where password={password}")
	public user listPassword(String password);
}
