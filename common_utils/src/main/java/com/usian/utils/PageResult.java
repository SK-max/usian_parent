package com.usian.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author 枫柚素主
 * @version 1.0
 * @date 2020/5/17 20:42
 */
public class PageResult implements Serializable {

    private Integer pageIndex;//当前页码
    private long totalPage;//总共多少页
    private List result;//

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
