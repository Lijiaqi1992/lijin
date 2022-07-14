package com.lijiaqi.lijin.service.impl.pay;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.pay.bo.PaymentRecordBO;
import com.lijiaqi.lijin.api.pay.service.SelectPageListPaymentRecordService;
import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.SelectStudentByPkService;
import com.lijiaqi.lijin.dao.PaymentRecordPOMapper;
import com.lijiaqi.lijin.po.PaymentRecordPO;
import com.lijiaqi.lijin.po.PaymentRecordPOCriterion;
import com.ljq.plugins.base.page.RspPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@Service
public class SelectPageListPaymentRecordServiceImpl implements SelectPageListPaymentRecordService {
    @Resource
    PaymentRecordPOMapper paymentRecordPOMapper;

    @Resource
    SelectStudentByPkService selectStudentByPkService;

    @Override
    public RspPage<PaymentRecordBO> selectPageListPaymentRecordService(PaymentRecordBO paymentRecordBO) {
        PaymentRecordPOCriterion paymentRecordPOCriterion = new PaymentRecordPOCriterion();
        PaymentRecordPOCriterion.Criteria criteria = paymentRecordPOCriterion.createCriteria();
        if (StringUtils.isNotEmpty(paymentRecordBO.getStudentId())) {
            criteria.andStudentIdEqualTo(paymentRecordBO.getStudentId());
        }
        Page<PaymentRecordBO> page = PageHelper.startPage(paymentRecordBO.getPageNo(), paymentRecordBO.getPageSize());
        List<PaymentRecordPO> paymentRecordPOSList = paymentRecordPOMapper.selectByExample(paymentRecordPOCriterion);
        List<PaymentRecordBO> list = paymentRecordPOSList.stream().map(po -> {
            PaymentRecordBO bo = new PaymentRecordBO();
            BeanUtils.copyProperties(po, bo);
            StudentsBO studentsBO = selectStudentByPkService.selectStudentByPkService(bo.getStudentId());
            bo.setStudentName(studentsBO.getStudentName());
            return bo;
        }).collect(Collectors.toList());
        RspPage<PaymentRecordBO> rspPage = new RspPage<>();

        rspPage.setResult(list);
        rspPage.setPageNo(paymentRecordBO.getPageNo());
        rspPage.setTotalPages(page.getPages());
        rspPage.setTotalCount((int) page.getTotal());
        return rspPage;
    }
}
