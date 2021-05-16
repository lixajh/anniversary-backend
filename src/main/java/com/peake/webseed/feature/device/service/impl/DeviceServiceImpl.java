package com.peake.webseed.feature.device.service.impl;

import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.device.mapper.DeviceMapper;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.feature.device.service.DeviceService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/05.
 */
@Service
@Transactional
public class DeviceServiceImpl extends AbstractService<Device> implements DeviceService {

    Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public Result add(Device device) {
//        if (device.getCode())
        device.setCreateTime(now());
        device.setUpdateTime(now());
        save(device);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result deleteByIds(Long[] ids) {
        deviceMapper.batchDelete(ids);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Device findDeviceByCode(String code) {
        return deviceMapper.findByCode(code);

    }
}
