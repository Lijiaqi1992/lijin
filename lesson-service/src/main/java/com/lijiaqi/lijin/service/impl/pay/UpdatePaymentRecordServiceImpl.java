package com.lijiaqi.lijin.service.impl.pay;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.lijiaqi.lijin.api.pay.service.UpdatePaymentRecordService;
import com.lijiaqi.lijin.dao.PaymentRecordPOMapper;
import com.lijiaqi.lijin.po.PaymentRecordPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-03
 */
@Service
public class UpdatePaymentRecordServiceImpl implements UpdatePaymentRecordService {
    @Resource
    PaymentRecordPOMapper paymentRecordPOMapper;

    @Override
    public int updatePaymentRecordService(PaymentRecordBO paymentRecordBO) {
        PaymentRecordPO po = new PaymentRecordPO();
        BeanUtils.copyProperties(paymentRecordBO, po);
        po.setUpdatedDateTime(new Date());
        return paymentRecordPOMapper.updateByPrimaryKeySelective(po);
    }
}
