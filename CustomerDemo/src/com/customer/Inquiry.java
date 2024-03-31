package com.customer;

public class Inquiry {
     private int id;
     private String subject;
     private String desc;
     private String date;
     private String status;
     private String agent;
     private String solution;
	public Inquiry(int id, String subject, String desc, String date, String status, String agent, String solution) {
		super();
		this.id = id;
		this.subject = subject;
		this.desc = desc;
		this.date = date;
		this.status = status;
		this.agent = agent;
		this.solution = solution;
	}
	public int getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public String getDesc() {
		return desc;
	}
	public String getDate() {
		return date;
	}
	public String getStatus() {
		return status;
	}
	public String getAgent() {
		return agent;
	}
	public String getSolution() {
		return solution;
	}
     
     
}

