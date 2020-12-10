<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/11/28
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.pojo.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
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
    <%
        User u=(User)session.getAttribute("user");
    %>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> <%=u.getUserName() %></span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="<%=request.getContextPath()%>/billAndProviderServlet">账单管理</a></li>
                <li><a href="<%=request.getContextPath()%>/providerListServlet">供应商管理</a></li>
                <li><a href="<%=request.getContextPath()%>/userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2><%=u.getUserName() %></h2>
            <p>欢迎来到超市账单管理系统!</p>
        </div>
    </div>
</section>
<footer class="footer">
    独家设计 ---->>来自某公司高级..工程师T-DRAGON
</footer>
<script src="js/time.js" ></script>
</body>
</html>
