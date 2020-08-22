package com.sms.model;


public class InputRequest {
	private Integer id;
	private String city;
	private String status;
	private String start_date;
	private String end_date;
	private String price;
	private String color;
	
	private String selectStartDateRange;
	private String selectEndDateRange;
	 
	public String getSelectStartDateRange() {
		return selectStartDateRange;
	}
	public void setSelectStartDateRange(String selectStartDateRange) {
		this.selectStartDateRange = selectStartDateRange;
	}
	public String getSelectEndDateRange() {
		return selectEndDateRange;
	}
	public void setSelectEndDateRange(String selectEndDateRange) {
		this.selectEndDateRange = selectEndDateRange;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
