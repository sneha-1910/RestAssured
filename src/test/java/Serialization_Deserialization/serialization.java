package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.Employee;

public class serialization {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper obM = new ObjectMapper();
		Employee emp = new Employee("sneha", 9880709, 23);
		
		//obM.writeValue(new File("./sneha.json"), emp);
		
		// to print it in line by line
		obM.writerWithDefaultPrettyPrinter().writeValue(new File("./sneha.json"), emp);
		
	}
	
	
}
