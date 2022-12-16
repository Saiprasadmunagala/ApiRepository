package SerializationAndDeSerialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmployeeDetails;
import pojoClassForSerializationAndDeserialization.EmployeeDetailsWithObject;

public class DeserializationOfEmployeeDetails {
	

	@Test
	public void DeserializationofContactTest() throws Throwable, Throwable, Throwable {
		//step:- create the object for the Mapper
		
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:- Read the data from JsonFile
		EmployeeDetails ser=objm.readValue(new File("./EmployeeDetails.json"), EmployeeDetails.class);
			
		// step 3:- Fetch the required value
		System.out.println(ser.geteName());
	}
	
}
