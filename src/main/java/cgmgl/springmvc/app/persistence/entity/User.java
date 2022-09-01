package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * <h2> User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@DynamicUpdate
public class User implements Serializable {

	/** Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String email;

	private String password;

	private Date created_at;

	private Date updated_at;

	private Date deleted_at;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "info_id")
	private ApplicantInfo applicantInfo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authority> authorities = new ArrayList<Authority>();
	
	public User(UserDto userform) {
		this.id = userform.getId();
		this.name = userform.getUsername();
		this.email = userform.getEmail();
		this.password = userform.getPassword();
		this.created_at = userform.getCreated_at();
		this.updated_at = userform.getUpdated_at();
		this.deleted_at = userform.getDeleted_at();
		this.applicantInfo = userform.getApplicantInfo();
		this.authorities = userform.getAuthorityList();
		
	}
	
	public User(ApplicantDto applicantForm) {
		this.id = applicantForm.getUser().getId();
		this.name = applicantForm.getUser().getName();
		this.email = applicantForm.getUser().getEmail();
		this.password = applicantForm.getUser().getPassword();
		this.created_at = applicantForm.getUser().getCreated_at();
		this.updated_at = applicantForm.getUser().getUpdated_at();
		this.deleted_at = applicantForm.getUser().getDeleted_at();
		this.applicantInfo = applicantForm.getUser().getApplicantInfo();
		this.authorities = applicantForm.getUser().getAuthorities();
	}
}

	/** id. */
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "id") private int id;
	 * 
	 *//** username. */
	/*
	 * @Column(name = "username", nullable = false, length = 120) private String
	 * username;
	 * 
	 *//** email. */
	/*
	 * @Column(name = "email", unique = true, nullable = false, length = 50) private
	 * String email;
	 * 
	 *//** password. */
	/*
	 * @Column(name = "password", nullable = false) private String password;
	 * 
	 *//** gender. */
	/*
	 * @Column(name = "gender", length = 1) private char gender;
	 * 
	 *//** address. */
	/*
	 * @Column(name = "address") private String address;
	 * 
	 *//** created at. */
	/*
	 * @Column(name = "created_at", updatable = false) private Timestamp createdAt;
	 * 
	 *//** updated at. */
	/*
	 * @Column(name = "updated_at") private Timestamp updatedAt;
	 * 
	 *//** Auto Generate Getter Setter *//*
	                                      * 
	                                      * public int getId() { return id; }
	                                      * 
	                                      * public void setId(int id) { this.id = id; }
	                                      * 
	                                      * public String getUsername() { return username; }
	                                      * 
	                                      * public void setUsername(String username) { this.username = username; }
	                                      * 
	                                      * public String getEmail() { return email; }
	                                      * 
	                                      * public void setEmail(String email) { this.email = email; }
	                                      * 
	                                      * public String getPassword() { return password; }
	                                      * 
	                                      * public void setPassword(String password) { this.password = password; }
	                                      * 
	                                      * public char getGender() { return gender; }
	                                      * 
	                                      * public void setGender(char gender) { this.gender = gender; }
	                                      * 
	                                      * public String getAddress() { return address; }
	                                      * 
	                                      * public void setAddress(String address) { this.address = address; }
	                                      * 
	                                      * public Timestamp getCreatedAt() { return createdAt; }
	                                      * 
	                                      * public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt;
	                                      * }
	                                      * 
	                                      * public Timestamp getUpdatedAt() { return updatedAt; }
	                                      * 
	                                      * public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt;
	                                      * }
	                                      */