package SerializationAndDeSerialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.Contact;
import pojoClassForSerializationAndDeserialization.Family;

public class SerializationofContact {
	@Test
	public void SerializationofContactTest() throws Throwable, Throwable, Throwable {
		
		long[] phNo= {8309320753l,7997004327l};
		
		
	    Family fam =new Family ("sai","myself",101);
	    Contact cont=new Contact("SaiPrasad", "Munagala", "Tyss" , phNo, "16-04-1998" , "saiprasad@gmail.com", "www.Saiprasad.com", "andhra pradesh", "Sai", "Instagram", fam);
	    	
	    ObjectMapper objm=new ObjectMapper();
	    objm.writeValue(new File("./SerializationofContact.json"), cont);
	    }
}
