package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.EmployeeWithObject;
import Pojo.Spouse;

public class object_serialization {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException 
	{
		int[] phnum= {34567,76543};
		int[] spouseph= {4567,78675};
		Spouse spu = new Spouse("sss", "95", spouseph);
		ObjectMapper obm = new ObjectMapper();
		  EmployeeWithObject emp = new EmployeeWithObject("sne", "98", phnum,spu);
		  obm.writeValue(new File("./object.json"), emp);
		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
