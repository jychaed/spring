package org.hdcd.vo;

import java.util.List;


public class Merong {
	private String name;
	private List<String> idols;
	private int age;
	private String homeTown;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIdols() {
		return idols;
	}
	public void setIdols(List<String> idols) {
		this.idols = idols;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	
	// 값을 눈으로 확인할 때 아주 편하기 때문에, toString 빼먹는 사람은 아주 나쁜 사람
	// 디버깅을 안하겠다는 의미!
	@Override
	public String toString() {
		return "Merong [name=" + name + ", idols=" + idols + ", age=" + age + ", homeTown=" + homeTown + "]";
	}
	
}
