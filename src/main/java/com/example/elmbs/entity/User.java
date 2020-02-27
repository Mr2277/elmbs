package com.example.elmbs.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统用户(User)实体类
 *
 * @author makejava
 * @since 2020-02-27 15:10:13
 */
@Component
public class User implements Serializable {
    private static final long serialVersionUID = -70917807038407271L;
    /**
    * ID
    */
    private Long id;
    /**
    * 头像
    */
    private Long avatarId;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 状态：1启用、0禁用
    */
    private Long enabled;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户名
    */
    private String username;
    /**
    * 部门名称
    */
    private Long deptId;
    /**
    * 手机号码
    */
    private String phone;
    /**
    * 岗位名称
    */
    private Long jobId;
    /**
    * 创建日期
    */
    private Date createTime;
    /**
    * 最后修改密码的日期
    */
    private Date lastPasswordResetTime;

    private String nickName;

    private String sex;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPasswordResetTime() {
        return lastPasswordResetTime;
    }

    public void setLastPasswordResetTime(Date lastPasswordResetTime) {
        this.lastPasswordResetTime = lastPasswordResetTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
