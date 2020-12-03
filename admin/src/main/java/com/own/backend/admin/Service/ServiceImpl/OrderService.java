package com.own.backend.admin.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.backend.admin.Entity.Order;
import com.own.backend.admin.Mapper.OrderMapper;
import com.own.backend.admin.Vo.Reponse.OrderListRep;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 10:58
 * @description
 **/
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    /**
     * 获取order列表
     */
    public OrderListRep getList() {
        OrderListRep orderList = new OrderListRep();
        orderList.setTotal(this.count());
        orderList.setItems(this.list());
        return orderList;
    }

}
