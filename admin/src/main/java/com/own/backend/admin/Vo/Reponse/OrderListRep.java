package com.own.backend.admin.Vo.Reponse;

import com.own.backend.admin.Entity.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/3 14:04
 * @description
 **/
@Data
@ApiModel("order列表出参")
public class OrderListRep {
    @ApiModelProperty("总数")
    private int total;

    @ApiModelProperty("order列表")
    private List<Order> items;
}
