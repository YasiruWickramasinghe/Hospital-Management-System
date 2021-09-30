package entities;

public  class User {
	protected int userIDnumber=0;
	protected String fName=""; 
	protected String lName=""; 
	protected String dob="";
	protected String address=""; 
	protected String userType=""; 
	protected String userName="";
	protected String password=""; 
	//protected String email=""; 
	
	public User(int userIDnumber, String fName, String lName, String dob, String address, String userType, 
			String userName,  String password) {
		super();
		this.userIDnumber = userIDnumber;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.address = address;
		this.userType = userType;
		this.userName = userName;
		//this.email = email;
		this.password = password;
	}
	
//akalanka
	public User( String fName, String lName, String dob, String address, String userType,String userName) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.address = address;
		this.userType = userType;
		this.userName = userName;

	}

	//akalanka
	public User(int userIDnumber,String userName,  String userType) {
			super();
			
			this.userType = userType;
			this.userName = userName;
			this.userIDnumber = userIDnumber;

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
//
//	public String getEmail() {
//		return email;
//	}


}
