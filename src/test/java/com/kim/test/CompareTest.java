package com.kim.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kim.model.Version1Obj;
import com.kim.model.Version2Obj;
import com.kim.util.CompareUtil;

public class CompareTest {
	
	@Test
	public void testCompare(){
		
		// version 1 test date object
		Version1Obj v1Obj = new Version1Obj();
		v1Obj.setId(12);
		v1Obj.setName("kEverdeen");
		v1Obj.setDateString("2016-01-14T11:08:06.123-05:00");

		// version 1 test date object
		Version2Obj v2Obj = new Version2Obj();
		v2Obj.setId(12);
		v2Obj.setUserName("kEverdeen");
		v2Obj.setDateString("2016-01-14T16:08:06.123+00:00");
		
		boolean compare = CompareUtil.compare(v1Obj, v2Obj);
		
		Assert.assertTrue(compare);
	}

}
