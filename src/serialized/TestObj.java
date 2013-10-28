package serialized;

import java.io.Serializable;

public class TestObj implements Serializable{

	public String name;
	public int value;
	
	public TestObj(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public void setName(String arg){
		this.name = arg;
	}
	
	public void setValue(int arg){
		this.value = arg;
	}
}