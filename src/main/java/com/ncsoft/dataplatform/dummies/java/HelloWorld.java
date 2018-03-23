package com.ncsoft.dataplatform.dummies.java;

public class HelloWorld {

	public HelloWorld() {
	}

	public void say() {
		System.out.println("hello world");

	}

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		hello.say();
	}
}
