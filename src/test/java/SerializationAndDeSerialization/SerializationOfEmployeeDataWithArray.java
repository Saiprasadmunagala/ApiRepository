package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.PojoClassWithArray;

public class SerializationOfEmployeeDataWithArray {
	@Test
	public void SerializationOfEmployeeDataWithArrayTest() throws Throwable, Throwable, Throwable {
		
		int[] phone= {6515186,651654};
	     PojoClassWithArray pojo=new PojoClassWithArray("10000000", "1939", phone);
	  // step 2:- create object of ObjectMapper from jackson Mapper
	 	
	 	ObjectMapper objm=new ObjectMapper();
	 	
	 	// Step 3:- write data into json file
	 	
	 	objm.writeValue(new File("./PojoClassWithArray.json"), pojo);
	 	
	}
}
