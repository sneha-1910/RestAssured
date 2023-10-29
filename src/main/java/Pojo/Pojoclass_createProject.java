package Pojo;

import GenericUtility.JavaUtility;

public class Pojoclass_createProject {
	
	JavaUtility jlib=new JavaUtility();
	
		String createdBy;
		String projectName;
		String status;
		int teamSize;
		public Pojoclass_createProject(String createdBy, String projectName, String status, int teamSize) {
			super();
			this.createdBy = createdBy;
			this.projectName = projectName+jlib.getRandomNo();
			this.status = status;
			this.teamSize = teamSize;
			
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getTeamSize() {
			return teamSize;
		}
		public void setTeamSize(int teamSize) {
			this.teamSize = teamSize;
		}
		
		
		
		
		
		
	
	}


