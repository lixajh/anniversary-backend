package com.peake.webseed.feature.device.controller;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.feature.device.service.DeviceService;
import com.peake.webseed.feature.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2018/09/05.
*/
@RestController
@RequestMapping("/manager/device")
public class DeviceManagerController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(DeviceManagerController.class);

    @Resource
    private DeviceService deviceService;
    @Resource
    private MerchantService merchantService;

    @PostMapping("/add")
    public Result add(Device device) {
        return deviceService.add(device);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long[] ids) {
        return  deviceService.deleteByIds(ids);
    }

    @PostMapping("/update")
    public Result update(Device device) {
        deviceService.update(device);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Device device = deviceService.findById(id);
        return ResultGenerator.genSuccessResult(device);
    }
    @PostMapping("/detailByCode")
    public Result detailByCode(@RequestParam String code) {
        Device device = deviceService.findDeviceByCode(code);
        return ResultGenerator.genSuccessResult(device);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Device device) {
       PageInfo pageInfo = deviceService.findbyCustomPage(page,size,device);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/deviceMerchantList")
    public Result deviceMerchantList() {
        return merchantService.getAllMerchants();
    }
}
