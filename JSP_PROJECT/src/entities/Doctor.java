package entities;

public class Doctor extends User {

	public Doctor(int userIDnumber, String fName, String lName, String dob, String address, String userType,
			String userName, String password, String specialization) {
		super(userIDnumber, fName, lName, dob, address, userType, userName, password);
		// TODO Auto-generated constructor stub
		this.specialization = specialization;
	}

	private String specialization;

	public String getSpecialization() {
		return specialization;
	}

}
