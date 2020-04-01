package com.asu.ota.bean.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: carl
 * @Date: 2020-04-01 13:09
 */
@Data
public class UserSavePO {
    Long id = 0L;
    @NotBlank(message = "姓名不能为空")
    String name = "";
    String phone = "";
    Integer sex = 0;
}
