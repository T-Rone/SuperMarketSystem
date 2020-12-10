package com.servlet;

import com.pojo.Bill;
import com.pojo.Provider;
import com.service.BillAndProService;
import com.service.Impl.BillAndProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 22:31
 * @Description:
 */

@WebServlet(name = "AddBillServlet",urlPatterns = "/addBill")
public class AddBillServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int providerId=Integer.parseInt(request.getParameter("providerId"));
        String billcode = request.getParameter("billId");
        String productName = request.getParameter("billName");
        String productDesc = request.getParameter("billCom");
        double productCount = Double.parseDouble( request.getParameter("billNum"));
        double totalPrice = Double.parseDouble( request.getParameter("money"));
        Long address = Long.parseLong(request.getParameter("supplier"));
        int isPayment = Integer.parseInt(request.getParameter("zhifu"));
        BillAndProService billService = new BillAndProServiceImpl();
        Bill bill = new Bill();
        Provider provider=new Provider();
        provider.setId(providerId);
        bill.setProvider(provider);
        bill.setBillCode(billcode);
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setIsPayment(isPayment);
        bill.setCreationDate(new Date());

        try {
            int count= billService.addBill(bill);
            if (count>0){
                request.getRequestDispatcher("/billAndProviderServlet").forward(request,response);
                System.out.println("订单生成成功！");
            }else {
                response.sendRedirect("billAdd.jsp");
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
