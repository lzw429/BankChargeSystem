package model;

public class AccountTotal {
    private String atID;
    private String accountDate;
    private String bankID;
    private String bankCount;
    private String bankAmount;
    private String corpCount;
    private String corpAmount;
    private String isSuccess;

    public String getAtID() {
        return atID;
    }

    public void setAtID(String atID) {
        this.atID = atID;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getBankCount() {
        return bankCount;
    }

    public void setBankCount(String bankCount) {
        this.bankCount = bankCount;
    }

    public String getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(String bankAmount) {
        this.bankAmount = bankAmount;
    }

    public String getCorpCount() {
        return corpCount;
    }

    public void setCorpCount(String corpCount) {
        this.corpCount = corpCount;
    }

    public String getCorpAmount() {
        return corpAmount;
    }

    public void setCorpAmount(String corpAmount) {
        this.corpAmount = corpAmount;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public AccountTotal(String atID, String accountDate, String bankID, String bankCount, String bankAmount, String corpCount, String corpAmount, String isSuccess) {
        this.atID = atID;
        this.accountDate = accountDate;
        this.bankID = bankID;
        this.bankCount = bankCount;
        this.bankAmount = bankAmount;
        this.corpCount = corpCount;
        this.corpAmount = corpAmount;
        this.isSuccess = isSuccess;
    }
}
