package entities;

public class Nurse extends User {

	public Nurse(int userIDnumber, String fName, String lName, String dob, String address, String userType,
			String userName,String password) {
		super(userIDnumber, fName, lName, dob, address, userType, userName,password);
		// TODO Auto-generated constructor stub
	}
	
	private String rank;

	public String getRank() {
		return rank;
	}

	

}
