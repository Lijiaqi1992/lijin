package com.lijiaqi.lijin.service.impl.in;

import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.service.CreateInMoneyService;
import com.lijiaqi.lijin.dao.LjInMoneyPOMapper;
import com.lijiaqi.lijin.dao.LjOutMoneyPOMapper;
import com.lijiaqi.lijin.po.LjInMoneyPO;
import com.lijiaqi.lijin.po.LjOutMoneyPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 李佳琪
 * 2022-07-13
 */
@Service
public class CreateInMoneyServiceImpl implements CreateInMoneyService {

    @Resource
    LjInMoneyPOMapper ljInMoneyPOMapper;

    @Resource
    LjOutMoneyPOMapper ljOutMoneyPOMapper;

    @Override
    @Transactional
    public int createInMoney(LjInMoneyBO ljInMoneyBO) {
        Date createDate = new Date();
        LjInMoneyPO ljInMoneyPO = new LjInMoneyPO();
        BeanUtils.copyProperties(ljInMoneyBO, ljInMoneyPO);

        ljInMoneyPO.setCreateDate(createDate);
        int insert = ljInMoneyPOMapper.insert(ljInMoneyPO);
        if(insert == 1 && ljInMoneyBO.getReturnMoney() > 0){
            LjOutMoneyPO out = new LjOutMoneyPO();
            out.setUserId(ljInMoneyBO.getUserId());
            out.setName(ljInMoneyBO.getName());
            out.setReason(ljInMoneyBO.getReturnReason());
            out.setOutMoney(ljInMoneyBO.getReturnMoney());
            out.setOutDate(ljInMoneyBO.getReturnDate());
            out.setInId(ljInMoneyPO.getInId());
            out.setNote("自动记录：收礼同时记录还礼。");
            out.setCreateDate(createDate);
            ljOutMoneyPOMapper.insert(out);
        }
        return insert;
    }
}
