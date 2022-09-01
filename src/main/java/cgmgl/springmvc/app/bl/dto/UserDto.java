package cgmgl.springmvc.app.bl.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>UserDto Class</h2>
 * <p>
 * Process for Displaying UserDto
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private Long id;

    /**
     * <h2>username</h2>
     * <p>
     * username
     * </p>
     */
    @NotEmpty
    private String username;

    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    private String password;

    /**
     * <h2>email</h2>
     * <p>
     * email
     * </p>
     */
    @NotEmpty
    private String email;

    /**
     * <h2>type</h2>
     * <p>
     * type
     * </p>
     */
    private String type;

    /**
     * <h2>created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    private Date created_at;

    /**
     * <h2>updated_at</h2>
     * <p>
     * updated_at
     * </p>
     */
    private Date updated_at;

    /**
     * <h2>deleted_at</h2>
     * <p>
     * deleted_at
     * </p>
     */
    private Date deleted_at;

    /**
     * <h2>company_id</h2>
     * <p>
     * company_id
     * </p>
     */
    private int company_id;

    /**
     * <h2>Constructor for UserDto</h2>
     * <p>
     * Constructor for UserDto
     * </p>
     * 
     * @param user
     */
    public UserDto(User user) {
        super();
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.company_id = user.getCompany_id();
        this.created_at = user.getCreated_at();
        this.deleted_at = user.getDeleted_at();

    }

}