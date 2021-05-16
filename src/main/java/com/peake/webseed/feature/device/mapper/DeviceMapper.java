package com.peake.webseed.feature.device.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.device.model.Device;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMapper extends Mapper<Device> {

    void batchDelete(Long ids[]);

    Device findByCode(String code);
}