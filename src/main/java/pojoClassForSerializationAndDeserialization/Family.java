package pojoClassForSerializationAndDeserialization;

public class Family {
	
	String name;
	String relation;
	int age;
	
	
	
	public Family(String name, String relation, int age) {
	
		this.name = name;
		this.relation = relation;
		this.age = age;
	}



	public Family() {
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRelation() {
		return relation;
	}



	public void setRelation(String relation) {
		this.relation = relation;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}