package pojoClassForSerializationAndDeserialization;

public class PojoClassWithArray {
	
	String sal;
	String id;
	int[] number;
	
	public  PojoClassWithArray(String sal,String id, int[] number) {
		this.sal=sal;
		this.id=id;
		this.number=number;
		
	}
	public  PojoClassWithArray() {
		
	}
	// create constructor for serialization



	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getNumber() {
		return number;
	}

	public void setNumber(int[] number) {
		this.number = number;
	}
	
	
}
