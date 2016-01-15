package com.kim.model;

/**
 * Search object returned by rest service 2
 * @author Kim 
 */
public class Version2Obj  {

	/**
	 * Id number of the object
	 */
	private int id;
	
	/**
	 * User Name
	 */
	private String userName;
	
	/**
	 * Date string, will be in format of 2015-03-28'T'00:00:00
	 */
	private String dateString;
	 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
