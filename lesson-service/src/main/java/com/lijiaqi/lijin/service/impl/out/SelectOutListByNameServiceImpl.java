package com.lijiaqi.lijin.service.impl.out;

import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;
import com.lijiaqi.lijin.api.out.service.SelectOutListByNameService;
import com.lijiaqi.lijin.dao.LjOutMoneyPOMapper;
import com.lijiaqi.lijin.po.LjOutMoneyPO;
import com.lijiaqi.lijin.po.LjOutMoneyPOCriterion;
import com.ljq.plugins.base.exception.MyBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李佳琪
 * 2022-07-20
 */
@Service
public class SelectOutListByNameServiceImpl implements SelectOutListByNameService {
    @Resource
    LjOutMoneyPOMapper ljOutMoneyPOMapper;

    @Override
    public List<LjOutMoneyBO> getListByName(SearchOutBO searchOutBO) {
        if (searchOutBO.getUserId() <= 0) {
            throw new MyBusinessException(HttpStatus.UNAUTHORIZED.value(), "请退出小程序后重试！");
        }
        LjOutMoneyPOCriterion ljOutMoneyPOCriterion = new LjOutMoneyPOCriterion();
        LjOutMoneyPOCriterion.Criteria criteria = ljOutMoneyPOCriterion.createCriteria();

        criteria.andUserIdEqualTo(searchOutBO.getUserId());
        if (StringUtils.isNotEmpty(searchOutBO.getName())) {
            criteria.andNameEqualTo(searchOutBO.getName());
        }
        ljOutMoneyPOCriterion.setOrderByClause("create_date desc");
        List<LjOutMoneyPO> ljOutMoneyPOList = ljOutMoneyPOMapper.selectByExample(ljOutMoneyPOCriterion);
        return ljOutMoneyPOList.stream().map(po -> {
            LjOutMoneyBO bo = new LjOutMoneyBO();
            BeanUtils.copyProperties(po, bo);
            return bo;
        }).collect(Collectors.toList());
    }
}
