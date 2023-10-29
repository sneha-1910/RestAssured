package Pojo;

public class Spouse {

	String SpouseName;
	String SpouseId;
	int[] phno;
	public Spouse(String spouseName, String spouseId, int[] phno) {
		super();
		SpouseName = spouseName;
		SpouseId = spouseId;
		this.phno = phno;
	}
	
	public Spouse() 
	{
		
	}

	public String getSpouseName() {
		return SpouseName;
	}

	public void setSpouseName(String spouseName) {
		SpouseName = spouseName;
	}

	public String getSpouseId() {
		return SpouseId;
	}

	public void setSpouseId(String spouseId) {
		SpouseId = spouseId;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	
	
}
