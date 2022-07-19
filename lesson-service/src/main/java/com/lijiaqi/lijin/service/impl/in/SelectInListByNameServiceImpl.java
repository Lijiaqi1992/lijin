package com.lijiaqi.lijin.service.impl.in;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.in.service.SelectInListByNameService;
import com.lijiaqi.lijin.dao.LjInMoneyPOMapper;
import com.lijiaqi.lijin.po.LjInMoneyPO;
import com.lijiaqi.lijin.po.LjInMoneyPOCriterion;
import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.page.RspPage;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/** 送礼页面关联来往列表
 * @author 李佳琪
 * 2022-07-19
 */
@Service
public class SelectInListByNameServiceImpl implements SelectInListByNameService {
    @Resource
    LjInMoneyPOMapper ljInMoneyPOMapper;

    @Override
    public List<LjInMoneyBO> getListByName(SearchInBO searchInBO) {
        LjInMoneyPOCriterion ljInMoneyPOCriterion = new LjInMoneyPOCriterion();
        LjInMoneyPOCriterion.Criteria criteria = ljInMoneyPOCriterion.createCriteria();
        if (searchInBO.getUserId() < 0) {
            throw new MyBusinessException(HttpStatus.UNAUTHORIZED.value(), "请退出小程序后重试！");
        }
        criteria.andUserIdEqualTo(searchInBO.getUserId());
        criteria.andNameEqualTo(searchInBO.getName());
        ljInMoneyPOCriterion.setOrderByClause("create_date");
        List<LjInMoneyPO> ljInMoneyPOList = ljInMoneyPOMapper.selectByExample(ljInMoneyPOCriterion);

        return ljInMoneyPOList.stream().map(it -> {
            LjInMoneyBO bo = new LjInMoneyBO();
            BeanUtils.copyProperties(it, bo);
            return bo;
        }).collect(Collectors.toList());
    }
}
