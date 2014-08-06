package com.connectivity.com;

public class User {
	
	private String name;
	private String country;
	
	public User(String name, String country){
		this.name = name;
		this.country = country;
	}
	
	public User(String name){
		this.name = name;
	}
	
	//getters
	
	public String getName(){
		return this.name;
	}
	
	public String getCountry(){
		return this.country;
	}

}
