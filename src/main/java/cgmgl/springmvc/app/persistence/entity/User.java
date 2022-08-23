package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Class User.
 */
@Entity
@Table(name = "user")
@DynamicUpdate
public class User implements Serializable{

	/** Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/** username. */
	@Column(name = "username", nullable = false, length = 120)
	private String username;
	
	/** email. */
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;
	
	/** password. */
	@Column(name = "password", nullable = false)
	private String password;
	
	/** gender. */
	@Column(name = "gender", length = 1)
	private char gender;
	
	/** address. */
	@Column(name = "address")
	private String address;
	
	/** created at. */
	@Column(name = "created_at", updatable = false)
	private Timestamp createdAt;
	
	/** updated at. */
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	/** Auto Generate Getter Setter */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
