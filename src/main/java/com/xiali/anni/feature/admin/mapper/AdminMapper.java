package com.xiali.anni.feature.admin.mapper;

import com.xiali.anni.core.Mapper;
import com.xiali.anni.feature.admin.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends Mapper<Admin> {

    void batchDelete(Long ids[]);
}