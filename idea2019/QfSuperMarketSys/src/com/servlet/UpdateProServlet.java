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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 23:36
 * @Description:
 */

@WebServlet(name = "UpdateProServlet",urlPatterns = "/updatePro")
public class UpdateProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        int count= 0;
        String proCode=request.getParameter("ProCode");
        String proName=request.getParameter("ProName");
        String proDesc=request.getParameter("ProDesc");
        String proContact=request.getParameter("ProContact");
        String proPhone=request.getParameter("ProPhone");
        String proAddress=request.getParameter("ProAddress");
        String proFax=request.getParameter("ProFax");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        try {
        Date createDate=format.parse(request.getParameter("creationDate"));
        Provider provider=new Provider();
        provider.setId(id);
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setCreationDate(createDate);
        ProviderService providerService=new ProviderServiceImpl();
        count = providerService.updateProvider(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count>0){
            request.getRequestDispatcher("providerListServlet").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ProviderService providerService=new ProviderServiceImpl();
        try {
            Provider provider=providerService.getProviderById(id);
            if(provider!=null){
                request.setAttribute("provider", provider);
                request.getRequestDispatcher("providerUpdate.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
