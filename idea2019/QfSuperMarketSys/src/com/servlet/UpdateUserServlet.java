package com.servlet;

import com.pojo.User;
import com.service.UserService;
import com.service.Impl.UserServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/11/29.
 * @Time 20:58
 * @Description:
 */

@WebServlet(name = "UpdateUserServlet",urlPatterns = "/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String userName=request.getParameter("userName");
        int gender=Integer.parseInt(request.getParameter("gender"));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date birthday= format.parse(request.getParameter("birthday"));
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            int userRole=Integer.parseInt(request.getParameter("userRole"));
            int id=Integer.parseInt(request.getParameter("id"));
            UserService userService=new UserServiceImpl();
            User user=new User();
            user.setUserName(userName);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setPhone(phone);
            user.setAddress(address);
            user.setUserRole(userRole);
            user.setId(id);
            int count=userService.updateUser(user);
            if(count>0){
                //修改成功
                response.setContentType("text/html; charset=utf-8");
                request.getRequestDispatcher("userServlet").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        UserService userService=new UserServiceImpl();
        User user;
        try {
            user=userService.getUserById(id);
            if(user!=null){
                request.setAttribute("user", user);
                request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
