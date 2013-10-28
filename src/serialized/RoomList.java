package serialized;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomList implements Serializable{

	public Map<String, Integer> roomList = new HashMap<String, Integer>();
	
}