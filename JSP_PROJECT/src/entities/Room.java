package entities;

public class Room {
     private String roomid;
     private int availability;
     private String typefroom;
     private String serviceincharge;
     
	public Room(String roomid, int availability, String typefroom, String serviceincharge) {
		super();
		this.roomid = roomid;
		this.availability = availability;
		this.typefroom = typefroom;
		this.serviceincharge = serviceincharge;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getTypefroom() {
		return typefroom;
	}

	public void setTypefroom(String typefroom) {
		this.typefroom = typefroom;
	}

	public String getServiceincharge() {
		return serviceincharge;
	}

	public void setServiceincharge(String serviceincharge) {
		this.serviceincharge = serviceincharge;
	}
     
     
}
