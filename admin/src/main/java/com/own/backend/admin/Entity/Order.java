package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.own.backend.admin.Enums.EnumOrderType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author fangting
 * @create 2020/12/3 10:38
 * @description 交易实体
 **/
@ApiModel("交易表")
@Data
@TableName("order_info")
public class Order extends BaseEntity{
    @ApiModelProperty("订单编号")
    @TableId(value = "order_no", type = IdType.INPUT)
    private Long orderNo;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("类型")
    private String status;

    @ApiModelProperty("用户名称")
    private String userName;
}
