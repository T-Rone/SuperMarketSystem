package com.servlet;

import com.pojo.Bill;
import com.service.BillAndProService;
import com.service.Impl.BillAndProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 23:04
 * @Description:
 */

@WebServlet(name = "SelectBillByIdServlet",urlPatterns = "/getBillById")
public class SelectBillByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int  id=Integer.parseInt(request.getParameter("id"));
        BillAndProService billService=new BillAndProServiceImpl();
        Bill bill = null;
        try {
            bill = billService.getBillById(id);
            if(bill!=null){
                request.setAttribute("billa",bill);
                request.getRequestDispatcher("billView.jsp").forward(request,response);
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
