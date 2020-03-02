package com.goat.rbac.goatrbac.buzz.controller;

import com.goat.rbac.goatrbac.buzz.service.IDeviceService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:44
 */

@RestController
public class DeviceController extends BaseController {

    @Autowired
    IDeviceService iDeviceService;



}
