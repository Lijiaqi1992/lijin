package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.in.bo.DeleteInBO;
import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.in.service.CreateInMoneyService;
import com.lijiaqi.lijin.api.in.service.DeleteInMoneyService;
import com.lijiaqi.lijin.api.in.service.SelectInListByNameService;
import com.lijiaqi.lijin.api.in.service.SelectInPageListService;
import com.ljq.plugins.base.exception.MyBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @描述： 收礼
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@RestController
@RequestMapping(value = "/in")
public class InMoneyController extends BaseController {

    @Resource
    CreateInMoneyService createInMoneyService;

    @Resource
    SelectInPageListService selectInPageListService;

    @Resource
    DeleteInMoneyService deleteInMoneyService;

    @Resource
    SelectInListByNameService selectInListByNameService;

    @ResponseBody
    @PostMapping(value = "/create")
    public Object saveRecord(@RequestBody LjInMoneyBO ljInMoneyBO) {
        ljInMoneyBO.setUserId(getCurrentUserId());
        return createInMoneyService.createInMoney(ljInMoneyBO);
    }

    @ResponseBody
    @PostMapping(value = "/pageList")
    public Object pageList(@RequestBody SearchInBO searchInBO) {
        searchInBO.setUserId(getCurrentUserId());
        return selectInPageListService.getInPageList(searchInBO);
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody DeleteInBO deleteInBO) {
        deleteInBO.setUserId(getCurrentUserId());
        return deleteInMoneyService.deleteByIds(deleteInBO);
    }

    @ResponseBody
    @PostMapping(value = "/list")
    public Object list(@RequestBody SearchInBO searchInBO) {
        if(StringUtils.isEmpty(searchInBO.getName())){
            throw new MyBusinessException(1, "姓名不可为空！");
        }
        searchInBO.setUserId(getCurrentUserId());
        return selectInListByNameService.getListByName(searchInBO);
    }

}
