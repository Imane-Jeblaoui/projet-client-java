package ma.entities;

import java.io.Serializable;  
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: SmartPhone
 *
 */
@Entity

public class SmartPhone implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imei;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "user_id")
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
