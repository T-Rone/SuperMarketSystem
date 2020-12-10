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
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 22:49
 * @Description:
 */

@WebServlet(name = "AddProviderServlet",urlPatterns = "/addProvider")
public class AddProviderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String proCode=request.getParameter("ProCode");
        String proName=request.getParameter("ProName");
        String proDesc=request.getParameter("ProDesc");
        String proContact=request.getParameter("ProContact");
        String proPhone=request.getParameter("ProPhone");
        String proAddress=request.getParameter("ProAddress");
        String proFax=request.getParameter("ProFax");
        Provider provider=new Provider(proCode,proName,proDesc,proContact,proPhone,proAddress,
                proFax,new Date());
        ProviderService providerService=new ProviderServiceImpl();
        int count= 0;
        try {
            count = providerService.addProvider(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count>0){
            //新增成功
            request.getRequestDispatcher("providerListServlet").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
