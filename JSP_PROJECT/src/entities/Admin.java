package entities;

public class Admin extends User {

	public Admin(int userIDnumber, String fName, String lName, String dob, String address, String userType,
			String userName, String password) {
		super(userIDnumber, fName, lName, dob, address, userType, userName, password);
		// TODO Auto-generated constructor stub
	}

	public int getUserIDnumber() {
		return userIDnumber;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getUserType() {
		return userType;
	}

	public String getUserName() {
		return userName;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	

}
