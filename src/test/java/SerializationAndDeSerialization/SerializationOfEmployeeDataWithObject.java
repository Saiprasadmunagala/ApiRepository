package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmployeeDetailsWithObject;
import pojoClassForSerializationAndDeserialization.Spouse;

public class SerializationOfEmployeeDataWithObject {
	
	@Test
	public void SerializationOfEmployeeDataWithObjectTest() throws Throwable, Throwable, Throwable {
		//step 1:- create the object for the pojo class
		int[] phone= {656115,165651};
		String[] eMail= {"hgvacr@gmail.com","hhnhkuyn@gmail.com"};
		Spouse sp=new Spouse("Sai1", 168, "gfc@gmail.com");
		EmployeeDetailsWithObject empo=new EmployeeDetailsWithObject("Saiprasad" ,"1939", phone, eMail, sp);
		//step 2:- create the object for the object mapper
		ObjectMapper obj=new ObjectMapper();
		//step 3;- write the data to json file
		obj.writeValue(new File("./EmployeeDataWithObject.json"), empo);
	}

}
