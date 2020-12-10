package com.servlet;

import com.pojo.Bill;
import com.pojo.Provider;
import com.service.BillAndProService;
import com.service.Impl.BillAndProServiceImpl;
import com.service.Impl.ProviderServiceImpl;
import com.service.ProviderService;
import com.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 14:35
 * @Description:
 */

@WebServlet(name = "BillAndProServlet",urlPatterns = "/billAndProviderServlet")
public class BillAndProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillAndProService billAndProService=new BillAndProServiceImpl();
        String name=request.getParameter("productName");
        System.out.println("productName: "+name);
        //当前页码
        String currPage=request.getParameter("pageNo");
        if(currPage==null){
            currPage="1";
        }
        //当前页码
        int pageNo=Integer.parseInt(currPage);

        //获取用户总数量
        int totalCount;
        try {
            totalCount = billAndProService.getTotalCount(null);
            //每页显示几条用户，页面容量
            int pageSize=4;
            //获取总页数
            PageSupport pageSupport=new PageSupport();
            //当前页
            pageSupport.setCurrentPageNo(pageNo);
            //页面容量
            pageSupport.setPageSize(pageSize);
            //用户总数量
            pageSupport.setTotalCount(totalCount);

            //总页数
            int totalPage=pageSupport.getTotalPageCount();

            //控制首页和尾页
            if(pageNo<1){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }

            List<Bill> list=billAndProService.showBillAndProvider(pageNo, pageSize);
            if(list.size()>0){
                //把数据放在作用域中
                request.setAttribute("productName",name);
                request.setAttribute("lt",list);
                request.setAttribute("page", pageSupport);
                //转发
                request.getRequestDispatcher("billList.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
