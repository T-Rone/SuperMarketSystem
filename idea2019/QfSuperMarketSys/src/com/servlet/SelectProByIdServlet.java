package com.servlet;

import com.pojo.Provider;
import com.service.Impl.ProviderServiceImpl;
import com.service.ProviderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 15:18
 * @Description:
 */

@WebServlet(name = "SelectProByIdServlet",urlPatterns = "/getProviderById")
public class SelectProByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ProviderService providerService=new ProviderServiceImpl();
        try {
            Provider provider=providerService.getProviderById(id);
            if(provider!=null){
                request.setAttribute("provider", provider);
                request.getRequestDispatcher("providerView.jsp").forward(request, response);
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
