<%--
  Created by IntelliJ IDEA.
  User: 舒意恒
  Date: 2018/8/26
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav> <!-- 顶部栏 -->
    <div class="nav-wrapper blue row" style="margin: 0">
        <!-- Logo -->
        <div class="col s3">
            <a class="brand-logo" id="logo"  href="">
                <i class="material-icons">flash_on</i>智慧电网</a>
        </div>
        <!-- 搜索框 -->
        <div class="nav-wrapper col s6" style="padding: 5px">
        </div>
        <div class="col s3">
            <a class="right" href="${pageContext.request.contextPath}/logout"> <i class="material-icons">exit_to_app</i></a>
        </div>
    </div>
</nav>
