package com.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.Impl.UserServiceImpl;
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
 * @Date 2020/11/28.
 * @Time 15:17
 * @Description:
 */

@WebServlet(name = "userServlet",urlPatterns = "/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 //        doPost(request,response);
//        User user=new User();
        request.setCharacterEncoding("utf-8");
        UserService userService=new UserServiceImpl();
//        当前页码
        String currPage=request.getParameter("pageNo");
        if(currPage==null){
            currPage="1";
        }
//        当前页码肯定第一页
        int pageNo=Integer.parseInt(currPage);
//          int pageNo=1;
//        System.out.println(pageNo);
        //获取用户总数量
        int totalCount;
        try {
            totalCount = userService.getTotalCount();
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
            //控制首页和尾页 我这模糊查询 目前不会有那么多重名的 写上也无所谓
            if(pageNo<1){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            List<User> list = userService.showList(pageNo, pageSize);
            if(list.size()>0){
                response.setContentType("text/html; charset=utf-8");
                request.setAttribute("page", pageSupport);
                request.setAttribute("list", list);
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
}
