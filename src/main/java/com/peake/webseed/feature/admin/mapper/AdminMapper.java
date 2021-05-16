package com.peake.webseed.feature.admin.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.admin.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends Mapper<Admin> {

    void batchDelete(Long ids[]);
}