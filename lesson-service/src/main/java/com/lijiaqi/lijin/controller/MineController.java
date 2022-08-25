package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.chart.Pie;
import com.lijiaqi.lijin.api.chart.PieEC;
import com.lijiaqi.lijin.api.mine.bo.AnalysisPieBO;
import com.lijiaqi.lijin.api.mine.bo.CountBO;
import com.lijiaqi.lijin.dao.LjCommonMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李佳琪
 * 2022-07-25
 */
@RestController
@RequestMapping(value = "/my")
public class MineController extends BaseController {

    @Resource
    private LjCommonMapper ljCommonMapper;

    /**
     * 送礼收礼总数统计
     */
    @ResponseBody
    @PostMapping(value = "/statistics")
    public Object statistics() {
        Integer currentUserId = getCurrentUserId();
        Double inMoneyCount = ljCommonMapper.inMoneyCount(currentUserId);
        Double outMoneyCount = ljCommonMapper.outMoneyCount(currentUserId);
        BigDecimal bigDecimal = new BigDecimal(inMoneyCount == null ? 0D : inMoneyCount);
        BigDecimal diff = bigDecimal.subtract(new BigDecimal(outMoneyCount == null ? 0D : outMoneyCount));
        CountBO countBO = new CountBO();
        countBO.setInMoneyCount(inMoneyCount);
        countBO.setOutMoneyCount(outMoneyCount);
        countBO.setDiff(diff.doubleValue());
        return countBO;
    }

    /**
     * 收到的汇总分析
     */
    @ResponseBody
    @PostMapping(value = "/INanalysis")
    public Object INanalysis() {
        Integer currentUserId = getCurrentUserId();
        List<AnalysisPieBO> analysisPieBOS = ljCommonMapper.inMoneyGroupAnalysis(currentUserId);
        return toPieEc(analysisPieBOS);
    }

    /**
     * 送出的汇总分析
     */
    @ResponseBody
    @PostMapping(value = "/OUTanalysis")
    public Object OUTanalysis() {
        Integer currentUserId = getCurrentUserId();
        List<AnalysisPieBO> analysisPieBOS = ljCommonMapper.outMoneyGroupAnalysis(currentUserId);
        return toPieEc(analysisPieBOS);
    }

    /**
     * echarts 饼图结构
     *
     * @param analysisPieBOS
     * @return
     */
    private List<PieEC> toPieEc(List<AnalysisPieBO> analysisPieBOS) {
        List<PieEC> list = new ArrayList<>();
        analysisPieBOS.forEach(it -> {
            PieEC pieEC = new PieEC();
            pieEC.setName(it.getReason());
            pieEC.setValue(it.getMoney());
            list.add(pieEC);
        });
        return list;
    }

    /**
     * chartJS 饼图结构
     *
     * @param analysisPieBOS
     * @return
     */
    private Pie toPie(List<AnalysisPieBO> analysisPieBOS) {
        List<String> reasonList = analysisPieBOS.stream().map(AnalysisPieBO::getReason).collect(Collectors.toList());
        List<Double> moneyList = analysisPieBOS.stream().map(AnalysisPieBO::getMoney).collect(Collectors.toList());
        Pie pie = new Pie();
        pie.setLabels(reasonList);
        pie.setData(moneyList);
        return pie;
    }
}
