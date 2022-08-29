package cgmgl.springmvc.app.bl.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import cgmgl.springmvc.app.bl.service.PasswordResetService;
import cgmgl.springmvc.app.persistence.dao.PasswordResetDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.PasswordReset;
import cgmgl.springmvc.app.persistence.entity.User;





@Transactional
@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    public static final int psw_token_length = 20;

    /**
     * <h2>psw_token_expired_minute</h2>
     * <p>
     * psw_token_expired_minute
     * </p>
     */
    public static final int psw_token_expired_minute = 3;

    /**
     * <h2>now</h2>
     * <p>
     * now
     * </p>
     */
    private Timestamp now = new Timestamp(new Date(System.currentTimeMillis()).getTime());

    /**
     * <h2>passwordResetDAO</h2>
     * <p>
     * passwordResetDAO
     * </p>
     */
    @Autowired
    PasswordResetDao passwordResetDAO;
    
    @Autowired
    UserDao userDAO;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public PasswordResetMailForm createResetToken(String user_email) {
        if (isEmailExit(user_email)) {
            passwordResetDAO.deleteTokenByEmail(user_email);
        }
        String token = UUID.randomUUID().toString();
        Timestamp expired = new Timestamp(
                new Date(System.currentTimeMillis() + psw_token_expired_minute * 60 * 1000).getTime());
        System.out.println(expired);
        PasswordResetMailForm passwordResetForm = new PasswordResetMailForm();
        passwordResetForm.setUser_email(user_email);
        passwordResetForm.setToken(token);
        passwordResetForm.setCreated_at(now);
        passwordResetForm.setExpired_at(expired);
        this.passwordResetDAO.createToken(this.getPswToken(passwordResetForm));
        return passwordResetForm;
       
    }

    private boolean isEmailExit(String user_email) {
        PasswordReset pwToken = this.passwordResetDAO.getTokenDataByEmail(user_email);
        return pwToken != null;
    }

    private Object getPswToken(PasswordResetMailForm passwordResetForm) {
        PasswordReset pwToken = new PasswordReset();
        pwToken.setUser_email(passwordResetForm.getUser_email());
        pwToken.setToken(passwordResetForm.getToken());
        pwToken.setCreated_at(passwordResetForm.getCreated_at());
        pwToken.setExpired_at(passwordResetForm.getExpired_at());
        return pwToken;
    }

    @Override
    public PasswordResetMailForm getDataByToken(String token) {
        try {
            PasswordResetMailForm passwordResetMailForm = new PasswordResetMailForm(
                    passwordResetDAO.dbGetDataByToken(token));
            return passwordResetMailForm;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void doUpdatePassword(PasswordResetMailForm newPasswordResetForm) {
        newPasswordResetForm.setPassword(passwordEncoder.encode(newPasswordResetForm.getPassword()));
        User user = this.userDAO.dbFindUserByAllEmail(newPasswordResetForm.getUser_email());
        user.setPassword(newPasswordResetForm.getPassword());
        this.userDAO.dbUpdateUserPassword(user);
        

    }

    @Override
    public void doDeleteToken(String token) {
        this.passwordResetDAO.dbDeleteToken(token);
        
    }

}
