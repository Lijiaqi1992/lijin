package com.lijiaqi.lijin.api.out.bo;

import lombok.Data;

import java.util.List;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Data
public class DeleteOutBO {
    private Integer userId;

    private List<Integer> ids;
}
