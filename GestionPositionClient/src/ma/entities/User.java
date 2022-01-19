package ma.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Entity implementation class for Entity: User
 *
 */
public class User implements Serializable {

	private int id;
	private String email;
	private String nom;
	private String prenom;
	private String telephone;
	private Date dateNaissance;
	private static final long serialVersionUID = 1L;


	public User() {
		super();
	}   
	
	public User(int id, String email, String nom, String prenom, String telephone, Date dateNaissance) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}
	
	
	public User(String email, String nom, String prenom, String telephone, Date dateNaissance) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return nom + prenom ;
	}

	
}
