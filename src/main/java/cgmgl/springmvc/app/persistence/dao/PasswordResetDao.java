package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.PasswordReset;

public interface PasswordResetDao {

    void createToken(Object pswToken);

    PasswordReset getTokenDataByEmail(String user_email);

    void deleteTokenByEmail(String user_email);

    PasswordReset dbGetDataByToken(String token);

    void dbDeleteToken(String token);

}
