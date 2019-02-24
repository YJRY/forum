<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户主页</title>
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${base}/res/css/global.css">
</head>
<body style="margin-top: 65px;">
<div class="fly-home fly-panel">
    <img src="${user.image}" alt="${user.name}">
    <i class="iconfont icon-renzheng" title="Fly社区认证"></i>
    <h1>
        ${user.name}
        <i class="iconfont icon-nan"></i>
        <i class="layui-badge fly-badge-vip">${user.level}</i>
    </h1>
    <p style="padding: 10px 0; color: #5FB878;">等级：${user.level}&nbsp;&nbsp;称号：${exp.name}</p>
    <p class="fly-home-info">
        <i class="iconfont icon-kiss" title="飞吻"></i><span style="color: #FF7200;">${user.exp} 经验值</span>
        <i class="iconfont icon-shijian"></i><span>${user.rtime} 加入</span>
    </p>
</div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6 fly-home-jie">
            <div class="fly-panel">
                <h3 class="fly-panel-title">${user.name}&nbsp;最近的发帖</h3>
                <ul class="jie-row">
                    <c:choose>
                        <c:when test="${postList != null && postList.size() != 0}">
                            <c:forEach var="post" items="${postList}">
                                <li>
                                    <a href="${base}/detail?id=${post.id}" class="jie-title"> ${post.title}</a>
                                    <i>${post.time}</i>
                                    <em class="layui-hide-xs">1136阅/27答</em>
                                </li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i style="font-size:14px;">没有发表任何帖子</i></div>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>

        <div class="layui-col-md6 fly-home-da">
            <div class="fly-panel">
                <h3 class="fly-panel-title">贤心 最近的评论</h3>
                <ul class="home-jieda">
                    <li>
                        <p>
                            <span>1分钟前</span>
                            在<a href="" target="_blank">tips能同时渲染多个吗?</a>中回答：
                        </p>
                        <div class="home-dacontent">
                            尝试给layer.photos加上这个属性试试：
                            <pre>
full: true         
</pre>
                            文档没有提及
                        </div>
                    </li>
                    <li>
                        <p>
                            <span>5分钟前</span>
                            在<a href="" target="_blank">在Fly社区用的是什么系统啊?</a>中回答：
                        </p>
                        <div class="home-dacontent">
                            Fly社区采用的是NodeJS。分享出来的只是前端模版
                        </div>
                    </li>

                    <!-- <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><span>没有回答任何问题</span></div> -->
                </ul>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>