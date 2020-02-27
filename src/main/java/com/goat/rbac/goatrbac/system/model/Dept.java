package com.goat.rbac.goatrbac.system.model;


import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

	private Long deptId;

	private Long parentId;

	private String deptName;

	private Long orderNum;

	private Date createTime;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}