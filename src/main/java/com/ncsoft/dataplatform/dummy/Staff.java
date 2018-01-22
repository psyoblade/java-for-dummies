package com.ncsoft.dataplatform.dummy;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Staff {

	@SerializedName("--name")
	private String name;
	@SerializedName("--age")
	private int age;
	@SerializedName("--option")
	private boolean option;
	private String position;
	private BigDecimal salary;
	private List<String> skills;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isOption() {
		return option;
	}
	public void setOption(boolean option) {
		this.option = option;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	
}