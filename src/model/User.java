package model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String CUSTOMER_NAME;
    private String password;
    private String ADDRESS;
    private String BALANCE;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(String BALANCE) {
        this.BALANCE = BALANCE;
    }

    public User(String username, String CUSTOMER_NAME, String ADDRESS, String BALANCE) {
        this.username = username;
        this.CUSTOMER_NAME = CUSTOMER_NAME;
        this.ADDRESS = ADDRESS;
        this.BALANCE = BALANCE;
    }
}
