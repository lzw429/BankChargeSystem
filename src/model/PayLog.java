package model;

public class PayLog {
    private String payID;
    private String customerID;
    private String payTime;
    private String payAmount;
    private String payType;
    private String bankID;
    private String btID;
    private String notes;

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
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

    public PayLog(String payID, String customerID, String payTime, String payAmount, String payType, String bankID, String btID, String notes) {
        this.payID = payID;
        this.customerID = customerID;
        this.payTime = payTime;
        this.payAmount = payAmount;
        this.payType = payType;
        this.bankID = bankID;
        this.btID = btID;
        this.notes = notes;
    }
}
