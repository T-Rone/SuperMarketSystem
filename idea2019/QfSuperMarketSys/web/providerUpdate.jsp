<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/5
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pojo.Provider"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li><a href="billList.html">账单管理</a></li>
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
            <span>供应商管理页面 >> 供应商修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="updatePro" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="id" value="${requestScope.provider.id}"/>
                <div >
                    <label for="ProCode">供应商编码：</label>
                    <input type="text" name="ProCode" id="ProCode" value="${provider.proCode}"/>
                    <span>*请输入供应商编码，且不能重复</span>
                </div>
                <div>
                    <label for="ProName">供应商名称：</label>
                    <input type="text" name="ProName" id="ProName" value="${provider.proName}"/>
                    <span >*请输入供应商名称</span>
                </div>
                <div>
                    <label for="ProDesc">供应商详细描述：</label>
                    <input type="text" name="ProDesc" id="ProDesc" value="${provider.proDesc}"/>
                </div>
                <div>
                    <label for="ProContact">联系人：</label>
                    <input type="text" name="ProContact" id="ProContact" value="${provider.proContact}"/>
                </div>
                <div>
                    <label for="ProPhone">电话号码：</label>
                    <input type="tel" name="ProPhone" id="ProPhone" value="${provider.proPhone}"/>
                    <span>*必须是数字</span>
                </div>
                <div>
                    <label for="ProAddress">供应商地址：</label>
                    <input type="text" name="ProAddress" id="ProAddress" value="${provider.proAddress}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="ProFax">传真：</label>
                    <input type="text" name="ProFax" id="ProFax" value="${provider.proFax}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="creationDate">创建日期：</label>
                    <input type="date" name="creationDate" id="creationDate" value="${provider.creationDate}"/>
                    <span >*</span>
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