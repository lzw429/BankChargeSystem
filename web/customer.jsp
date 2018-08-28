<%@ page import="model.Bill" %>
<%@ page import="model.User" %>
<%@ page import="service.ChargeService" %>
<%@ page import="service.impl.ChargeServiceImpl" %>
<%@ page import="java.util.List" %>
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
    User user = (User) session.getAttribute("user");
    if (user == null) { // 未登录，跳转登录页
        response.sendRedirect("/login");
    }
    assert user != null;
    ChargeService chargeService = new ChargeServiceImpl();
    List<Bill> bill = chargeService.toBePaid(user.getUsername());
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
                    <span class="card-title"><%=user.getCUSTOMER_NAME()%></span>
                    <table>
                        <thead>
                        <tr>
                            <th>帐号</th>
                            <th>地址</th>
                            <th>余额</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td><%=user.getUsername()%> <!--帐号-->
                            </td>
                            <td><%=user.getADDRESS()%> <!--地址-->
                            </td>
                            <td><%=user.getBALANCE()%> <!--余额-->
                            </td>
                        </tr>
                        </tbody>
                    </table>
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
                    <table>
                        <thead>
                        <tr>
                            <th>设备号</th>
                            <th>应缴日期</th>
                            <th>已缴费用</th>
                            <th>剩余缴费</th>
                            <th>滞纳金</th>
                            <th>单月欠费金额</th>
                            <th>支付</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%if (bill == null || bill.size() == 0) {%>
                        <tr></tr>
                        <%
                        } else {
                            for (Bill aBill : bill) {
                        %>
                        <tr>
                            <td><%=aBill.getDeviceID()%>
                            </td>
                            <td><%=aBill.getPayDate()%>
                            </td>
                            <td><%=aBill.getAlreadyFee()%>
                            </td>
                            <td><%=aBill.getRemainFee()%>
                            </td>
                            <td><%=aBill.getLateFee()%>
                            </td>
                            <td><%=aBill.getArrearage()%>
                            </td>
                            <td><i id="pr_<%=aBill.getPrID()%>" class="material-icons">payment</i>
                            </td>
                        </tr>
                        <%
                                }
                            }%>
                        </tbody>
                    </table>
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
