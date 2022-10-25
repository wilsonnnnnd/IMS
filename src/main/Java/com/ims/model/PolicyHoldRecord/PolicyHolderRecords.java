package com.ims.model.PolicyHoldRecord;

import java.util.Date;

public class PolicyHolderRecords {
    private Long id;
    private String policyNumber;
    private String customerId;

    private Date appliedDate;
    private String status;
    private Date startDate;
    private Date endDate;
    private String premium;
    private String otherDetails;
    private String agent;
    private String customer;

    public PolicyHolderRecords(String policyNumber, String customerId, Date appliedDate, String status, Date startDate, Date endDate, String premium, String otherDetails, String agent) {

        this.policyNumber = policyNumber;
        this.customerId = customerId;

        this.appliedDate = appliedDate;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.otherDetails = otherDetails;
        this.agent = agent;
    }

    public PolicyHolderRecords() {

    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
