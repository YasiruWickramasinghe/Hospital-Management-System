package entities;

public class Prescription {
	
	String details="";
	int prescriptionid=0;
	String date ="";
	String status ="";
	String patientName="";
	String givenBy = "";
	
	
	public Prescription(String details, int prescriptionid, String date, String status) {
		super();
		this.details = details;
		this.prescriptionid = prescriptionid;
		this.date = date;
		this.status = status;
	}
	
	//malith
	
	public Prescription(String details, int prescriptionid, String date, String status , String patientName) {
		super();
		this.details = details;
		this.prescriptionid = prescriptionid;
		this.date = date;
		this.status = status;
		this.patientName = patientName;
		
	}
	//akalanka
	public Prescription(String details, int prescriptionid, String date, String status , String patientName , String givenBy) {
		super();
		this.details = details;
		this.prescriptionid = prescriptionid;
		this.date = date;
		this.status = status;
		this.patientName = patientName;
		this.givenBy = givenBy;
		
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public String getDetails() {
		return details;
	}
	public int getPriscriptionid() {
		return prescriptionid;
	}
	public String getGivenBy() {
		return givenBy;
	}
	public String getDate() {
		return date;
	}
	public String getStatus() {
		return status;
	}


}
