package Pojo;

public class EmployeeWithObject {

	String empName;
     String empId;
	int[] phno;
	Spouse spouse12;
	
	
	public EmployeeWithObject(String empName, String empId, int[] phno, Spouse spouse12) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.phno = phno;
		this.spouse12 = spouse12;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int[] getPhno() {
		return phno;
	}
	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	public Spouse getSpouse() {
		return spouse12;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse12 = spouse;
	}
	
   	public EmployeeWithObject()
   	{
   		
   	}
	
	
	
}
