package com.lijiaqi.lijin.service.impl.out;

import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.service.CreateOutMoneyService;
import com.lijiaqi.lijin.dao.LjOutMoneyPOMapper;
import com.lijiaqi.lijin.po.LjOutMoneyPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Service
public class CreateOutMoneyServiceImpl implements CreateOutMoneyService {

    @Resource
    LjOutMoneyPOMapper ljOutMoneyPOMapper;

    @Override
    public int createOutMoney(LjOutMoneyBO ljOutMoneyBO) {
        LjOutMoneyPO po = new LjOutMoneyPO();
        BeanUtils.copyProperties(ljOutMoneyBO, po);
        po.setCreateDate(new Date());
        return ljOutMoneyPOMapper.insert(po);
    }
}
