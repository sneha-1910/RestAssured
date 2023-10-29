package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.Employee;

public class DEserialization {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obm = new ObjectMapper();
		Employee emp = obm.readValue(new File("./sneha.json"), Employee.class);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getPhno());
		System.out.println(emp.getAge());
	}
	
	
	
	
}
