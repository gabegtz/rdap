package controllers;

/**
 * Created by gegutier on 11/3/2016.
 */
public class UserSession {
    private String uname;

    private int sessionId;

    public UserSession(String uname) {
        this.uname=uname;

    }

    public String getUser (){
        return uname;
    }
}
