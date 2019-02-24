package com.yjry.pojo;

public class Page {
    private int showCount;//单个页面显示记录行数
    private int pageNow;//当前页面数字
    private int totalRowCount;//总记录数
    private int totalPageCount;//总页面数

    public Page(int showCount, int pageNow, int totalDataCount, int totalPageCount) {
        this.showCount = showCount;
        this.pageNow = pageNow;
        this.totalRowCount = totalDataCount;
        this.totalPageCount = totalPageCount;
    }

    public Page() {
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
