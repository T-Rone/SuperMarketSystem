<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/7
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.pojo.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> <%=session.getAttribute("name")%>></span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="billAndProviderServlet">账单管理</a></li>
                <li ><a href="providerListServlet">供应商管理</a></li>
                <li><a href="userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <%
           Bill bill=(Bill)request.getAttribute("billa");
        %>
        <div class="providerView">
            <p><strong>账单编码：</strong><span><%=bill.getBillCode() %></span></p>
            <p><strong>商品名称：</strong><span><%=bill.getProductName()%></span></p>
            <p><strong>商品描述：</strong><span><%=bill.getProductDesc() %></span></p>
            <p><strong>总价格：</strong><span><%=bill.getTotalPrice() %></span></p>
            <p><strong>是否支付：</strong><span>
              <%
                  if (bill.getIsPayment() == 1) {
              %> 未付款 <%
            } else {
            %> 已付款 <%
                }
            %>
            </span></p>
            <p><strong>创建时间：</strong><span><%=bill.getCreationDate() %></span></p>
            <a onclick="history.go(-1)">返回</a>
        </div>

    </div>
</section>
<footer class="footer">
    版权归--->TDRAGON
</footer>
<script src="js/time.js"></script>
</body>
</html>