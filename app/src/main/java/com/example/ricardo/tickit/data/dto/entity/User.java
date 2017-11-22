package com.example.ricardo.tickit.data.dto.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Ricardo on 2017/11/22.
 */
@Entity
public class User {
    @Id
    private Long id;
    private String password;
    private String userName;
    private String realName;
    private String avatarPath;
    private long mobileNumber;
    private String email;
    private Boolean isSuperuser = false;
    private int level = 1;
    private int experience = 0;
    @Generated(hash = 276614086)
    public User(Long id, String password, String userName, String realName,
            String avatarPath, long mobileNumber, String email, Boolean isSuperuser,
            int level, int experience) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.realName = realName;
        this.avatarPath = avatarPath;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.isSuperuser = isSuperuser;
        this.level = level;
        this.experience = experience;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRealName() {
        return this.realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getAvatarPath() {
        return this.avatarPath;
    }
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
    public long getMobileNumber() {
        return this.mobileNumber;
    }
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getIsSuperuser() {
        return this.isSuperuser;
    }
    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExperience() {
        return this.experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
