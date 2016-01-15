package com.kim.util;

import java.util.Date;
import java.util.Objects;

import com.kim.model.Version1Obj;
import com.kim.model.Version2Obj;

/**
 * Utility to compare two objects for equality.
 * The objects are similar but have changed during coding for rest service version 2
 * @author Kim
 *
 */
public class CompareUtil {

	/**
	 * Compare two objects
	 * @param v1Obj - object returned by read or search of rest service 1
	 * @param v2Obj - object returned by read or search of rest service 2
	 * @return
	 */
	public static boolean compare(Version1Obj v1Obj, Version2Obj v2Obj){
		boolean objAreEqual = false;
		if(v1Obj.getId() == v2Obj.getId() && compareObjects(v1Obj.getName(),v2Obj.getUserName())){
			if(compareDateValues(v1Obj.getDateString(),v2Obj.getDateString())){
				objAreEqual = true;
			}
		}
		return objAreEqual;
	}
	
	/**
	 * Compare two date strings, both formatted as ISO, one with EST time zone, the other UTC
	 * @param v1DateStr  ISO EST Date String
	 * @param v2DateStr  ISO UTC Date String
	 * @return
	 */
	private static boolean compareDateValues(String v1DateStr, String v2DateStr){ 
		if(v1DateStr == null && v2DateStr == null){
			return true;
		}
		// if both are not null, but one is, return false
		if(v1DateStr == null || v2DateStr == null){
			return false;
		}
		// neither date is null, compare	
		try {
		
			Date v1Date = DateUtil.getDateValueFromIsoString(v1DateStr);
			Date v2Date = DateUtil.getDateValueFromIsoString(v2DateStr); 
			return v1Date.equals(v2Date);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return false;	
	}
	
	/**
	 * Compare two objects for equality
	 * @param v1Obj
	 * @param v2Obj
	 * @return true if objects are equal
	 */
	private static boolean compareObjects(Object v1Obj, Object v2Obj){
		// utilize new java 7 Objects.equals method.
		// from java documentation: Returns true if the arguments are equal to each other and false 
		// otherwise. Consequently, if both arguments are null, true is returned and if exactly one 
		// argument is null, false is returned. Otherwise, equality is determined by using the equals
		//method of the first argument.
		return Objects.equals(v1Obj,  v2Obj);
	}
}
