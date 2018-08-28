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
    <title>管理 - 智慧电网</title>
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
                    <form>
                        <input type="text" class="datepicker" style="width: 810px" placeholder="选择日期">
                        <button class="btn blue" type="submit">对账</button>
                    </form>
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

                </div>
            </div>
        </div>
    </div>

    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">对账异常</span>

                </div>
            </div>
        </div>
    </div>


</div>
</body>
</html>
