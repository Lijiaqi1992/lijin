package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.in.bo.DeleteInBO;
import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.in.service.CreateInMoneyService;
import com.lijiaqi.lijin.api.in.service.DeleteInMoneyService;
import com.lijiaqi.lijin.api.in.service.SelectInPageListService;
import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;
import com.lijiaqi.lijin.api.out.service.CreateOutMoneyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @描述： 送礼
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@RestController
@RequestMapping(value = "/out")
public class OutMoneyController extends BaseController {

    @Resource
    CreateOutMoneyService createOutMoneyService;

    @ResponseBody
    @PostMapping(value = "/create")
    public Object saveRecord(@RequestBody LjOutMoneyBO ljOutMoneyBO) {
        ljOutMoneyBO.setUserId(getCurrentUserId());
        return createOutMoneyService.createOutMoney(ljOutMoneyBO);
    }

    @ResponseBody
    @PostMapping(value = "/list")
    public Object list(@RequestBody SearchOutBO searchOutBO) {

    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody ) {

    }

}
