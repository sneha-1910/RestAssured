package Serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.EmployeeWithObject;

public class object_Deseeialization {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obm = new ObjectMapper();
		EmployeeWithObject emp = obm.readValue(new File("./object.json"), EmployeeWithObject.class);
		System.out.println(emp.getEmpId());
		System.out.println(emp.getEmpName());
		System.out.println(emp.getPhno()[1]);
		System.out.println(emp.getSpouse().getSpouseName());
		System.out.println(emp.getSpouse().getSpouseId());
		System.out.println(emp.getSpouse().getPhno()[0]);
	}
	
	
	
	
	
	
	
}
