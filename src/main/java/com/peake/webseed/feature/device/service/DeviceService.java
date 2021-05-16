package com.peake.webseed.feature.device.service;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.core.Service;


/**
 * Created by CodeGenerator on 2018/09/05.
 */
public interface DeviceService extends Service<Device> {

    Result deleteByIds(Long[] ids);

    Device findDeviceByCode(String code);
}
