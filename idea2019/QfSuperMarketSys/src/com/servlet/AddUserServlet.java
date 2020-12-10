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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 17:10
 * @Description:
 */

@WebServlet(name = "AddUserServlet",urlPatterns = "/addUserServlet")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //从前端界面获取值
        String userCode=request.getParameter("userCode");
        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        int sex=0;
        if(gender.equals("男")){
            sex=1;
        }else{
            sex=2;
        }

        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date birthdays=format.parse(request.getParameter("birthday"));
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            String userRoles=request.getParameter("userRole");
            System.out.println(userRoles);
            int userRole=0;
            if(userRoles.equals("管理员")){
                userRole=1;
            }else if(userRoles.equals("经理")){
                userRole=2;
            }else{
                userRole=3;
            }

            UserService userService=new UserServiceImpl();
            User user=new User();
            user.setUserCode(userCode);
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setAge(age);
            user.setGender(sex);
            user.setBirthday(birthdays);
            user.setPhone(phone);
            user.setAddress(address);
            user.setUserRole(userRole);
            user.setCreationDate(new Date());
            int count=userService.addUser(user);
            if(count>0){
                //新增成功
                request.getRequestDispatcher("userServlet").forward(request, response);
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
