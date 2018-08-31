package model;

import java.io.Serializable;

public class MeterLog implements Serializable {
    private String mtID;
    private String mtDate;
    private String deviceID;
    private String customerID;
    private String mtNumber;
    private String mrID;

    public String getMtID() {
        return mtID;
    }

    public void setMtID(String mtID) {
        this.mtID = mtID;
    }

    public String getMtDate() {
        return mtDate;
    }

    public void setMtDate(String mtDate) {
        this.mtDate = mtDate;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getMtNumber() {
        return mtNumber;
    }

    public void setMtNumber(String mtNumber) {
        this.mtNumber = mtNumber;
    }

    public String getMrID() {
        return mrID;
    }

    public void setMrID(String mrID) {
        this.mrID = mrID;
    }

    public MeterLog(String mtID, String mtDate, String deviceID, String customerID, String mtNumber, String mrID) {
        this.mtID = mtID;
        this.mtDate = mtDate;
        this.deviceID = deviceID;
        this.customerID = customerID;
        this.mtNumber = mtNumber;
        this.mrID = mrID;
    }
}
