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
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 22:28
 * @Description:
 */

@WebServlet(name = "selectUserByName",urlPatterns = "/SelectUserByNameServlet")
public class SelectUserByNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user=new User();
        UserService userService=new UserServiceImpl();
        String name=request.getParameter("name");
        user.setUserName(name);
        //        当前页码肯定第一页
        int pageNo=1;
        //获取 这应该变成模糊查询的数量有多少
        int totalCount;
        try {
            totalCount = userService.getTotalCountByName(user);
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
            //控制首页和尾页
            if(pageNo<1){
                pageNo=1;
            }else if(pageNo>totalPage){
                pageNo=totalPage;
            }
            List<User> list = userService.showListByName(user,pageNo, pageSize);
            if(list.size()>0){
                request.setAttribute("page", pageSupport);
                request.setAttribute("list", list);
                //2020 12 6无意间发现bug 那里是分页啊，分的所有查询的页，所以再写一个模糊分页页面 复制这，
                //因为 userlist页面里的分页地址跳的是所有商品的分页
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            }
            else
            {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"用户名没找到啊！\")");
                out.println("</script>");
                request.getRequestDispatcher("/userServlet").forward(request, response);
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
