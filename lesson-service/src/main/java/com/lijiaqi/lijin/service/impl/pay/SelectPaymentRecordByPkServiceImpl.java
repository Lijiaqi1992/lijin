package com.lijiaqi.lijin.service.impl.pay;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.lijiaqi.lijin.api.pay.service.SelectPaymentRecordByPkService;
import com.lijiaqi.lijin.dao.PaymentRecordPOMapper;
import com.lijiaqi.lijin.po.PaymentRecordPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-03
 */
@Service
public class SelectPaymentRecordByPkServiceImpl implements SelectPaymentRecordByPkService {
    @Resource
    PaymentRecordPOMapper paymentRecordPOMapper;

    @Override
    public PaymentRecordBO selectPaymentRecordByPk(String id) {
        PaymentRecordPO paymentRecordPO = paymentRecordPOMapper.selectByPrimaryKey(id);
        PaymentRecordBO paymentRecordBO = new PaymentRecordBO();
        BeanUtils.copyProperties(paymentRecordPO, paymentRecordBO);
        return paymentRecordBO;
    }
}
