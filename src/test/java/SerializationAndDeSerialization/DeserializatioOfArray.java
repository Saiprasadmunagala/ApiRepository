package SerializationAndDeSerialization;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.PojoClassWithArray;

public class DeserializatioOfArray {
	@Test
	public void DeserializatioOfArrayTest() throws Throwable, Throwable, Throwable {
	ObjectMapper objm=new ObjectMapper();
	objm.readValue(new File("./PojoClassWithArray.json"), PojoClassWithArray.class);
	
}
}