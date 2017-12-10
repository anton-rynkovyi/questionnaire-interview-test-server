package com.qit.models;

import java.math.BigInteger;
import java.util.Date;

public class UserBan {

    private BigInteger userBanId;
    private BigInteger banOwnerId;
    private BigInteger bannedUserId;
    private Date startDate;
    private Date endDate;

    public BigInteger getUserBanId() {
        return userBanId;
    }

    public void setUserBanId(BigInteger userBanId) {
        this.userBanId = userBanId;
    }

    public BigInteger getBanOwnerId() {
        return banOwnerId;
    }

    public void setBanOwnerId(BigInteger banOwnerId) {
        this.banOwnerId = banOwnerId;
    }

    public BigInteger getBannedUserId() {
        return bannedUserId;
    }

    public void setBannedUserId(BigInteger bannedUserId) {
        this.bannedUserId = bannedUserId;
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

    @Override
    public String toString() {
        return "UserBan{" +
                "userBanId=" + userBanId +
                ", banOwnerId=" + banOwnerId +
                ", bannedUserId=" + bannedUserId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
