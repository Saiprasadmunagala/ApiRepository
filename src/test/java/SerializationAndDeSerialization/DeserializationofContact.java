package SerializationAndDeSerialization;
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.Contact;

public class DeserializationofContact {
	
	@Test
	public void DeserializationofContactTest() throws Throwable, Throwable, Throwable {
		//step:- create the object for the Mapper
		
		ObjectMapper objm=new ObjectMapper();
		
		//Step 2:- Read the data from JsonFile
		Contact ser=objm.readValue(new File("./SerializationofContact.json"), Contact.class);
			
		// step 3:- Fetch the required value
		System.out.println(ser.getFirstName());
	}
	
}
