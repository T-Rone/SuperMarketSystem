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
 * @Date 2020/11/29.
 * @Time 20:33
 * @Description:
 */

@WebServlet(name = "SelectUserByIdServlet",urlPatterns = "/getUserById")
public class SelectUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        UserService userService=new UserServiceImpl();
        User user;
        try {
            user=userService.getUserById(id);
        if(user!=null){
            request.setAttribute("user", user);
            request.getRequestDispatcher("userView.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
