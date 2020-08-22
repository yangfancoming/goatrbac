package com.goat.rbac.goatrbac.buzz.model;

import java.util.Date;

/**
 * Created by Administrator on 2020/8/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/8/22---21:25
 */
public class BaseModel {

    private Date modifyTime;

    private Date createTime;

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
