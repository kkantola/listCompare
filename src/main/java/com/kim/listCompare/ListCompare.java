package com.kim.listCompare;

import java.io.IOException;
import java.util.List;

import com.kim.model.Version1Obj;
import com.kim.model.Version2Obj;
import com.kim.util.CompareUtil;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

/**
 * Class for comparing the equality of two lists of objects.
 * The lists of objects will be the results of two Rest API calls.
 * The calls will be to two different versions of the same service.
 * Determining the equality of the objects will require special handling since
 * some parameter names and date formats have changed between the versions.
 * 
 * @author Kim
 */
public class ListCompare {

	/**
	 * args[0] and args[1] are arrays of json strings.
	 * @param args
	 */
	public static void main(String[] args){
		
		// make sure we got two arguments 
		if(args.length < 2){
			System.out.println(" Please enter two json string representations of the lists to compare "); 
			System.exit(0);
		}
		
		// list one is from version 1 of the rest service
		String listJson1 = args[0];
		// list two is from version 2 of the rest service
		String listJson2 = args[1];
 
		ObjectMapper mapper = new ObjectMapper();	 
		// Assumption, the objects in list1 and list2 will be in the same order, so we will
		// compare list1[0] with list2[0] and so forth.
		try {

			// map the json to java.util.Lists of both object versions
			List<Version1Obj> list1 = mapper.readValue(listJson1,
					TypeFactory.defaultInstance().constructCollectionType(List.class,  
							Version1Obj.class));	
			List<Version2Obj> list2 = mapper.readValue(listJson2,
					TypeFactory.defaultInstance().constructCollectionType(List.class,  
							Version2Obj.class));
			int listSize = list1.size();
			if(list2.size() != listSize){
				// lists are not equal
				// Alert user that two lists are not equal
				System.out.println("*******************");
				System.out.println("Lists are NOT Equal, the number of objects in the lists differs");
				System.out.println("*******************");
			} else {
				boolean objEqual = true;
				for(int idx=0;idx<listSize;idx++){
					Version1Obj v1Obj = list1.get(idx);
					Version2Obj v2Obj = list2.get(idx);
					objEqual = CompareUtil.compare(v1Obj, v2Obj);
					if(!objEqual){
						break;
					}
				}
				// if we get here and objEqual is true, then each object of both lists were equal
				if(objEqual){
					// Alert user that two lists are equal
					System.out.println("===============");
					System.out.println("Lists are Equal");
					System.out.println("===============");
				}  else {
					// Alert user that two lists are not equal
					System.out.println("*******************");
					System.out.println("Lists are NOT Equal");
					System.out.println("*******************");
				}
			}

		} catch (JsonParseException e) { 
			errorAlert(e);
		} catch ( JsonMappingException e) {
			errorAlert(e);
		} catch (IOException e) {
			errorAlert(e);
		}
	}
	
	private static void errorAlert(Exception e){

		System.out.println("*******************");
		System.out.println(" There was a data processing error, please check json arguments");
		System.out.println("*******************");
		e.printStackTrace();
	}
}
