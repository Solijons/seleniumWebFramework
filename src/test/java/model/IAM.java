package model;

public class IAM {
    public String getUsername() {
        return username;
    }

    public IAM withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public IAM withPassword(String password) {
        this.password = password;
        return this;
    }

    private String username;
    private String password;
}
