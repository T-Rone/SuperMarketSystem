package com.servlet;

import com.pojo.Provider;
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
 * @Date 2020/12/5.
 * @Time 14:18
 * @Description:
 */

@WebServlet(name = "ProviderServlet",urlPatterns = "/providerListServlet")
public class ProviderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderService providerService=new ProviderServiceImpl();
        String name=request.getParameter("providername");
        System.out.println("provider:"+name);
        //当前页码
//        Provider provider=new Provider();
//        provider.setProName(null);
        String currPage=request.getParameter("pageNo");
        if(currPage==null){
            currPage="1";
        }
        //当前页码
        int pageNo=Integer.parseInt(currPage);

        //获取用户总数量
        int totalCount;
        try {
            totalCount = providerService.getTotalCount(null);
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
            List<Provider> ls=providerService.showProvider(pageNo, pageSize);
           if(name==null){
            if(ls.size()>0){

                request.setAttribute("providername",name);
                //有数据
                request.setAttribute("page", pageSupport);
                request.setAttribute("ls", ls);
                request.getRequestDispatcher("providerList.jsp").forward(request, response);
            }
//            else {
//                request.setAttribute("providername",name);
//                request.getRequestDispatcher("selectProByNameServlet").forward(request,response);
//                System.out.println("转发成功!");
//                response.sendRedirect("selectProByNameServlet?providername=北京&pageNo=2");
//            }
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
