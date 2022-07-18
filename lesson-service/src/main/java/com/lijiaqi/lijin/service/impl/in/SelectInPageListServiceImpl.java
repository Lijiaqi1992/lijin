package com.lijiaqi.lijin.service.impl.in;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.in.service.SelectInPageListService;
import com.lijiaqi.lijin.dao.LjInMoneyPOMapper;
import com.lijiaqi.lijin.po.LjInMoneyPO;
import com.lijiaqi.lijin.po.LjInMoneyPOCriterion;
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
public class SelectInPageListServiceImpl implements SelectInPageListService {

    @Resource
    LjInMoneyPOMapper ljInMoneyPOMapper;

    @Override
    public RspPage<LjInMoneyBO> getInPageList(SearchInBO searchInBO) {
        LjInMoneyPOCriterion ljInMoneyPOCriterion = new LjInMoneyPOCriterion();
        LjInMoneyPOCriterion.Criteria criteria = ljInMoneyPOCriterion.createCriteria();
        if (searchInBO.getUserId() > 0) {
            criteria.andUserIdEqualTo(searchInBO.getUserId());
        }
        if (StringUtils.isNotEmpty(searchInBO.getName())) {
            criteria.andNameEqualTo(searchInBO.getName());
        }
        ljInMoneyPOCriterion.setOrderByClause("create_date desc");
        Page<SearchInBO> page = PageHelper.startPage(searchInBO.getPageNo(), searchInBO.getPageSize());
        List<LjInMoneyPO> ljInMoneyPOList = ljInMoneyPOMapper.selectByExample(ljInMoneyPOCriterion);

        List<LjInMoneyBO> inMoneyBOList = ljInMoneyPOList.stream().map(it -> {
            LjInMoneyBO bo = new LjInMoneyBO();
            BeanUtils.copyProperties(it, bo);
            return bo;
        }).collect(Collectors.toList());

        RspPage<LjInMoneyBO> rspPage = new RspPage<>();
        rspPage.setResult(inMoneyBOList);
        rspPage.setPageNo(searchInBO.getPageNo());
        rspPage.setTotalPages(page.getPages());
        rspPage.setTotalCount((int) page.getTotal());
        return rspPage;
    }
}
