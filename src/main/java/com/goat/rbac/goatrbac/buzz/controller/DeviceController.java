package com.goat.rbac.goatrbac.buzz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.rbac.goatrbac.buzz.model.Device;
import com.goat.rbac.goatrbac.buzz.service.IDeviceService;
import com.goat.rbac.goatrbac.system.controller.BaseController;
import com.goat.rbac.goatrbac.system.model.QueryRequest;
import com.goat.rbac.goatrbac.system.model.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/2---15:44
 */
@RestController
@RequestMapping("device")
public class DeviceController extends BaseController {

    @Autowired
    IDeviceService deviceService;

    @GetMapping("list")
    public Map<String, Object> deptList(QueryRequest request, Device device) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Device> devices = deviceService.find(device);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        return getDataTable(pageInfo);
    }

    @PostMapping("add")
    public ResponseBo addRole(Device device) {
        device.setCreateTime(new Date());
        int insert = deviceService.insert(device);
        return ResponseBo.ok("新增角色成功！"+insert);
    }

}
