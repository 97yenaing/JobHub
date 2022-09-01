package cgmgl.springmvc.app.persistence.entity;

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
import javax.persistence.Table;

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
@Table(name = "users")
public class User {
    /**
     * <h2> id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
    /**
     * <h2> username</h2>
     * <p>
     * username
     * </p>
     */
    private String username;
    
   
    /**
     * <h2> password</h2>
     * <p>
     * password
     * </p>
     */
    private String password;
    
   
    /**
     * <h2> email</h2>
     * <p>
     * email
     * </p>
     */
    private String email;
    
   
    /**
     * <h2> type</h2>
     * <p>
     * type
     * </p>
     */
    private String type;
    
   
    /**
     * <h2> created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    private Date created_at;
    
   
    /**
     * <h2> updated_at</h2>
     * <p>
     * updated_at
     * </p>
     */
    private Date updated_at;
    
   
    /**
     * <h2> deleted_at</h2>
     * <p>
     * deleted_at
     * </p>
     */
    private Date deleted_at;
    
    /**
     * <h2> company_id</h2>
     * <p>
     * company_id
     * </p>
     */
    @Column(name = "company_id")
    private int company_id;
    

    /**
     * <h2> authorities</h2>
     * <p>
     * authorities
     * </p>
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities = new ArrayList<Authority>();
}
