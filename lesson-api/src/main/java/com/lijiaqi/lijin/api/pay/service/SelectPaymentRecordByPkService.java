package com.lijiaqi.lijin.api.pay.service;

import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;

public interface SelectPaymentRecordByPkService {
    PaymentRecordBO selectPaymentRecordByPk(String id);
}
