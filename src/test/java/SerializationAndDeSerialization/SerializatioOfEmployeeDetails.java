package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmployeeDetails;

public class SerializatioOfEmployeeDetails {
	@Test
	public  void SerializationOfEmployeeDetailsTest() throws Throwable, Throwable, IOException  {
	// step 1:- create object of pojo class 
	EmployeeDetails emp=new EmployeeDetails("Saiprasad", 1939, "8309320753", "munagalasaiprasad16@gmail.com", "nellore");
	
	// step 2:- create object of ObjectMapper from jackson Mapper
	
	ObjectMapper objm=new ObjectMapper();
	
	// Step 3:- write data into json file
	
	objm.writeValue(new File("./EmployeeDetails.json"), emp);
	
	}
	
}
