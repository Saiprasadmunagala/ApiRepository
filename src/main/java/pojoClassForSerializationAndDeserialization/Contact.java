package pojoClassForSerializationAndDeserialization;

public class Contact {
	
	String firstName;
	String lastName;
	String companyNmae;
	long[] phNo;
	String dOB;
	String eMail;
	String url;
	String adress;
	String relatedName;
	String socialProfile;
	Object family;
	// Constructor For Initializing the elements.
	public Contact(String firstName, String lastName, String companyNmae, long[] phNo, String dOB, String eMail,
			String url, String adress, String relatedName, String socialProfile, Object family) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyNmae = companyNmae;
		this.phNo = phNo;
		this.dOB = dOB;
		this.eMail = eMail;
		this.url = url;
		this.adress = adress;
		this.relatedName = relatedName;
		this.socialProfile = socialProfile;
		this.family = family;
	}
	
	// getter method for
	public Contact() {
		
	}

	// getter method for
	public String getFirstName() {
		return firstName;
	}
	// getter method for
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// getter method for
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyNmae() {
		return companyNmae;
	}

	public void setCompanyNmae(String companyNmae) {
		this.companyNmae = companyNmae;
	}

	public long[] getPhNo() {
		return phNo;
	}

	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getRelatedName() {
		return relatedName;
	}

	public void setRelatedName(String relatedName) {
		this.relatedName = relatedName;
	}

	public String getSocialProfile() {
		return socialProfile;
	}

	public void setSocialProfile(String socialProfile) {
		this.socialProfile = socialProfile;
	}

	public Object getFamily() {
		return family;
	}

	public void setFamily(Object family) {
		this.family = family;
	}
	
}
