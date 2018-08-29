package model;

public class AccountError {
    private String aeID;
    private String accountTime;
    private String bankID;
    private String btID;
    private String customerID;
    private String bankAmount;
    private String corpAmount;
    private String accountInfo;

    public String getAeID() {
        return aeID;
    }

    public void setAeID(String aeID) {
        this.aeID = aeID;
    }

    public String getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(String accountTime) {
        this.accountTime = accountTime;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(String bankAmount) {
        this.bankAmount = bankAmount;
    }

    public String getCorpAmount() {
        return corpAmount;
    }

    public void setCorpAmount(String corpAmount) {
        this.corpAmount = corpAmount;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public AccountError(String aeID, String accountTime, String bankID, String btID, String customerID, String bankAmount, String corpAmount, String accountInfo) {
        this.aeID = aeID;
        this.accountTime = accountTime;
        this.bankID = bankID;
        this.btID = btID;
        this.customerID = customerID;
        this.bankAmount = bankAmount;
        this.corpAmount = corpAmount;
        this.accountInfo = accountInfo;
    }
}
