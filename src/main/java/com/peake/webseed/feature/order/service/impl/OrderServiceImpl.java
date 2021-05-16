package com.peake.webseed.feature.order.service.impl;

import com.peake.webseed.feature.order.mapper.OrderMapper;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.order.service.OrderService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.HashMap;


/**
 * Created by CodeGenerator on 2018/10/07.
 */
@Service
@Transactional
public class OrderServiceImpl extends AbstractService<Order> implements OrderService {

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderMapper orderMapper;

    @Override
    public HashMap<String, Object> findDetailById(long id) {
        return orderMapper.findDetailById(id);
    }
}


