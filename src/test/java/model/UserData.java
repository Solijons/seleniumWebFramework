package model;

public class UserData {
    public String getUsername() {
        return username;
    }

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }

    private String username;
    private String password;
}
