package com.sc.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/6/5 14:54
 */
public class PageBean<T> {
    public static final Integer pageCount = 10;//每页的数量
    private Integer currentPage;//当前页
    private Integer totalPage;//总页数
    private Integer totalCount;//总数
//    private Integer pageCount = 10;//每页的数量
    private Integer start = 0;//开始位置
    private Integer end = 0;//结束位置
    private List<T> list = new ArrayList<>();

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalCount % pageCount == 0 ? totalCount / pageCount
                : (totalCount / pageCount)+1 ;
    }

    public static Integer getTotalPage(Integer totalNum){
        return totalNum % pageCount == 0 ? totalNum / pageCount
                : (totalNum / pageCount)+1;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getStart() {
        return (currentPage-1)*pageCount+1;
    }

    public Integer getEnd() {
        return currentPage*pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageCount=" + pageCount +
                ", list=" + list +
                '}';
    }
}
