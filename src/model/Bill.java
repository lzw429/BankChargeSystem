package model;

public class Bill {
    private String deviceID; // 设备号
    private String payDate; // 应缴日期
    private String alreadyFee; // 已缴费用
    private String remainFee; // 剩余缴费
    private String lateFee; // 滞纳金
    private String arrearage; // 单月欠费金额
    private String prID; // 账单流水号

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }


    public String getAlreadyFee() {
        return alreadyFee;
    }

    public void setAlreadyFee(String alreadyFee) {
        this.alreadyFee = alreadyFee;
    }

    public String getRemainFee() {
        return remainFee;
    }

    public void setRemainFee(String remainFee) {
        this.remainFee = remainFee;
    }

    public String getLateFee() {
        return lateFee;
    }

    public void setLateFee(String lateFee) {
        this.lateFee = lateFee;
    }

    public String getArrearage() {
        return arrearage;
    }

    public void setArrearage(String arrearage) {
        this.arrearage = arrearage;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPrID() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID = prID;
    }

    public Bill(String deviceID, String payDate, String alreadyFee, String remainFee, String lateFee, String arrearage, String prID) {
        this.deviceID = deviceID;
        this.payDate = payDate;
        this.alreadyFee = alreadyFee;
        this.remainFee = remainFee;
        this.lateFee = lateFee;
        this.arrearage = arrearage;
        this.prID = prID;
    }
}
