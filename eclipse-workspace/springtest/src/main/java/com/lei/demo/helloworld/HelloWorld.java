package com.lei.demo.helloworld;

public class HelloWorld {

	private String name;
	public void setName(String name)
	{
		this.name=name;
	}
	public void printHello()
	{
		System.out.println("这是我第一个spring3 :Hello!"+name);
	}
}
