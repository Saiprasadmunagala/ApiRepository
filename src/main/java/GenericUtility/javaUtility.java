package GenericUtility;



public class javaUtility {
	
	// this is the generic code for random number
	 public int getRanDomNum() {
			java.util.Random random = new java.util.Random();
			int ran = random.nextInt(1000);
			return ran;
}
}