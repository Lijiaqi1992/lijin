package com.lijiaqi.lijin.api.chart;

import lombok.Data;

import java.util.List;

/**
 * @author 李佳琪
 * 2022-08-09
 */
@Data
public class Pie {
    List<String> labels;
    List data;
}
