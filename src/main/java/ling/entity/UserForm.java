package ling.entity;

public class UserForm {
    private String username;
    private String password;

    public UserForm(String username) {
        this.username = username;
    }

    public UserForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
