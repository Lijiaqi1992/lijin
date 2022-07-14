package com.lijiaqi.lijin.api.test.bo;

import com.ljq.plugins.base.page.RspPage;

import java.io.Serializable;

public class DemoReqBO extends RspPage implements Serializable {
    private Integer id;

    private String name;

    private String node;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }
}
