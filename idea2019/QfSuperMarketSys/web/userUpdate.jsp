<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/11/29
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
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

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.user.userName}</span> , 欢迎你！</p>
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
                <li><a href="billAndProviderServlet">账单管理</a></li>
                <li ><a href="providerListServlet">供应商管理</a></li>
                <li id="active"><a href="userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <%
                User user=(User)request.getAttribute("user");
            %>

            <form action="<%=request.getContextPath()%>/updateUserServlet" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="id" value="<%=user.getId()%>"/>

                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="韩露" value="<%=user.getUserName()%>"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <select name="gender">

                        <option value="1"
                                <%
                                    if(user.getGender()==1){
                                %>
                                selected
                                <%
                                    }
                                %>

                        >男</option>
                        <option value="2"
                                <%
                                    if(user.getGender()==2){
                                %>
                                selected
                                <%
                                    }
                                %>
                        >女</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="date" name="birthday" id="data" placeholder="2016年2月1日" value="<%=user.getBirthday()%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="userphone" placeholder="13533667897" value="<%=user.getPhone()%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="userAddress" placeholder="北京"  value="<%=user.getAddress()%>"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userRole"  value="1"
                            <%
                                if(user.getUserRole()==1){
                            %>
                           checked
                            <%
                                }
                            %>
                    />管理员

                    <input type="radio" name="userRole"  value="2"
                            <%
                                if(user.getUserRole()==2){
                            %>
                           checked
                            <%
                                }
                            %>
                    />经理
                    <input type="radio" name="userRole" value="3"
                            <%
                                if(user.getUserRole()==3){

                            %>
                           checked
                            <%
                                }
                            %>
                    />普通用户

                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.go(-1)"/>
                </div>
            </form>
        </div>
    </div>
</section>
<footer class="footer">
    版权---->>TDRAGON
</footer>
<script src="js/time.js"></script>
</body>
</html>