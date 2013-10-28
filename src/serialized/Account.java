package serialized;

import java.io.Serializable;

public class Account implements Serializable{

	private String acc;
	private String pwd;

	public Account(String acc, String pwd) {
		this.acc = acc;
		this.pwd = pwd;
	}

	public String getAcc() {
		return this.acc;
	}

	public String getPwd() {
		return this.pwd;
	}

}
