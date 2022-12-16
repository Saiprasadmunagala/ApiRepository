package pojoClassForSerializationAndDeserialization;

public class EmployeeDetailsWithObject {
	
	String eName;
	String eId;
	int[] pNo;
	String[] eMail;
	Object Spose;
	public EmployeeDetailsWithObject(String eName, String eId, int[] pNo, String[] eMail, Object spose) {
		
		this.eName = eName;
		this.eId = eId;
		this.pNo = pNo;
		this.eMail = eMail;
		Spose = spose;
	}
	
	public EmployeeDetailsWithObject() {
		
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public int[] getpNo() {
		return pNo;
	}

	public void setpNo(int[] pNo) {
		this.pNo = pNo;
	}

	public String[] geteMail() {
		return eMail;
	}

	public void seteMail(String[] eMail) {
		this.eMail = eMail;
	}

	public Object getSpose() {
		return Spose;
	}

	public void setSpose(Object spose) {
		Spose = spose;
	}
	
	
	
}
