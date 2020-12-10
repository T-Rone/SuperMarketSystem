<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/7
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.utils.PageSupport"%>
<%@page import="com.pojo.Bill"%>
<%@page import="java.util.List"%>
<%@ page import="com.pojo.Bill" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css" />
    <link rel="stylesheet" href="css/style.css" />
    <style type="text/css">
        .pagin {
            position: relative;
            margin: 10px;
            padding: 10px;
            text-align: center;
        }

        .pagin .blue {
            color: #EB5409;
            font-style: normal;
        }

        .pagin .message span {
            margin-left: 10px;
        }

        .pagin .message:hover {
            background: #f5f5f5;
        }
    </style>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p>
            <span>下午好！</span><span style="color: #fff21b"> ${sessionScope.user.userName}</span> , 欢迎你！
        </p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2">
            <span class="span1"></span>功能列表 <span></span>
        </h2>
        <nav>
            <ul class="list">
                <li id="active"><a
                        href="<%=request.getContextPath()%>/billAndProviderServlet">账单管理</a></li>
                <li><a
                        href="<%=request.getContextPath()%>/providerListServlet">供应商管理</a></li>
                <li><a href="<%=request.getContextPath()%>/userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong> <span>账单管理页面</span>
        </div>
        <div class="search">
            <form>
                <span>商品名称：</span><input type="text" placeholder="请输入商品的名称" id="productName" name="productName"/> <span>供应商：</span>

                <select name="tigong">

                    <option value="">--请选择--</option>
                    <%
                        List<Bill> lt = (List<Bill>) request.getAttribute("lt");
                        for (Bill bill:lt){
                    %>
                    <option value=""><%=bill.getProvider().getProName()%></option>
<%--                    <option value="">邯郸市五得利面粉厂</option>--%>
                    <%
                        }
                    %>
                </select>

                <span>是否付款：</span> <select name="fukuan">
                <option value="">--请选择--</option>
                <option value="">已付款</option>
                <option value="">未付款</option>
            </select> <input type="button" value="查询"  onclick="showBillByName()" />
            </form>
            <a href="billAdd.jsp">添加订单</a>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">账单编码</th>
                <th width="20%">商品名称</th>
                <th width="10%">供应商</th>
                <th width="10%">账单金额</th>
                <th width="10%">是否付款</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>

            <%
                String productName= (String) request.getAttribute("productName");
                PageSupport pg = (PageSupport) request.getAttribute("page");
                //从后台取数据
                List<Bill> list = (List<Bill>) request.getAttribute("lt");
                for (Bill bp : list) {
            %>

            <tr>
                <td><%=bp.getBillCode()%></td>
                <td><%=bp.getProductName()%></td>
                <td><%=bp.getProvider().getProName()%></td>
                <td><%=bp.getTotalPrice()%></td>
                <td>
                    <%
                        if (bp.getIsPayment() == 1) {
                    %> 未付款 <%
                } else {
                %> 已付款 <%
                    }
                %>
                </td>
                <td><%=bp.getCreationDate()%></td>
                <td><a href="getBillById?id=<%=bp.getId()%>"><img src="images/read.png" alt="查看" title="查看" /></a>
                    <a href="updateBill?id=<%=bp.getId()%>"><img src="images/xiugai.png" alt="修改" title="修改" /></a>
                    <a href="javascript:void(0)" onclick="deleteBill('<%=bp.getId()%>')" class="removeBill">
                        <img src="images/schu.png" alt="删除" title="删除"/>
                    </a>
            </tr>
            <%
                }
            %>
        </table>
        <div class="pagin">
            <div class="message">
                <%
                    if (productName==null){
                %>
                共<i class="blue"><%=pg.getTotalCount()%></i>条记录，当前显示第&nbsp;<i
                    class="blue"><%=pg.getCurrentPageNo()%>&nbsp;</i>页
                <%
                    if (pg.getCurrentPageNo() > 1) {
                %>
                <a
                        href="<%=request.getContextPath()%>/billAndProviderServlet?pageNo=<%=pg.getCurrentPageNo() - 1%>"><span
                        class="span">上一页</span></a>
                <%
                    }

                    if (pg.getCurrentPageNo() < pg.getTotalPageCount()) {
                %>
                <a href="<%=request.getContextPath()%>/billAndProviderServlet?pageNo=<%=pg.getCurrentPageNo() + 1%>"><span>下一页</span></a>
                <input style="width: 166px" type="text" placeholder="请输入页数，别瞎输入哦！" onblur="allpage()" id="allpage" >
                <%
                    }
                %>
                <%}else{%>
                共<i class="blue"><%=pg.getTotalCount() %></i>条记录，当前显示第&nbsp;<i
                    class="blue"><%=pg.getCurrentPageNo() %>&nbsp;</i>页
                <%
                    if (pg.getCurrentPageNo() > 1) {
                %>
                <a href="<%=request.getContextPath()%>/selectBillByNameServlet?productName=${productName}&pageNo=<%=pg.getCurrentPageNo() - 1%>"><span
                        class="span">上一页</span></a>
                <%
                    }
                    if (pg.getCurrentPageNo() < pg.getTotalPageCount()) {
                %>
                <a href="<%=request.getContextPath()%>/selectBillByNameServlet?productName=${productName}&pageNo=<%=pg.getCurrentPageNo() + 1%>"><span class="span">下一页</span></a>
                <a href="<%=request.getContextPath()%>/selectBillByNameServlet?productName=${productName}&pageNo=<%=pg.getTotalPageCount()%>"><span class="span">尾页</span></a>
                <input style="width: 166px" type="text" placeholder="请输入页数，别瞎输入哦！" onblur="allpage2()" id="allpage2" >
                <%
                        }}
                %>

            </div>
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" onclick="deleteBills()" id="yes">确定</a> <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer"> 版权---->TDRAGON </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script type="text/javascript">
    function allpage() {
        let pageNo=document.getElementById("allpage").value;
        if(parseFloat(pageNo).toString()==="NaN"){
            alert("所有查询的-->别瞎搞，瞎点，输入数字！！！");
        }
        else
        {
            if (pageNo>=<%=pg.getTotalPageCount()%>)
            {
                pageNo=<%=pg.getTotalPageCount()%>;
            }
            location.href="billAndProviderServlet?pageNo="+pageNo;
        }
    }
    function  allpage2() {
        let pageNo=document.getElementById("allpage2").value;
        if(parseFloat(pageNo).toString()==="NaN"){
            alert("别瞎搞，瞎点，输入数字！！！<-模糊查询->");
        }
        else
        {
            if (pageNo>=<%=pg.getTotalPageCount()%>)
            {
                pageNo=<%=pg.getTotalPageCount()%>;
            }
            location.href="selectBillByNameServlet?productName=${productName}&pageNo="+pageNo;
        }
    }

    function deleteBill(id){
        ids=id;
        $('.zhezhao').css('display', 'block');
        $('#removeBill').fadeIn();
    }
    function deleteBills(){
        window.location.href="<%=request.getContextPath()%>/deleteBill?id="+ids;
    }

    function showBillByName() {
        const name = document.getElementById("productName").value;
        location.href="<%=request.getContextPath()%>/selectBillByNameServlet?productName="+name+"&pageNo="+1;
    }
</script>
</body>
</html>