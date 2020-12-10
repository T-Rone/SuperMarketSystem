package com.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 10:56
 * @Description:
 */

@WebServlet(name = "UpdateUserPasswordServlet",urlPatterns = "/updateUserPassword")
public class UpdateUserPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            User user=new User();
            String name=request.getParameter("name");
//            String oldPassword=request.getParameter("oldPassword");
//            String newPassword=request.getParameter("newPassword");
            String password=request.getParameter("password");
            user.setUserName(name);user.setUserPassword(password);
            System.out.println(name+" "+password);
            UserService userService=new UserServiceImpl();
            userService.updatePassword(user);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);

    }
}
