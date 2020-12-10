<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/5
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
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
                <li><a href="billList.jsp">账单管理</a></li>
                <li id="active"><a href="providerListServlet">供应商管理</a></li>
                <li ><a href="userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="<%=request.getContextPath() %>/addProvider" method="post">
                <div class="">
                    <label for="ProCode">供应商编码：</label>
                    <input type="text" name="ProCode" id="ProCode"/>
                    <span>*请输入供应商编码，且不能重复</span>
                </div>
                <div>
                    <label for="ProName">供应商名称：</label>
                    <input type="text" name="ProName" id="ProName"/>
                    <span >*请输入供应商名称</span>
                </div>
                <div>
                    <label for="ProDesc">供应商详细描述：</label>
                    <input type="text" name="ProDesc" id="ProDesc"/>
                </div>
                <div>
                    <label for="ProContact">联系人：</label>
                    <input type="text" name="ProContact" id="ProContact"/>
                </div>
                <div>
                    <label for="ProPhone">电话号码：</label>
                    <input type="tel" name="ProPhone" id="ProPhone"/>
                    <span>*必须是数字</span>
                </div>
                <div>
                    <label for="ProAddress">供应商地址：</label>
                    <input type="text" name="ProAddress" id="ProAddress"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="ProFax">传真：</label>
                    <input type="text" name="ProFax" id="ProFax"/>
                    <span >*</span>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="ProList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <!--   <input type="button" value="返回"/> -->
                    <a href="#" onclick="history.go(-1)">返回</a>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    TDRAGON--->制作
</footer>
<script src="js/time.js"></script>
</body>
</html>