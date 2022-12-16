package pojoClassForSerializationAndDeserialization;

public class Spouse {
	
	String sNmae;
	int sPno;
	String sEmail;
	public Spouse(String sNmae, int sPno, String sEmail) {
		super();
		this.sNmae = sNmae;
		this.sPno = sPno;
		this.sEmail = sEmail;
	}
	
	
	public Spouse() {
		
	}


	public String getsNmae() {
		return sNmae;
	}


	public void setsNmae(String sNmae) {
		this.sNmae = sNmae;
	}


	public int getsPno() {
		return sPno;
	}


	public void setsPno(int sPno) {
		this.sPno = sPno;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	

}
