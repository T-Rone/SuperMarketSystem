package com.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 11:42
 * @Description:
 */

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    //数据提交暴露
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //从界面获取用户名和密码
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        UserService userService=new UserServiceImpl();
        User user=new User();
        user.setUserName(name);
        user.setUserPassword(password);
//        System.out.println(user.toString());
        try {
            boolean falg=userService.loginUser(user);
            if(falg){
                //session  一次会话 比request的范围大
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
                //登录成功
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }else{
                //登录失败，重新登录
//                PrintWriter writer=response.getWriter();
//                writer.write("<script type=\"text/javascript\">\n" +
//                        "    alert(\"用户名或密码错误！\");\n" +
//                        "</script>");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
