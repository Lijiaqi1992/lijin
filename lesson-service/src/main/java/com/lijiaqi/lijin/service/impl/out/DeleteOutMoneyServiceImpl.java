package com.lijiaqi.lijin.service.impl.out;

import com.lijiaqi.lijin.api.out.bo.DeleteOutBO;
import com.lijiaqi.lijin.api.out.service.DeleteOutMoneyService;
import com.lijiaqi.lijin.dao.LjOutMoneyPOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Service
public class DeleteOutMoneyServiceImpl implements DeleteOutMoneyService {
    @Resource
    LjOutMoneyPOMapper ljOutMoneyPOMapper;
    @Override
    public Integer deleteByIds(DeleteOutBO deleteOutBO) {
        AtomicInteger atomi = new AtomicInteger();
        deleteOutBO.getIds().forEach(id ->{
            atomi.addAndGet(ljOutMoneyPOMapper.deleteByPrimaryKey(id));
        });
        return atomi.get();
    }
}
