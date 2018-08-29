<%@ page import="model.Bill" %>
<%@ page import="model.PayLog" %>
<%@ page import="model.User" %>
<%@ page import="service.ChargeService" %>
<%@ page import="service.UserService" %>
<%@ page import="service.impl.ChargeServiceImpl" %>
<%@ page import="service.impl.UserServiceImpl" %>
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
        return;
    }
    ChargeService chargeService = new ChargeServiceImpl();
    UserService userService = new UserServiceImpl();
    List<Bill> billList = chargeService.toBePaid(user.getUsername());
    List<PayLog> payLogList = chargeService.payLogByCustomerID(user.getUsername());
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
                            <td><%=userService.balanceByCustomerID(user.getUsername())%> <!--余额-->
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
                        <%if (billList == null || billList.size() == 0) {%>
                        <tr></tr>
                        <%
                        } else {
                            for (Bill aBill : billList) {
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
                            <td><a data_pr="<%=aBill.getPrID()%>" class="payment modal-trigger" href="#pay_modal"
                                   onclick="prID=<%=aBill.getPrID()%>; document.getElementById('pay_title').innerText='支付账单 ' + prID;"><i
                                    class="material-icons">payment</i></a>
                            </td>
                        </tr>
                        <%
                                }
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- 支付-模态框 -->
    <div id="pay_modal" class="modal bottom-sheet">
        <div class="modal-content">
            <h4 id="pay_title">支付</h4>
            <form action="#">
                <div class="input-field">
                    <input id="bank_amount" type="text" class="validate">
                    <label for="bank_amount">银行卡付款</label>
                </div>
                <p>
                    <label>
                        <input name="group1" type="radio" onclick="bankID ='CMB';"/>
                        <span>中国招商银行</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input name="group1" type="radio" onclick="bankID ='CCB';"/>
                        <span>中国建设银行</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input name="group1" type="radio" onclick="bankID ='ICBC';"/>
                        <span>中国工商银行</span>
                    </label>
                </p>
                <p>
                    <label>
                        <input name="group1" type="radio" checked/>
                        <span>余额</span>
                    </label>
                </p>
            </form>
        </div>
        <div class="modal-footer">
            <a href="#!" class="modal-close waves-effect waves-green btn-flat">取消</a>
            <a href="#!" class="modal-close waves-effect waves-green btn-flat" onclick="payByPR()">确定</a>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('.modal').modal();
            prID = 0;
            payAmount = 0;
            bankID = "";
        });

        function payByPR() {
            if ($('#bank_amount').val() !== "")
                payAmount = $('#bank_amount').val();

            $.get('${pageContext.request.contextPath}/payPr', {
                prID: prID,
                payAmount: payAmount,
                bankID: bankID
            }, function (responseText) {
                M.toast({html: '支付完成'});
                location.reload();
            }).fail(function () {
                M.toast({html: '操作异常'});
            })
        }
    </script>

    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">支付记录</span>
                    <table>
                        <thead>
                        <tr>
                            <th>时间</th>
                            <th>金额</th>
                            <th>类型</th>
                            <th>银行代码</th>
                            <th>银行流水号</th>
                            <th>备注</th>
                            <th>冲正</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%if (payLogList == null || payLogList.size() == 0) {%>
                        <tr></tr>
                        <%
                        } else {
                            for (PayLog aPayLog : payLogList) {
                        %>
                        <tr>
                            <td><%=aPayLog.getPayTime()%>
                            </td>
                            <td><%=aPayLog.getPayAmount()%>
                            </td>
                            <td><% switch (aPayLog.getPayType()) {
                                case "01":
                            %>缴费<% break;
                                case "02":
                            %>冲正<% break;
                                case "03":
                            %>已冲正<% break;
                            }
                            %>
                            </td>
                            <td><%=aPayLog.getBankID()%>
                            </td>
                            <td><%=aPayLog.getBtID()%>
                            </td>
                            <td><% if (aPayLog.getNotes() == null) {%>无<%} else {%><%=aPayLog.getNotes()%><%}%>
                            </td>
                            <td><% if (aPayLog.getPayType().equals("01")) {%>
                                <a onclick=" btID=<%=aPayLog.getBtID()%>;payReverse(); " href="">
                                    <i class="material-icons">settings_backup_restore</i>
                                </a>
                                <%}%>
                            </td>
                        </tr>
                        <%
                                }
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script>
        btID = 0;

        function payReverse() {
            if (btID === 0) return;

            $.get('${pageContext.request.contextPath}/payReverse', {
                btID: btID,
                customerID: <%=user.getUsername()%>
            }, function (responseText) {
                M.toast({html: '冲正完成'});
                location.reload();
            }).fail(function () {
                M.toast({html: '操作异常'});
            })
        }
    </script>

</div>
</body>
</html>
