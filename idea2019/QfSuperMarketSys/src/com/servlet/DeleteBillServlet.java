package com.servlet;

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

/**
 * @Author tdragon.
 * @Date 2020/12/8.
 * @Time 18:08
 * @Description:
 */

@WebServlet(name = "DeleteBillServlet",urlPatterns = "/deleteBill")
public class DeleteBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        BillAndProService billAndProService=new BillAndProServiceImpl();
        try {
            if(billAndProService.deleteBill(id)>0){
                request.getRequestDispatcher("billAndProviderServlet").forward(request, response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
