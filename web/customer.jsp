<%--
  Created by IntelliJ IDEA.
  User: 舒意恒
  Date: 2018/8/26
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>欢迎使用智慧电网</title>
</head>
<%
    if (session.getAttribute("username") == null) { // 未登录，跳转登录页
        response.sendRedirect("/login");
    } else {
        // TODO 自动登录，获取用户个人信息
    }
%>
<body class="grey lighten-5">
<!-- Navbar goes here -->
<jsp:include page="nav.jsp"/>
<!-- Page Layout here -->
<div class="container">
    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">您好</span>
                    <p></p>
                </div>
                <div class="card-action">
                    <a href="#">充值</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">待支付账单</span>
                    <p></p>
                </div>
                <div class="card-action">
                    <a href="#">充值</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">支付记录</span>
                    <p></p>
                </div>
                <div class="card-action">
                    <a href="#">充值</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
