package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.EmployeeWithArray;

public class Employee_ArrySerialization {

	    @Test
	    public void test() throws JsonGenerationException, JsonMappingException, IOException
	    {
	    	int[] phnum= {34567,678595};
	    	ObjectMapper obm = new ObjectMapper();
	    	EmployeeWithArray emp = new EmployeeWithArray("sonu", phnum, "78");
	    	obm.writeValue(new File("./array.json"), emp);
	    }
	
	
	
	
	
}
