package serialized;

import java.io.Serializable;

public class ChatMsg implements Serializable{

	private String cmter, msg, roomId;
	private long time;
		
	public ChatMsg(String roomId, String cmter, String msg, long time){
		this.cmter = cmter;
		this.msg = msg;
		this.roomId = roomId;
		this.time = time;
	}
		
	public String getMsg(){
		return this.msg;
	}
	
	public String getCmter(){
		return this.cmter;
	}
	
	public String roomId(){
		return this.roomId;
	}
	
	public long getTime(){
		return this.time;
	}
}