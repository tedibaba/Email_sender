package sample;

public class User {
    //Use this to pass the email and password to the next scene

    private String email;
    private String password;
    private boolean darkMode;

    public User(String email, String password, boolean darkMode){
        this.email = email;
        this.password = password;
        this.darkMode = darkMode;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDarkMode() {
        return darkMode;
    }
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

}
