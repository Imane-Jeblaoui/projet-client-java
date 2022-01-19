package ma.entities;

import java.io.Serializable;
import java.util.List;


/**
 * Entity implementation class for Entity: SmartPhone
 *
 */


public class SmartPhone implements Serializable {

	  
	private int id;
	private String imei;
	private static final long serialVersionUID = 1L;
	private User user;

	
	public SmartPhone() {
		super();
	}
	
	public SmartPhone(String imei) {
		super();
		this.imei = imei;
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return imei;
	}

	
	
	
   
}
