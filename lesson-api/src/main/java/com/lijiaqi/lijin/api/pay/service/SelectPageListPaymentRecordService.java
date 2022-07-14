package com.lijiaqi.lijin.api.pay.service;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.ljq.plugins.base.page.RspPage;

public interface SelectPageListPaymentRecordService {
    RspPage<PaymentRecordBO> selectPageListPaymentRecordService(PaymentRecordBO paymentRecordBO);
}
