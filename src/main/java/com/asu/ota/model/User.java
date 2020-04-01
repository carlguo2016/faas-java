package com.asu.ota.model;

import java.util.Date;

import com.asu.ota.model.enums.UserStatusEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author carl
 * @Date 2020-04-01 13:00
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;

    @TableField("sex")
    private Integer sex;

    @TableField("status")
    private UserStatusEnum status;

    @TableField("create_time")
    private Date createTime;

    @TableField(value = "update_time", update = "now()")
    private Date updateTime;
}
