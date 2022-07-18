package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.in.bo.DeleteInBO;
import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.in.service.CreateInMoneyService;
import com.lijiaqi.lijin.api.in.service.DeleteInMoneyService;
import com.lijiaqi.lijin.api.in.service.SelectInPageListService;
import com.lijiaqi.lijin.api.out.bo.DeleteOutBO;
import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;
import com.lijiaqi.lijin.api.out.service.CreateOutMoneyService;
import com.lijiaqi.lijin.api.out.service.DeleteOutMoneyService;
import com.lijiaqi.lijin.api.out.service.SelectOutPageListService;
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

    @Resource
    SelectOutPageListService selectOutPageListService;

    @Resource
    DeleteOutMoneyService deleteOutMoneyService;

    @ResponseBody
    @PostMapping(value = "/create")
    public Object saveRecord(@RequestBody LjOutMoneyBO ljOutMoneyBO) {
        ljOutMoneyBO.setUserId(getCurrentUserId());
        return createOutMoneyService.createOutMoney(ljOutMoneyBO);
    }

    @ResponseBody
    @PostMapping(value = "/list")
    public Object list(@RequestBody SearchOutBO searchOutBO) {
        searchOutBO.setUserId(getCurrentUserId());
        return selectOutPageListService.getOutPageList(searchOutBO);
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody DeleteOutBO deleteOutBO) {
        deleteOutBO.setUserId(getCurrentUserId());
        return deleteOutMoneyService.deleteByIds(deleteOutBO);
    }

}
