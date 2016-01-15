package com.kim.model;

/**
 * Search object returned by rest service 1
 * @author Kim 
 */
public class Version1Obj  {

	/**
	 * Id number of the object
	 */
	private int id;
	
	/**
	 * userName
	 */
	private String name;
	
	/**
	 * Date string, will be in format of 2015-03-10T16:31:15-0400
	 */
	private String dateString;
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
  
}
