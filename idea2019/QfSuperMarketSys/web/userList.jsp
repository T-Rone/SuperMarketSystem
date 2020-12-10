<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/11/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.utils.PageSupport"%>
<%@page import="com.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style type="text/css">
        .pagin{
            position:relative;
            margin:10px;
            padding:10px;
            text-align: center;
        }
        .pagin .blue{color:#EB5409;font-style:normal;}
        .pagin .message span{
            margin-left: 10px;
        }
        .pagin .message:hover{background:#f5f5f5;}
    </style>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <%
            User u=(User)session.getAttribute("user");
        %>
        <p><span>下午好！</span><span style="color: #fff21b"><%=u.getUserName() %></span>, 欢迎你！</p>
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
                <li><a href="<%=request.getContextPath()%>/billAndProviderServlet">账单管理</a></li>
                <li><a href="<%=request.getContextPath()%>/providerListServlet">供应商管理</a></li>
                <li  id="active"><a href="<%=request.getContextPath()%>/userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <form>
<%--                value="<%=(String)request.getAttribute("name") %>"--%>
                <span>用户名：</span><input type="text" placeholder="请输入用户名" id="username" name="name" />
                <input type="button" value="查询" onclick="showList()"/>
            </form>
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>

            <%
                PageSupport pg=(PageSupport)request.getAttribute("page");
                List<User> list= (List<User>) request.getAttribute("list");
                for(User user:list){
            %>
            <tr>
                <td><%=user.getUserCode() %></td>
                <td><%=user.getUserName() %></td>
                <td><%
                    if(user.getGender()==1){
                %>
                    男
                    <%
                    }else{
                    %>
                    女
                    <%
                        }

                    %></td>
                <td><%=user.getAge() %></td>
                <td><%=user.getPhone() %></td>
                <td><%
                    if(user.getUserRole()==1){
                %>
                    管理员
                    <%
                    }else if(user.getUserRole()==2){
                    %>
                    经理
                    <%
                    }else{
                    %>
                    普通用户
                    <%
                        }
                    %></td>
                <td>
                    <a href="getUserById?id=<%=user.getId()%>"><img src="images/read.png" alt="查看" title="查看"/></a>
                    <a href="<%=request.getContextPath()%>/updateUserServlet?id=<%=user.getId()%>"><img src="images/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="javascript:void(0)" class="removeUser" onclick="deleteUser('<%=user.getId()%>')"><img src="images/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
        <div class="pagin">
            <div class="message">
                共<i class="blue"><%=pg.getTotalCount()%></i>条记录，当前显示第&nbsp;<i
                    class="blue"><%=pg.getCurrentPageNo()%>&nbsp;</i>页
                <%
                    if (pg.getCurrentPageNo() > 1) {
                %>
<%--                &name=<%=(String)request.getAttribute("name")%>--%>
                <a href="<%=request.getContextPath()%>/userServlet?pageNo=<%=pg.getCurrentPageNo() - 1%>"><span
                        class="span">上一页</span></a>
                <%
                    }

                    if (pg.getCurrentPageNo() < pg.getTotalPageCount()) {
                %>
                <a href="<%=request.getContextPath()%>/userServlet?pageNo=<%=pg.getCurrentPageNo() + 1%>"><span>下一页</span></a>
                <%
                    }
                %>
            </div>
        </div>
    </div>

</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="javascript:void(0)" id="yes" onclick="deleteUsers()">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
<%--    版权归@武汉外语外事学院18级JAVA5班--%>
    ---行了行了什么破版权！--TDRAGON
</footer>
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script type="text/javascript">
    var ids;
    function showList(){
        //alert("aa");
        var name=document.getElementById("username").value;
        location.href="<%=request.getContextPath()%>/SelectUserByNameServlet?name="+name;
    }

    function deleteUser(id){
        ids=id;
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
    }
    function deleteUsers(){
        window.location.href="<%=request.getContextPath()%>/deleteUserServlet?id="+ids;
    }
</script>
</body>
</html>