package PojoClassGericUtility;

public class AddProjectPOJO {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	public AddProjectPOJO(String createdBy, String projectName, String statusCode, int teamSize) {
		
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = statusCode;
		this.teamSize = teamSize;
	}
	
	public AddProjectPOJO(){
		
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

	public String getStatusCode() {
		return status;
	}

	public void setStatusCode(String statusCode) {
		this.status = statusCode;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
}
