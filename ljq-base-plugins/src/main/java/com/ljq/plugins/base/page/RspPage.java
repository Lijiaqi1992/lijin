package com.ljq.plugins.base.page;

import java.util.ArrayList;
import java.util.List;

public class RspPage<T> {
    protected int pageNo = 1;
    protected int pageSize = 20;
    protected int offset;
    protected int limit;
    protected List<T> result = new ArrayList();
    protected int totalCount;
    protected int totalPages;

    private void calcOffset() {
        this.offset = (this.pageNo - 1) * this.pageSize;
    }

    private void calcLimit() {
        this.limit = this.pageSize;
    }

    public RspPage() {
        this.calcOffset();
        this.calcLimit();
    }

    public RspPage(int pageNo, int pageSize) {
        if (0 != pageNo) {
            this.pageNo = pageNo;
        }

        if (0 != pageSize) {
            this.pageSize = pageSize;
        }

        this.calcOffset();
        this.calcLimit();
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getFirst() {
        return (this.pageNo - 1) * this.pageSize + 1;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(final List<T> result) {
        this.result = result;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = this.getTotalPages();
    }

    public int getTotalPages() {
        if (this.totalCount < 0) {
            return -1;
        } else {
            int pages = this.totalCount / this.pageSize;
            int var10000;
            if (this.totalCount % this.pageSize > 0) {
                ++pages;
                var10000 = pages;
            } else {
                var10000 = pages;
            }

            return var10000;
        }
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.calcOffset();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.calcLimit();
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String toString() {
        return "Page [pageNo=" + this.pageNo + ", pageSize=" + this.pageSize + ", offset=" + this.offset + ", limit=" + this.limit + ", result=" + this.result + ", totalCount=" + this.totalCount + ", totalPages=" + this.totalPages + "]";
    }
}
