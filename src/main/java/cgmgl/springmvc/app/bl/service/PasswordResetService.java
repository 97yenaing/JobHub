package cgmgl.springmvc.app.bl.service;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;

public interface PasswordResetService {

    PasswordResetMailForm createResetToken(String user_email);

    PasswordResetMailForm getDataByToken(String token);

    void doUpdatePassword(PasswordResetMailForm newPasswordResetForm);

    void doDeleteToken(String token);

}
