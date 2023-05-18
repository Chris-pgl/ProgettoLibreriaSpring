package com.example.demoProgettoLibreriaSpring.security.securityEntity;

public class RestorePasswordDTO {

    private String newPassword;
    private String resetPasswordCode;

    public RestorePasswordDTO() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }
}
