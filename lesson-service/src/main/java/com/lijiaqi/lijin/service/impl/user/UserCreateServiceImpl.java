package com.lijiaqi.lijin.service.impl.user;

import com.lijiaqi.lijin.api.users.bo.LjUserBO;
import com.lijiaqi.lijin.api.users.service.UserCreateService;
import com.lijiaqi.lijin.dao.LjUserPOMapper;
import com.lijiaqi.lijin.po.LjUserPO;
import com.lijiaqi.lijin.po.LjUserPOCriterion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李佳琪
 * 2022-07-15
 */
@Service
public class UserCreateServiceImpl implements UserCreateService {
    @Resource
    LjUserPOMapper ljUserPOMapper;
    @Override
    public LjUserBO createUser(LjUserBO userBO) {
        LjUserPO userPO = new LjUserPO();
        BeanUtils.copyProperties(userBO, userPO);
        userPO.setCreateDate(new Date());
        userPO.setLastLoginDate(new Date());
        ljUserPOMapper.insert(userPO);
        LjUserBO bo = new LjUserBO();
        BeanUtils.copyProperties(userPO, bo);
        return bo;
    }

    @Override
    public LjUserBO createUserIfNotExistsInWx(LjUserBO userBO) {
        LjUserPOCriterion ljUserPOCriterion = new LjUserPOCriterion();
        LjUserPOCriterion.Criteria criteria = ljUserPOCriterion.createCriteria();
        criteria.andOpenidEqualTo(userBO.getOpenid());
        List<LjUserPO> ljUserPOS = ljUserPOMapper.selectByExample(ljUserPOCriterion);
        if(ljUserPOS.size() == 0){
            return createUser(userBO);
        }
        BeanUtils.copyProperties(ljUserPOS.get(0), userBO);
        return userBO;
    }
}
