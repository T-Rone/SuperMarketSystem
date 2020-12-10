package com.servlet;

import com.service.Impl.ProviderServiceImpl;
import com.service.ProviderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.interfaces.RSAKey;

/**
 * @Author tdragon.
 * @Date 2020/12/6.
 * @Time 14:44
 * @Description:
 */

@WebServlet(name = "DeleteProServlet",urlPatterns = "/deleteProvider")
public class DeleteProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=Integer.parseInt(request.getParameter("id"));
        ProviderService providerService=new ProviderServiceImpl();
        try {
            if(providerService.deleteProvider(id)>0){
                request.getRequestDispatcher("providerListServlet").forward(request, response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
