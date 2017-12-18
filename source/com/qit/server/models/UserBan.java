package com.qit.server.models;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "user_bans")
public class UserBan {

    @Id
    @SequenceGenerator(name = "user_bans_seq", sequenceName = "user_bans_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_bans_seq")
    @Column(name = "user_ban_id")
    private Long userBanId;

    @Column(name = "ban_owner_username")
    private String banOwnerUsername;

    @Column(name = "banned_user_username")
    private String bannedUserUsername;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    public Long getUserBanId() {
        return userBanId;
    }

    public void setUserBanId(Long userBanId) {
        this.userBanId = userBanId;
    }

    public String getBanOwnerUsername() {
        return banOwnerUsername;
    }

    public void setBanOwnerUsername(String banOwnerUsername) {
        this.banOwnerUsername = banOwnerUsername;
    }

    public String getBannedUserUsername() {
        return bannedUserUsername;
    }

    public void setBannedUserUsername(String bannedUserUsername) {
        this.bannedUserUsername = bannedUserUsername;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "UserBan{" +
                "userBanId=" + userBanId +
                ", banOwnerUsername='" + banOwnerUsername + '\'' +
                ", bannedUserUsername='" + bannedUserUsername + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
