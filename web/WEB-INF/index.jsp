<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>基于 layui 的极简社区页面模版</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${base}/res/css/global.css">
    <link rel="stylesheet" href="${base}/css/index.css">
    <script type="text/javascript" src="${base}/js/index.js"></script>
</head>
<body>
<div class="fly-panel fly-column">
    <div class="layui-container">
        <ul class="layui-clear">
            <li class="layui-hide-xs layui-this"><a href="${base}/index">首页</a></li>
            <li><a href="${base}/jieIndex?type=1">java基础</a></li>
            <li><a href="${base}/jieIndex?type=2">java进阶</a></li>
            <li><a href="${base}/jieIndex?type=3">javaWeb</a></li>
            <li><a href="${base}/jieIndex?type=4">前端知识</a></li>
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block">
                <span class="fly-mid"></span>
            </li>
        </ul>
        <c:if test="${user != null}">
            <div class="fly-column-right layui-hide-xs">
                <a href="${base}/add" class="layui-btn" style="margin-top: 5px;">发表新帖</a>
            </div>
        </c:if>
    </div>
</div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel">
                <div class="fly-panel-title fly-filter">
                    <a>最热帖子</a>
                </div>
                <ul class="fly-list">
                    <c:forEach var="post" items="${hot}" varStatus="sta">
                        <li>
                            <a href="${base}/userHome" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">
                                    <c:choose>
                                        <c:when test="${post.type == 1}">
                                            java基础
                                        </c:when>
                                        <c:when test="${post.type == 2}">
                                            java进阶
                                        </c:when>
                                        <c:when test="${post.type == 3}">
                                            javaWeb
                                        </c:when>
                                        <c:when test="${post.type == 4}">
                                            前端知识
                                        </c:when>
                                    </c:choose></a>
                                <a href="${base}/detail?id=${post.id}">${post.title}</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="${base}/userHome" link>
                                    <cite>${post.user}</cite>
                                    <i class="iconfont icon-renzheng" title="经验值：${expWithHot[sta.index].exp}&nbsp;&nbsp;称号：${expWithHot[sta.index].name}"></i>
                                </a>
                                <span>${post.time}</span>
                                <span class="fly-list-nums"><i class="iconfont icon-pinglun1" title="评论"></i> 66</span>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="fly-panel" style="margin-bottom: 0;">
                <div class="fly-panel-title fly-filter">
                    <a href="" class="layui-this">最新帖子</a>
                </div>
                <ul class="fly-list">
                    <c:forEach var="post" items="${latest}" varStatus="sta">
                        <li>
                            <a href="${base}/userHome" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">
                                    <c:choose>
                                        <c:when test="${post.type == 1}">
                                            java基础
                                        </c:when>
                                        <c:when test="${post.type == 2}">
                                            java进阶
                                        </c:when>
                                        <c:when test="${post.type == 3}">
                                            javaWeb
                                        </c:when>
                                        <c:when test="${post.type == 4}">
                                            前端知识
                                        </c:when>
                                    </c:choose>
                                </a>
                                <a href="jie/detail.jsp">${post.title}</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="${base}/userHome" link>
                                    <cite>${post.user}</cite>
                                    <i class="iconfont icon-renzheng" title="经验值：${expWithLatest[sta.index].exp}&nbsp;&nbsp;称号：${expWithLatest[sta.index].name}"></i>
                                </a>
                                <span>${post.time}</span>
                                <span class="fly-list-nums">
                                    <i class="iconfont icon-pinglun1" title="评论"></i> 66
                                </span>
                            </div>
                            <div class="fly-list-badge">
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="fly-panel fly-signin">
                <div class="fly-panel-title">
                    签到
                    <i class="fly-mid"></i>
                    <a href="javascript:;" class="fly-link" id="describe">说明</a>
                    <i class="fly-mid"></i>
                </div>
                <c:choose>
                    <c:when test="${sessionScope.sign == true}">
                        <div class="fly-panel-main fly-signin-main">
                            <button class="layui-btn layui-btn-danger" style="cursor: not-allowed;background-color: #FF784E;" disabled>今日已签到</button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="fly-panel-main fly-signin-main">
                            <button id="signIn" class="layui-btn layui-btn-danger">今日签到</button>
                            <span>可获得<cite>5</cite>经验</span>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <dl class="fly-panel fly-list-one">
                <dt class="fly-panel-title">本周热议</dt>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
                <dd>
                    <a href="jie/detail.jsp">基于 layui 的极简社区页面模版</a>
                    <span><i class="iconfont icon-pinglun1"></i> 16</span>
                </dd>
            </dl>
            <div class="fly-panel">
                <div class="fly-panel-title">
                    这里可作为广告区域
                </div>
                <div class="fly-panel-main">
                    <a href="http://layim.layui.com/?from=fly" target="_blank" class="fly-zanzhu" time-limit="2017.09.25-2099.01.01" style="background-color: #5FB878;">LayIM 3.0 - layui 旗舰之作</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp" %>
</body>
</html>