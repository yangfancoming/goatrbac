package com.goat.rbac.goatrbac.buzz.dao;

import com.goat.rbac.goatrbac.buzz.model.Device;

import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:37
 */
public interface DeviceMapper {

    int insert(Device device);

    List<Device> find(Device dept);
}
