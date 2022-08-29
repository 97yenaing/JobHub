package cgmgl.springmvc.app.bl.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
   
    private Long id;
    
   @NotEmpty
    private String username;
    
   @NotEmpty
    private String password;
    
   @NotEmpty
    private String email;
    
   
    private String type;
    
   
    private Date created_at;
    
   
    private Date updated_at;
    
   
    private Date deleted_at;
    
    
    private int company_id;
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
