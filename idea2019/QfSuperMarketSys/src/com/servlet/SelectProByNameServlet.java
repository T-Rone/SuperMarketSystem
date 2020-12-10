package com.servlet;

import com.pojo.Provider;
import com.pojo.User;
import com.service.Impl.ProviderServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.ProviderService;
import com.service.UserService;
import com.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 18:56
 * @Description:
 */

@WebServlet(name = "SelectProByNameServlet",urlPatterns = "/selectProByNameServlet")
public class SelectProByNameServlet extends HttpServlet {
    ProviderService providerService=new ProviderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Provider provider=new Provider();
        String name=request.getParameter("providername");
        System.out.println(name);
        provider.setProName(name);
        //        当前页码肯定第一页  md咋写个固定值啊
//        int pageNo=1;
        String curpage=request.getParameter("pageNo");
        if(curpage==null){
            curpage="1";
        }
        int pageNo=Integer.parseInt(curpage);
        //获取 这应该变成模糊查询的数量有多少
        int totalCount;
        try {
            totalCount = providerService.getTotalCount(name);
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
            int totalPage =pageSupport.getTotalPageCount();
            System.out.println("模糊总页数"+totalPage);
            //控制首页和尾页
            if(pageNo<1){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            List<Provider> list = providerService.showProviderByName(provider,pageNo,pageSize);
            System.out.println("调用模糊查询查到list长度："+list.size());
        if(name!=null)
        {
            if(list.size()>0){
                request.setAttribute("providername",name);
                request.setAttribute("page", pageSupport);
                request.setAttribute("ls", list);
                request.getRequestDispatcher("providerList.jsp").forward(request, response);
            }
            else
            {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"没找到啊！\")");
                out.println("</script>");
//                request.getRequestDispatcher("/providerListServlet").forward(request, response);
                response.sendRedirect("providerListServlet");
            }
        }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
