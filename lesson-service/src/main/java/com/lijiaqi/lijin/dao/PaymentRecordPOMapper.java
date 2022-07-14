package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.PaymentRecordPO;
import com.lijiaqi.lijin.po.PaymentRecordPOCriterion;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentRecordPOMapper {
    long countByExample(PaymentRecordPOCriterion example);

    int deleteByPrimaryKey(String paymentId);

    int insert(PaymentRecordPO record);

    int insertSelective(PaymentRecordPO record);

    List<PaymentRecordPO> selectByExample(PaymentRecordPOCriterion example);

    PaymentRecordPO selectByPrimaryKey(String paymentId);

    int updateByExampleSelective(@Param("record") PaymentRecordPO record, @Param("example") PaymentRecordPOCriterion example);

    int updateByExample(@Param("record") PaymentRecordPO record, @Param("example") PaymentRecordPOCriterion example);

    int updateByPrimaryKeySelective(PaymentRecordPO record);

    int updateByPrimaryKey(PaymentRecordPO record);
}
