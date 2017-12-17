package com.qit.server.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "user_bans")
public class UserBan {

    @Id
    @SequenceGenerator(name = "user_bans_seq", sequenceName = "user_bans_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_bans_seq")
    @Column(name = "user_ban_id")
    private Long userBanId;

    private Long banOwnerId;

    private Long bannedUserId;

    private Set<User> bannedUsers;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public Long getUserBanId() {
        return userBanId;
    }

    public void setUserBanId(Long userBanId) {
        this.userBanId = userBanId;
    }

    public Long getBanOwnerId() {
        return banOwnerId;
    }

    public void setBanOwnerId(Long banOwnerId) {
        this.banOwnerId = banOwnerId;
    }

    public Long getBannedUserId() {
        return bannedUserId;
    }

    public void setBannedUserId(Long bannedUserId) {
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
