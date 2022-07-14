package com.lijiaqi.lijin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述： 用户模块
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ResponseBody
    @GetMapping("/d")
    public Object s(){
        return "2222";
    }
}
