package Crud_for_reqres;

import org.testng.annotations.Test;

public class Post_POJO {

	String name;
	String job;
	public Post_POJO(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
