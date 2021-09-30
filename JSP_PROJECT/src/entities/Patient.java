package entities;

public class Patient {
	
	private int userIDnumber=0;
	private String fName=""; 
	private String blood_group = "";
	private String lName=""; 
	private int age=0;
	private String Address=""; 
	private String specialNote="";
	private String tpNumber="";
	
	public Patient(int userIDnumber, String fName, String lName, int age, String address, String specialNote,String tpNumber , String blood_group) {
		super();
		this.userIDnumber = userIDnumber;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		Address = address;
		this.specialNote = specialNote;
		this.tpNumber = tpNumber;
		this.blood_group = blood_group;
	}

	public int getPatientIDnumber() {
		return userIDnumber;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return Address;
	}

	public String getSpecialNote() {
		return specialNote;
	}

	public String getTpNumber() {
		return tpNumber;
	}



	
	
}
