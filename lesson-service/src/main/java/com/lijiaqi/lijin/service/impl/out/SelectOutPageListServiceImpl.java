package com.lijiaqi.lijin.service.impl.out;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;
import com.lijiaqi.lijin.api.out.service.SelectOutPageListService;
import com.lijiaqi.lijin.dao.LjOutMoneyPOMapper;
import com.lijiaqi.lijin.po.LjOutMoneyPO;
import com.lijiaqi.lijin.po.LjOutMoneyPOCriterion;
import com.ljq.plugins.base.page.RspPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Service
public class SelectOutPageListServiceImpl implements SelectOutPageListService {
    @Resource
    LjOutMoneyPOMapper ljOutMoneyPOMapper;

    @Override
    public RspPage<LjOutMoneyBO> getOutPageList(SearchOutBO searchOutBO) {
        LjOutMoneyPOCriterion ljOutMoneyPOCriterion = new LjOutMoneyPOCriterion();
        LjOutMoneyPOCriterion.Criteria criteria = ljOutMoneyPOCriterion.createCriteria();
        if (searchOutBO.getUserId() > 0) {
            criteria.andUserIdEqualTo(searchOutBO.getUserId());
        }
        if (StringUtils.isNotEmpty(searchOutBO.getName())) {
            criteria.andNameEqualTo(searchOutBO.getName());
        }
        ljOutMoneyPOCriterion.setOrderByClause("create_date desc");
        Page<SearchOutBO> page = PageHelper.startPage(searchOutBO.getPageNo(), searchOutBO.getPageSize());
        List<LjOutMoneyPO> ljOutMoneyPOList = ljOutMoneyPOMapper.selectByExample(ljOutMoneyPOCriterion);

        List<LjOutMoneyBO> ljOutMoneyBOList = ljOutMoneyPOList.stream().map(it -> {
            LjOutMoneyBO bo = new LjOutMoneyBO();
            BeanUtils.copyProperties(it, bo);
            return bo;
        }).collect(Collectors.toList());

        RspPage<LjOutMoneyBO> rspPage = new RspPage<>();
        rspPage.setResult(ljOutMoneyBOList);
        rspPage.setPageNo(searchOutBO.getPageNo());
        rspPage.setTotalPages(page.getPages());
        rspPage.setTotalCount((int) page.getTotal());
        return rspPage;
    }
}
