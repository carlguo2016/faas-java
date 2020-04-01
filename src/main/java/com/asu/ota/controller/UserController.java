package com.asu.ota.controller;

import com.asu.ota.bean.po.UserSavePO;
import com.asu.ota.service.IUserService;
import com.asu.tool.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author carl
 * @Date 2020-04-01 13:35
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("添加/修改用户")
    @PostMapping(value = "/save")
    public Result save(@RequestBody @Valid UserSavePO po) {
        userService.saveUser(po);
        return Result.success();
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete")
    public Result deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return Result.success();
    }

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public Result userList(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        HashMap<String, Object> result = userService.getUserList(name.trim(), page, limit);
        return Result.success(result);
    }
}
