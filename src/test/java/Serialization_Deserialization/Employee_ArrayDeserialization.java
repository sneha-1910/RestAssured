package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.EmployeeWithArray;

public class Employee_ArrayDeserialization {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obm = new ObjectMapper();
		EmployeeWithArray emp = obm.readValue(new File("./array.json"), EmployeeWithArray.class);
		System.out.println(emp.getEmpname());
		System.out.println(emp.getPhno()[1]);
		
		
		
		
		
	}
		
}
