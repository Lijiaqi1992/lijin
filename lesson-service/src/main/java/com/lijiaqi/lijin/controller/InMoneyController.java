package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.service.CreateInMoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @描述： 用户模块
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@RestController
@RequestMapping(value = "/in")
public class InMoneyController extends BaseController{

    @Resource
    CreateInMoneyService createInMoneyService;

    @ResponseBody
    @PostMapping(value = "/create")
    public Object saveRecord(@RequestBody LjInMoneyBO ljInMoneyBO){
        ljInMoneyBO.setUserId(getCurrentUserId());
        return createInMoneyService.createInMoney(ljInMoneyBO);
    }
}
