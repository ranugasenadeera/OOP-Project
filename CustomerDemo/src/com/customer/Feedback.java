package com.customer;

public class Feedback {
	private int id;
    private int agid;
    private String name;
    private String date;
    private int rate;
    
	public Feedback(int id, int agid, String name, String date, int rate) {//overloaded constructor
		this.id = id;
		this.agid = agid;
		this.name = name;
		this.date = date;
		this.rate = rate;
	}
    
	//getter methods
	public int getId() {
		return id;
	}

	public int getAgid() {
		return agid;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public int getRate() {
		return rate;
	}
	
	
   
    
}
