package com.lijiaqi.lijin.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.test.bo.DemoReqBO;
import com.lijiaqi.lijin.api.test.bo.DemoRspBO;
import com.lijiaqi.lijin.api.test.service.SelectDemoList;
import com.lijiaqi.lijin.api.test.service.TestAddApi;
import com.lijiaqi.lijin.api.test.service.TestApi;
import com.lijiaqi.lijin.dao.DemoMapper;
import com.ljq.plugins.base.page.RspPage;
import com.lijiaqi.lijin.po.Demo;
import com.lijiaqi.lijin.po.DemoCriterion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestApiImpl implements TestApi , TestAddApi, SelectDemoList {

    @Resource
    DemoMapper demoMapper;

    @Override
    public Object test() {
        System.out.println("ok");
        Demo demo = demoMapper.selectByPrimaryKey(1);
        return demo.getName();
    }

    @Override
    @Transactional
    public int addDemo(DemoReqBO reqBO) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(reqBO,demo);
        int i = demoMapper.insert(demo);
       // int mm = 1/0;
        Demo demo2 = new Demo();
        demo2.setId(6);
        demoMapper.insert(demo2);
        return i;
    }

    @Override
    public RspPage<DemoRspBO>  selectDemoList(DemoReqBO reqBO) {
        Page<Demo> page = PageHelper.startPage(reqBO.getPageNo(), reqBO.getPageSize());
        DemoCriterion demoCriterion = new DemoCriterion();
        //写法1 可以获取更详细的分页数据和方法
        //PageInfo<Object> page = page.doSelectPageInfo(() -> demoMapper.selectByExample(demoCriterion));
        //写法2 紧跟PageHelper.startPage()方法后即实现分页功能
        List<Demo> demos = demoMapper.selectByExample(demoCriterion);
        RspPage<DemoRspBO> rspPage = new RspPage<>();
        List<DemoRspBO> list = demos.stream().map(po -> {
            DemoRspBO rsBO = new DemoRspBO();
            BeanUtils.copyProperties(po, rsBO);
            return rsBO;
        }).collect(Collectors.toList());
        rspPage.setResult(list);
        rspPage.setPageNo(reqBO.getPageNo());
        rspPage.setTotalPages(page.getPages());
        rspPage.setTotalCount((int)page.getTotal());
        return rspPage;
    }
}
