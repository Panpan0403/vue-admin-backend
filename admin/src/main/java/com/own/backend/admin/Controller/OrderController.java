package com.own.backend.admin.Controller;

import com.own.backend.admin.Common.Message;
import com.own.backend.admin.Service.ServiceImpl.OrderService;
import com.own.backend.admin.Vo.Reponse.OrderListRep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author fangting
 * @create 2020/12/3 10:35
 * @description 交易模块
 **/
@RestController
@Api(value = "交易模块", tags = "交易模块")
@RequestMapping("transaction")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "交易列表")
    @GetMapping("list")
    public Message<OrderListRep> list() {
        return Message.success(orderService.getList());
    }
}
