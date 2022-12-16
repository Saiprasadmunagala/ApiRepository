package pojoClassForSerializationAndDeserialization;

public class EmployeeDetails {
	// Step:- declare the variables globally
	String eName;
	int eId;
	String phoneNo;
	String email;
	String adress;
	
	//create the constructor for initialization
	public EmployeeDetails(String eName, int eId, String phoneNo, String email, String adress) {
		
		this.eName = eName;
		this.eId = eId;
		this.phoneNo = phoneNo;
		this.email = email;
		this.adress = adress;
	}
	
	// trigger the initialization
	public EmployeeDetails() {
		
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
