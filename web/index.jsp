<%--
  Created by IntelliJ IDEA.
  User: 舒意恒
  Date: 2018/8/26
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>对账 - 智慧电网</title>
</head>
<body>
<!-- Navbar goes here -->
<jsp:include page="nav.jsp"/>
<div class="container">
    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">对账</span>
                    <input type="text" class="datepicker" style="width: 810px" placeholder="选择日期" id="date_in">
                    <input type="text" style="width: 810px" placeholder="银行" id="bank_id">
                    <button class="btn blue" onclick="reconcile_submit()" type="submit">对账</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        months_val = ['一月',
            '二月',
            '三月',
            '四月',
            '五月',
            '六月',
            '七月',
            '八月',
            '九月',
            '十月',
            '十一月',
            '十二月'];
        weekdays_val = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'];
        i18n_val = {
            cancel: '取消',
            clear: '清除',
            done: '确定',
            months: months_val,
            monthsShort: months_val,
            weekdays: weekdays_val,
            weekdaysShort: weekdays_val,
            weekdaysAbbrev: ['日', '一', '二', '三', '四', '五', '六']
        };
        options = {i18n: i18n_val, format: 'yyyymmdd'};

        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.datepicker');
            var instances = M.Datepicker.init(elems, options);
        });
    </script>

    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">总账表</span>
                    <table>
                        <thead>
                        <tr>
                            <th>对账日期</th>
                            <th>银行代码</th>
                            <th>银行交易数</th>
                            <th>银行交易总额</th>
                            <th>电网交易数</th>
                            <th>电网交易总额</th>
                            <th>状态</th>
                        </tr>
                        </thead>

                        <tbody id="general_ledger_tbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">对账异常</span>
                    <table>
                        <thead>
                        <tr>
                            <th>对账日期</th>
                            <th>银行代码</th>
                            <th>转账流水号</th>
                            <th>用户</th>
                            <th>银行交易额</th>
                            <th>电网交易额</th>
                            <th>信息</th>
                        </tr>
                        </thead>

                        <tbody id="error_detail_tbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script>
        function reconcile_submit() {
            if ($('#date_in').val() === "" || $('#bank_id').val() === "") {
                M.toast({html: '请选择日期与银行'});
                return;
            }

            $.post('/reconcile', {
                date_in: $('#date_in').val(),
                bank_id: $('#bank_id').val()
            }, function (responseText) {
                var responseObject = JSON.parse(responseText);
                console.log(responseObject);

                var errorHTML = "";
                for (var i = 0; i < responseObject.accountErrorJson.length; i++) {
                    var itemOfError = responseObject.accountErrorJson[i];
                    itemOfError.accountTime = itemOfError.accountTime.substring(0, 10);
                    errorHTML += "<tr>" +
                        "<td>" + itemOfError.accountTime + "</td>" +
                        "<td>" + itemOfError.bankID + "</td>" +
                        "<td>" + itemOfError.btID + "</td>" +
                        "<td>" + itemOfError.customerID + "</td>" +
                        "<td>" + itemOfError.bankAmount + "</td>" +
                        "<td>" + itemOfError.corpAmount + "</td>" +
                        "<td>" + itemOfError.accountInfo + "</td>" +
                        "</tr>";
                }
                $('#error_detail_tbody').html(errorHTML);

                var totalHTML = "";
                for (var i = 0; i < responseObject.accountTotalJson.length; i++) {
                    var itemOfTotal = responseObject.accountTotalJson[i];
                    itemOfTotal.accountDate = itemOfTotal.accountDate.substring(0, 10);
                    totalHTML += "<tr>" +
                        "<td>" + itemOfTotal.accountDate + "</td>" +
                        "<td>" + itemOfTotal.bankID + "</td>" +
                        "<td>" + itemOfTotal.bankCount + "</td>" +
                        "<td>" + itemOfTotal.bankAmount + "</td>" +
                        "<td>" + itemOfTotal.corpCount + "</td>" +
                        "<td>" + itemOfTotal.corpAmount + "</td>";
                    if (itemOfTotal.isSuccess === '00')
                        totalHTML += "<td><i class='material-icons'>check</i></td>";
                    else if (itemOfTotal.isSuccess === '01')
                        totalHTML += "<td><i class='material-icons'>error_outline</i></td>";
                    totalHTML += "</tr>";
                }
                $('#general_ledger_tbody').html(totalHTML);

            }).fail(function () {
                M.toast({html: '操作异常'});
            });
        }
    </script>
</div>
</body>
</html>
