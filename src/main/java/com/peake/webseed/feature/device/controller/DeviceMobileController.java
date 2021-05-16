package com.peake.webseed.feature.device.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.feature.device.service.DeviceService;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.feature.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/09/05.
*/
@RestController
@RequestMapping("/mobile/device")
public class DeviceMobileController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(DeviceMobileController.class);

    @Resource
    private DeviceService deviceService;
    @Resource
    private MerchantService merchantService;

    @PostMapping("/detailByCode")
    public Result detailByCode(@RequestParam String code) {
        Map<String, Object> resultMap = new HashMap<>();
        Device device = deviceService.findDeviceByCode(code);
        resultMap.put("device",device);
        if (device.getFkMerchantId() != null && device.getFkMerchantId() != 0){
            Merchant merchant = merchantService.findById(device.getFkMerchantId());
            resultMap.put("merchant",merchant);
        }
        return ResultGenerator.genSuccessResult(resultMap);
    }
}
