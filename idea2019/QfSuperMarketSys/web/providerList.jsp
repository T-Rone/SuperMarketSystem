<%--
  Created by IntelliJ IDEA.
  User: tdragon
  Date: 2020/12/5
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.pojo.Provider"%>
<%@page import="com.utils.PageSupport"%>
<%@page import="com.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
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
                <li><a href="<%=request.getContextPath()%>/billAndProviderServlet">账单管理</a></li>
                <li id="active"><a href="<%=request.getContextPath()%>/providerListServlet">供应商管理</a></li>
                <li><a href="<%=request.getContextPath()%>/userServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <form >
                <span>供应商名称：</span>
                <input type="text" placeholder="请输入供应商的名称" name="providername" id="providername"/>
                <input type="button" value="查询" onclick="showProList()"/>
            </form>
            <a href="providerAdd.jsp">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <%
                String providername= (String) request.getAttribute("providername");
                PageSupport pg=(PageSupport)request.getAttribute("page");
                List<Provider> ls=(List<Provider>)request.getAttribute("ls");
                for(Provider provider:ls)
                {
            %>
            <tr>
                <td><%=provider.getProCode() %></td>
                <td><%=provider.getProName() %></td>
                <td><%=provider.getProContact() %></td>
                <td><%=provider.getProPhone() %></td>
                <td><%=provider.getProFax() %></td>
                <td><%=provider.getCreationDate() %></td>
                <td>
                    <a href="<%=request.getContextPath()%>/getProviderById?id=<%=provider.getId()%>"><img src="images/read.png" alt="查看" title="查看"/></a>
                    <a href="updatePro?id=<%=provider.getId()%>"><img src="images/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="javascript:void(0)" onclick="deleteProvider('<%=provider.getId()%>')" class="removeProvider">
                        <img src="images/schu.png" alt="删除" title="删除"/>
                    </a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
        <div class="pagin">
            <div class="message">
                <%
                    if (providername==null){
                %>
                共<i class="blue"><%=pg.getTotalCount() %></i>条记录，当前显示第&nbsp;<i
                    class="blue"><%=pg.getCurrentPageNo() %>&nbsp;</i>页
                <a href="<%=request.getContextPath()%>/providerListServlet?pageNo=3"><span
                        class="span">第三页</span></a>
                <%
                    if (pg.getCurrentPageNo() > 1) {
                %>
                <a href="<%=request.getContextPath()%>/providerListServlet?pageNo=<%=pg.getCurrentPageNo() - 1%>"><span
                        class="span">上一页</span></a>
                <%
                    }
                    if (pg.getCurrentPageNo() < pg.getTotalPageCount()) {
                %>
                <a href="<%=request.getContextPath()%>/providerListServlet?pageNo=<%=pg.getCurrentPageNo() + 1%>"><span class="span">下一页</span></a>
                <a href="<%=request.getContextPath()%>/providerListServlet?pageNo=<%=pg.getTotalPageCount()%>"><span class="span">尾页</span></a>
                <input style="width: 166px" type="text" placeholder="请输入页数，别瞎输入哦！" onblur="allpage1()" id="allpage1" >
                <%
                    }
                %>
                <%}else{%>
               共<i class="blue"><%=pg.getTotalCount() %></i>条记录，当前显示第&nbsp;<i
                    class="blue"><%=pg.getCurrentPageNo() %>&nbsp;</i>页
                <a href="<%=request.getContextPath()%>/selectProByNameServlet?providername=${providername}&pageNo=3"><span
                        class="span">第三页</span></a>
                <%
                    if (pg.getCurrentPageNo() > 1) {
                %>
                <a href="<%=request.getContextPath()%>/selectProByNameServlet?providername=${providername}&pageNo=<%=pg.getCurrentPageNo() - 1%>"><span
                        class="span">上一页</span></a>
                <%
                    }
                    if (pg.getCurrentPageNo() < pg.getTotalPageCount()) {
                %>
                <a href="<%=request.getContextPath()%>/selectProByNameServlet?providername=${providername}&pageNo=<%=pg.getCurrentPageNo() + 1%>"><span class="span">下一页</span></a>
                <a href="<%=request.getContextPath()%>/selectProByNameServlet?providername=${providername}&pageNo=<%=pg.getTotalPageCount()%>"><span class="span">尾页</span></a>
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
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain" >
            <p>你确定要删除该供应商吗？</p>
            <a href="#" onclick="deleteProvides()" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>


<footer class="footer">
    版权归---->TDRAGON
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script type="text/javascript">
    let ids;
    function allpage1() {
        let pageNo=document.getElementById("allpage1").value;
        if(parseFloat(pageNo).toString()==="NaN"){
            alert("所有查询的-->别瞎搞，瞎点，输入数字！！！");
        }
        else
        {
            if (pageNo>=<%=pg.getTotalPageCount()%>)
            {
                pageNo=<%=pg.getTotalPageCount()%>;
            }
            location.href="providerListServlet?pageNo="+pageNo;
        }
    }
    function allpage2() {
        // let providername=document.getElementById("providername").value;
        //这样要输入两个值才任意页查询 当我查询查了第一次时 把名字存起来，再用 不就好了
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
            location.href="selectProByNameServlet?providername=${providername}&pageNo="+pageNo;
        }
    }
    function showProList() {
        const name = document.getElementById("providername").value;
        location.href="<%=request.getContextPath()%>/selectProByNameServlet?providername="+name+"&pageNo="+1;
    }
    function deleteProvider(id){
        ids=id;
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
    }
    function deleteProvides(){
        window.location.href="<%=request.getContextPath()%>/deleteProvider?id="+ids;
    }

</script>

</body>
</html>