package cgmgl.springmvc.app.bl.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetForm {
    /**
     * <h2>email</h2>
     * <p>
     * email
     * </p>
     */
    @Email
    @NotEmpty
    private String email;

    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    @Size(min = 6, max = 12)
    private String password;

    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    private String token;
}
