package com.infy.beans;

/**
 * Created by Anik.B on 8/23/2016.
 */
public class Employee {
    private String empNo;
    private String empName;
    private String accountType;
    private String empType;
    private Float totalHoursWorked;
    private Float totalBillableDays;
    private String TelstraManager;
    private Float rate;
    private String teamName;
    private String location;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(Float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public String getTelstraManager() {
        return TelstraManager;
    }

    public void setTelstraManager(String telstraManager) {
        TelstraManager = telstraManager;
    }

    public Float getTotalBillableDays() {
        return totalBillableDays;
    }

    public void setTotalBillableDays(Float totalBillableDays) {
        this.totalBillableDays = totalBillableDays;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
