package ness.tomerbu.edu.firepractice.models;

/**
 * Created by android on 18/07/2016.
 */
//POJO
public class User {
    private String email;
    private String UID;

    public User(String email, String UID) {
        this.email = email;
        this.UID = UID;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
