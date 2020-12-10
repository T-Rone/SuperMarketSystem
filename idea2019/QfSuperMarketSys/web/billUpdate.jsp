<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/8
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
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
                <li id="active"><a href="billAndProviderServlet">账单管理</a></li>
                <li><a href="providerListServlet">供应商管理</a></li>
                <li><a href="userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单更新页面</span>
        </div>
        <div class="providerAdd">
            <form action="updateBill" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="bid" value="${requestScope.bill.id}">
                <input type="hidden" name="pid" value="${requestScope.provider.id}">
                <div class="">
                    <label for="billcode">订单编码：</label>
                    <input type="text" name="billcode" id="billcode" value="${requestScope.bill.billCode}" />
                    <span>*</span>
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="${requestScope.bill.productName}" />
                    <span >*</span>
                </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="${requestScope.bill.productUnit}" />
                    <span>*</span>

                </div>
                <div>
                    <label for="count">商品数量：</label>
                    <input type="text" name="count" id="count" value="${requestScope.bill.productCount}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="totalprice">总金额：</label>
                    <input type="text" name="totalprice" id="totalprice" value="${requestScope.bill.totalPrice}" placeholder="200"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="proName">供应商：</label>
                    <input type="text" name="proName" id="proName" value="${requestScope.provider.proName}"/>
                    <span>*</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input type="radio" name="zhifu" value="1" checked >未付款
                    <input type="radio" name="zhifu" value="2" >已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权--->TDRAGON
</footer>
<script src="js/time.js"></script>

</body>
</html>