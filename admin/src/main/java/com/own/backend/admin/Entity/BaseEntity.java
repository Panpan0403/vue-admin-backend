package com.own.backend.admin.Entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.own.backend.enums.EnumDelete;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @Author fangting
 * @create 2020/11/4 15:23
 * @description
 **/
@ApiModel("基础实体")
@Data
public class BaseEntity {

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("是否删除")
    private EnumDelete isDelete = EnumDelete.N;

    @ApiModelProperty("版本")
    @Version
    private Long version;

}
