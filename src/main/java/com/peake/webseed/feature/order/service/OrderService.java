package com.peake.webseed.feature.order.service;

import com.peake.webseed.core.Service;
import com.peake.webseed.feature.order.model.Order;

import java.util.HashMap;


/**
 * Created by CodeGenerator on 2018/10/07.
 */
public interface OrderService extends Service<Order> {
    HashMap<String,Object>  findDetailById(long id);
}
