package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.lijiaqi.lijin.api.pay.service.CreatePaymentRecordService;
import com.lijiaqi.lijin.api.pay.service.SelectPageListPaymentRecordService;
import com.lijiaqi.lijin.api.pay.service.SelectPaymentRecordByPkService;
import com.lijiaqi.lijin.api.pay.service.UpdatePaymentRecordService;
import com.ljq.plugins.base.page.RspPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@RestController
@RequestMapping(value = "/paymentRecord")
public class PaymentRecordController {

    @Resource
    CreatePaymentRecordService createPaymentRecordService;

    @Resource
    SelectPageListPaymentRecordService selectPageListPaymentRecordService;

    @Resource
    SelectPaymentRecordByPkService selectPaymentRecordByPkService;

    @Resource
    UpdatePaymentRecordService updatePaymentRecordService;

    @ResponseBody
    @RequestMapping(value = "/create")
    public Object createStudent(@RequestBody PaymentRecordBO paymentRecordBO) {
        int pm = createPaymentRecordService.createPaymentRecordService(paymentRecordBO);
        return pm;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Object updateStudent(@RequestBody PaymentRecordBO paymentRecordBO) {
        return updatePaymentRecordService.updatePaymentRecordService(paymentRecordBO);
    }


    @ResponseBody
    @RequestMapping(value = "/selectByPk/{id}")
    public Object selectByPk(@PathVariable String id) {
        return selectPaymentRecordByPkService.selectPaymentRecordByPk(id);
    }

    @ResponseBody
    @RequestMapping(value = "/pageList")
    public Object pageListStudents(@RequestBody PaymentRecordBO paymentRecordBO) {
        RspPage<PaymentRecordBO> paymentRecordBORspPage = selectPageListPaymentRecordService.selectPageListPaymentRecordService(paymentRecordBO);
        return paymentRecordBORspPage;
    }
}
