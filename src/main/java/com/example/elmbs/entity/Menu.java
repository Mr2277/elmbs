package com.example.elmbs.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统菜单(Menu)实体类
 *
 * @author makejava
 * @since 2020-02-29 17:29:39
 */
@Component
public class Menu implements Serializable {
    private static final long serialVersionUID = 750243010600746373L;
    /**
    * ID
    */
    private Long id;
    /**
    * 是否外链
    */
    private Object iFrame;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 组件
    */
    private String component;
    /**
    * 上级菜单ID
    */
    private Long pid;
    /**
    * 排序
    */
    private Long sort;
    /**
    * 图标
    */
    private String icon;
    /**
    * 链接地址
    */
    private String path;
    /**
    * 缓存
    */
    private Object cache;
    /**
    * 隐藏
    */
    private Object hidden;
    /**
    * 组件名称
    */
    private String componentName;
    /**
    * 创建日期
    */
    private Date createTime;
    /**
    * 权限
    */
    private String permission;
    /**
    * 类型
    */
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getIFrame() {
        return iFrame;
    }

    public void setIFrame(Object iFrame) {
        this.iFrame = iFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getCache() {
        return cache;
    }

    public void setCache(Object cache) {
        this.cache = cache;
    }

    public Object getHidden() {
        return hidden;
    }

    public void setHidden(Object hidden) {
        this.hidden = hidden;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
