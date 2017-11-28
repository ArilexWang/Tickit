package com.example.ricardo.tickit.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Ricardo on 2017/11/27.
 */
@Entity
public class GDUser {
    @Id
    private Long id;
    private String nickName;
    private String realName;
    private Long mobileNumber;
    private String password;
    @Generated(hash = 404411611)
    public GDUser(Long id, String nickName, String realName, Long mobileNumber,
            String password) {
        this.id = id;
        this.nickName = nickName;
        this.realName = realName;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
    @Generated(hash = 1014226889)
    public GDUser() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getRealName() {
        return this.realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public Long getMobileNumber() {
        return this.mobileNumber;
    }
    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
