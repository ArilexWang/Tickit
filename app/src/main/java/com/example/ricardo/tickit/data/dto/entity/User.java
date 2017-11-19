package com.example.ricardo.tickit.data.dto.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Ricardo on 2017/11/11.
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public Boolean getSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(Boolean superuser) {
        isSuperuser = superuser;
    }

    @Generated(hash = 861448798)
    public User(Long id, String password, String realName, String userName, long mobileNumber) {
        this.id = id;
        this.password = password;
        this.realName = realName;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
