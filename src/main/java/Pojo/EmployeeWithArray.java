package Pojo;

public class EmployeeWithArray {

	String empname;
	int[] phno;
	String empId;
	public EmployeeWithArray(String empname, int[] phno, String empId) 
	{
		super();
		this.empname = empname;
		this.phno = phno;
		this.empId = empId;
	}
	
	public EmployeeWithArray() 
	{
		
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	
	
}
