package model;

import java.io.Serializable;

public class Balance implements Serializable {
    private String balanceID;
    private String customerID;
    private String balanceDelta;
    private String balanceType;
    private String prID;
    private String payID;
    private String btID;
    private String notes;
    private String changeTime;

    public String getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(String balanceID) {
        this.balanceID = balanceID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getBalanceDelta() {
        return balanceDelta;
    }

    public void setBalanceDelta(String balanceDelta) {
        this.balanceDelta = balanceDelta;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public String getPrID() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID = prID;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getBtID() {
        return btID;
    }

    public void setBtID(String btID) {
        this.btID = btID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public Balance(String balanceID, String customerID, String balanceDelta, String balanceType, String prID, String payID, String btID, String notes, String changeTime) {
        this.balanceID = balanceID;
        this.customerID = customerID;
        this.balanceDelta = balanceDelta;
        this.balanceType = balanceType;
        this.prID = prID;
        this.payID = payID;
        this.btID = btID;
        this.notes = notes;
        this.changeTime = changeTime;
    }
}
