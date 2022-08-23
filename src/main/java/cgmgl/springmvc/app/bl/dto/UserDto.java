package cgmgl.springmvc.app.bl.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cgmgl.springmvc.app.persistence.entity.User;


/**
 * Class UserDetailDto for user fetching and creating
 */
public class UserDto {
	
	/** id. */
	private int id;
	
	/** username. */
	@NotEmpty
	private String username;
	
	/** email. */
	@Email
	@NotEmpty
	private String email;
	
	/** password. */
	@NotEmpty
	@Size(max = 20)
	private String password;
	
	/** gender. */
	@NotNull
	private char gender;
	
	/** address. */
	@NotEmpty
	private String address;
	
	/** created at. */
	private Timestamp createdAt;
	
	/** updated at. */
	private Timestamp updatedAt;

	/**
	 * Instantiates a new user detail dto.
	 *
	 * @param user the user
	 */
	public UserDto(User user){
		if (user == null) {
			user = new User();
		}
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.gender = user.getGender();
		this.address = user.getAddress();
		this.createdAt = user.getCreatedAt();
		this.updatedAt = user.getUpdatedAt();
	}
	
	/**
	 * Getters and Setters
	 */

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
