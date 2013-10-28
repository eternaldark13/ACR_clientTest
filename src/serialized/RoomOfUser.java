package serialized;

import java.io.Serializable;

public class RoomOfUser implements Serializable{

	public String user, roomId;
	
	public RoomOfUser(String user, String roomId){
		this.user = user;
		this.roomId = roomId;
	}
}
