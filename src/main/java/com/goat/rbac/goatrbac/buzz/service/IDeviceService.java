package com.goat.rbac.goatrbac.buzz.service;

import com.goat.rbac.goatrbac.buzz.model.Device;

import java.util.List;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
public interface IDeviceService {

    int insert(Device model);

    List<Device> find(Device model);

}
