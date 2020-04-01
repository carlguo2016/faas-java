package com.asu.ota.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Author: carl
 * @Date: 2020-01-16 13:51
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserStatusEnum implements IEnum<Integer> {
    FORBID(0, "禁用"),
    NORMAL(1, "正常");

    private Integer value;
    private String desc;

    UserStatusEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
