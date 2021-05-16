package com.peake.webseed.feature.order.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.order.model.Order;

import java.util.HashMap;

public interface OrderMapper extends Mapper<Order> {
    HashMap<String, Object> findDetailById(long id);
}