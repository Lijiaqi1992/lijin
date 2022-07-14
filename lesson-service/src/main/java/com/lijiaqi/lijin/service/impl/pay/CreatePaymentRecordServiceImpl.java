package com.lijiaqi.lijin.service.impl.pay;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.lijiaqi.lijin.api.pay.service.CreatePaymentRecordService;
import com.lijiaqi.lijin.dao.PaymentRecordPOMapper;
import com.lijiaqi.lijin.po.PaymentRecordPO;
import com.ljq.plugins.base.common.CommonTools;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@Service
public class CreatePaymentRecordServiceImpl implements CreatePaymentRecordService {
    @Resource
    PaymentRecordPOMapper paymentRecordPOMapper;

    @Override
    public int createPaymentRecordService(PaymentRecordBO paymentRecordBO) {
        PaymentRecordPO po = new PaymentRecordPO();
        BeanUtils.copyProperties(paymentRecordBO, po);
        po.setPaymentId(CommonTools.idGenerate());
        po.setCreatedDateTime(new Date());
        return paymentRecordPOMapper.insert(po);
    }
}
