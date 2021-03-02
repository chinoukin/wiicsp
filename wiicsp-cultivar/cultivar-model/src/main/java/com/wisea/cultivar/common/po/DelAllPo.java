package com.wisea.cultivar.common.po;

import java.util.List;

public class DelAllPo {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DelAllPo{" +
                "ids=" + ids +
                '}';
    }
}
