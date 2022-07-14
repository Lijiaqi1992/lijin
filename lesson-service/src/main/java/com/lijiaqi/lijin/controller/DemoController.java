package com.lijiaqi.lijin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lijiaqi.lijin.api.test.bo.DemoReqBO;
import com.lijiaqi.lijin.api.test.service.SelectDemoList;
import com.lijiaqi.lijin.api.test.service.TestAddApi;
import com.lijiaqi.lijin.api.test.service.TestApi;
import com.ljq.plugins.base.response.RspBO;
import com.lijiaqi.lijin.po.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    TestApi testApi;

    @Autowired
    TestAddApi testAddApi;

    @Resource
    private DataSource dataSource;

    @Autowired
    SelectDemoList selectDemoList;

    @ResponseBody
    @RequestMapping(value = "/testDataSource")
    public Object testDataSource() {
        System.out.println(dataSource);
        return "see Console";
    }

    /**
     * 测试数据库查询
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/one")
    public Object demo() {
        return testApi.test();
    }

    /**
     * 测试数据库添加
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/two")
    public Object demoadd() {
        DemoReqBO bo = new DemoReqBO();
        bo.setId(5);
        bo.setName("5");
        bo.setNode("3");
        return testAddApi.addDemo(bo);
    }

    /**
     * 测试分页
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/three")
    public Object three() {
        DemoReqBO bo = new DemoReqBO();
        bo.setPageNo(2);
        bo.setPageSize(2);
        return selectDemoList.selectDemoList(bo);
    }

    @ResponseBody
    @RequestMapping(value = "/testRetuen",produces="application/json")
    public RspBO testRetuen() {
        RspBO rb = new RspBO();
        rb.setCode("12");
        rb.setMessage("测试结果");
        return rb;
    }

    @ResponseBody
    @RequestMapping(value = "/testRetuen1" , produces = "application/json")
    public void testRetuen1(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Demo de = new Demo();
        de.setName("测试");
        try {
            response.getWriter().write(JSON.toJSONString(de));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/testRetuen2")
    public Object testRetuen2() {
        String s1 = "ok success";
        String[] s2 = new String[]{"a", "b", "c"};
        int s3 = 1252;
        return s3;
    }

    @ResponseBody
    @RequestMapping(value = "/testRetuen3")
    public Object testRetuen3() {
        System.out.println("v");
        int i = 1 / 0;
        return "d";
    }

}
