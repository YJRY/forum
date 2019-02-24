<%--
  Created by IntelliJ IDEA.
  User: yjry
  Date: 2019/1/2
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./allInclude.jsp"%>

<html>
<head>
    <link rel="stylesheet" href="${base}/res/css/global.css">
    <script type="text/javascript" src="${base}/js/header.js"></script>
</head>
<body>
<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="${base}/res/images/logo.png" alt="layui">
        </a>
        <ul class="layui-nav fly-nav layui-hide-xs">
            <li class="layui-nav-item layui-this">
                <a href="${base}/index"><i class="iconfont icon-jiaoliu"></i>交流</a>
            </li>
            <li class="layui-nav-item">
                <a href="${base}/case"><i class="iconfont icon-iconmingxinganli"></i>案例</a>
            </li>
            <li class="layui-nav-item">
                <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>框架</a>
            </li>
        </ul>

        <ul class="layui-nav fly-nav-user">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li class="layui-nav-item">
                        <a class="fly-nav-avatar" href="javascript:;">
                            <cite class="layui-hide-xs">${sessionScope.user.name}</cite>
                            <i class="iconfont icon-renzheng layui-hide-xs" title="经验值：${exp.exp}&nbsp;&nbsp;称号：${exp.name}"></i>
                            <i class="layui-badge fly-badge-vip layui-hide-xs">${exp.level}</i>
                            <img id="userImage" src="${sessionScope.user.image}">
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="${base}/userSet"><i class="layui-icon layui-icon-set-sm"></i>基本设置</a></dd>
                            <dd><a href="${base}/userHome?id=${sessionScope.user.id}"><i class="layui-icon layui-icon-home" style="margin-left: 2px; font-size: 22px;"></i>我的主页</a></dd>
                            <hr style="margin: 5px 0;">
                            <dd><a id="logout" style="cursor: pointer; text-align: center;">退出</a></dd>
                        </dl>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="layui-nav-item">
                        <a class="iconfont icon-touxiang layui-hide-xs" href="${base}/login"></a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${base}/login">登入</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${base}/register">注册</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <!-- 未登入的状态 -->
            <!-- 登入后的状态 -->
        </ul>
    </div>
</div>
</body>
</html>
