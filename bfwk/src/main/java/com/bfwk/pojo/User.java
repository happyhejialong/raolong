package com.bfwk.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.annotation.JSONField;
import com.bfwk.common.validate.Delete;
import com.bfwk.common.validate.Select;
import com.bfwk.common.validate.Update;

public class User extends BasePojo {
    @NotNull(message = "id not null", groups = { Select.class, Update.class, Delete.class })
    private String id;
    private String nickname;
    @NotNull(message = "username not null", groups = { Select.class, Update.class, Delete.class })
    private String username;
    @NotNull(message = "username not null", groups = { Select.class, Update.class, Delete.class })
    private String password;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private char gender;
    private Integer age;
    private Integer state;
    private Integer level;// '0管理员 1网管 2服务员 3客户',
    private Double balance;
    private Date loginTime;
    private String headImg;
    private String cardID;
    private String telphone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        loginTime = loginTime;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

}
