package com.servlet;

import com.pojo.Bill;
import com.pojo.Provider;
import com.service.BillAndProService;
import com.service.Impl.BillAndProServiceImpl;
import com.service.Impl.ProviderServiceImpl;
import com.service.ProviderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/12/8.
 * @Time 13:55
 * @Description:
 */

@WebServlet(name = "UpdateBillServlet",urlPatterns = "/updateBill")
public class UpdateBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int  bid=Integer.parseInt(request.getParameter("bid"));
        int  providerId=Integer.parseInt(request.getParameter("pid"));
        String productUnit=request.getParameter("productUnit");
        String billCode = request.getParameter("billcode");
        String productName = request.getParameter("productName");
        double productCount = Double.parseDouble(request.getParameter("count"));
        double totalPrice = Double.parseDouble(request.getParameter("totalprice"));
        int isPayment =Integer.parseInt(request.getParameter("zhifu"));
        String proName=request.getParameter("proName");
        Provider provider =new Provider();
        ProviderService providerService=new ProviderServiceImpl();
        try {
        provider.setId(providerId);
        providerService.getProviderById(providerId);
        provider.setProName(proName);
        providerService.updateProvider(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bill bill = new Bill();
        bill.setProductUnit(productUnit);
        bill.setProvider(provider);
        bill.setId(bid);
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setIsPayment(isPayment);
        bill.setCreationDate(new Date());
        BillAndProService billAndProService=new BillAndProServiceImpl();
        try {
            int count=billAndProService.updateBill(bill);
            if (count>0){
                response.setContentType("text/html; charset=utf-8");
                request.getRequestDispatcher("billAndProviderServlet").forward(request,response);
            }else {
                response.sendRedirect("billUpdate.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        BillAndProService billAndProService=new BillAndProServiceImpl();
        ProviderService providerService=new ProviderServiceImpl();
        try {
            Bill bill=billAndProService.getBillById(id);
            Provider provider=providerService.getProviderById(bill.getProvider().getId());
            if(provider != null){
                request.setAttribute("bill", bill);
                request.setAttribute("provider",provider);
                request.getRequestDispatcher("billUpdate.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
