<%--
  Created by IntelliJ IDEA.
  User: 舒意恒
  Date: 2018/8/29
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>抄表 - 智慧电网</title>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 25px;">
        <div class="col" style="width: 955px;">
            <div class="card white">
                <div class="card-content black-text">
                    <span class="card-title">抄表</span>
                    <!--抄表需要的参数：抄表日期，设备编号，用户编号，抄表读数，抄表员编号-->
                    <div class="input-field">
                        <input type="text" class="datepicker" style="width: 810px" id="date_in">
                        <label for="date_in">选择日期</label>
                    </div>
                    <div class="input-field">
                        <input type="text" style="width: 810px" id="device_id" value="2000">
                        <label for="device_id">设备编号</label>
                    </div>
                    <div class="input-field">
                        <input type="text" style="width: 810px" id="customer_id" value="1000">
                        <label for="customer_id">用户编号</label>
                    </div>
                    <div class="input-field">
                        <input type="text" style="width: 810px" id="meter_read">
                        <label for="meter_read">抄表读数</label>
                    </div>
                    <div class="input-field">
                        <input type="text" style="width: 810px" id="mr_id" value="1">
                        <label for="mr_id">抄表员编号</label>
                    </div>
                    <button class="btn blue" onclick="meter_read_submit();">提交</button>
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

        function meter_read_submit() {
            if ($('#date_in').val() === "" || $('#device_id').val() === "" || $('#customer_id').val() === "" || $('#meter_read').val() === "" || $('#mr_id').val() === "") {
                M.toast({html: '请填写抄表信息'});
            }

            $.get('${pageContext.request.contextPath}/meterRead', {
                mrDate: $('#date_in').val(),
                deviceID: $('#device_id').val(),
                customerID: $('#customer_id').val(),
                mtNumber: $('#meter_read').val(),
                mrID: $('#mr_id').val()
            }, function (responseText) {
                M.toast({html: '抄表完成'});
                location.reload();
            }).fail(function () {
                M.toast({html: '操作异常'});
            })
        }
    </script>

</div>
</body>
</html>
