package com.lijiaqi.lijin.service.impl.in;

import com.lijiaqi.lijin.api.in.bo.DeleteInBO;
import com.lijiaqi.lijin.api.in.service.DeleteInMoneyService;
import com.lijiaqi.lijin.dao.LjInMoneyPOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Service
public class DeleteInMoneyServiceImpl implements DeleteInMoneyService {

    @Resource
    LjInMoneyPOMapper ljInMoneyPOMapper;

    @Override
    public Integer deleteByIds(DeleteInBO deleteInBO) {
        AtomicInteger atomi = new AtomicInteger();
        deleteInBO.getIds().forEach(id ->{
            atomi.addAndGet(ljInMoneyPOMapper.deleteByPrimaryKey(id));
        });
        return atomi.get();
    }
}
