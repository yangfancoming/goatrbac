package com.goat.rbac.goatrbac.buzz.service.impl;

import com.goat.rbac.goatrbac.buzz.dao.DeviceMapper;
import com.goat.rbac.goatrbac.buzz.model.Device;
import com.goat.rbac.goatrbac.buzz.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:42
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public int insert(Device device) {
        int insert = deviceMapper.insert(device);
        return insert;
    }
}
