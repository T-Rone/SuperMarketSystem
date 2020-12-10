package com.utils;
/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 15:20
 * @Description:
 * 分页的工具类  总页数=总数量/每页显示几条
 *
 */
public class PageSupport {
    //当前页
    private int currentPageNo=1;
    //总数量
    private int totalCount=0;
    //页面容量
    private int pageSize=0;
    //总页数
    private int totalPageCount=1;
    public int getCurrentPageNo() {
        return currentPageNo;
    }

    //当前页
    public void setCurrentPageNo(int currentPageNo) {
        if(currentPageNo>0){
            this.currentPageNo = currentPageNo;
        }

    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalPageCountByRS(){
        if(this.totalCount%this.pageSize==0){
            this.totalPageCount=this.totalCount/this.pageSize;
        }else if(this.totalCount%this.pageSize!=0){
            this.totalPageCount=this.totalCount/this.pageSize+1;
        }else{
            this.totalPageCount=0;
        }
    }

    //总数量
    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            //总页数
            setTotalPageCountByRS();
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    //页面容量
    public void setPageSize(int pageSize) {
        if(pageSize>0){
            this.pageSize = pageSize;
        }

    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
