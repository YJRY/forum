<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>帐号设置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${base}/res/css/global.css">
    <script type="text/javascript" src="${base}/js/userSet.js"></script>
    <link rel="stylesheet" href="${base}/css/set.css">
</head>
<body>
<div class="layui-container fly-marginTop fly-user-main">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item">
            <a href="${base}/userHome?id=${user.id}">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item layui-this">
            <a href="${base}/userSet">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
    </ul>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>
    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" id="info">我的资料</li>
                <li id="image">头像</li>
                <li id="pass">密码</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-form layui-form-pane layui-tab-item layui-show">
                    <form class="formInfo" method="post">
                        <div class="layui-form-item">
                            <label for="email" class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" id="email" name="email" lay-verify="email" autocomplete="off" value="<c:if test="${user.email != null}">${user.email}</c:if>" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                    <input type="radio" name="sex" value="male" <c:if test="${user.sex == 'male'}">checked</c:if> title="男">
                                    <input type="radio" name="sex" value="female" <c:if test="${user.sex == 'female'}">checked</c:if> title="女">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" lay-filter="*" key="set-mine" lay-submit>确认修改</button>
                        </div>
                    </form>
                </div>
                <div class="layui-form layui-form-pane layui-tab-item">
                    <div class="layui-form-item">
                        <div class="avatar-add">
                            <p>支持jpg、png、gif，最大不能超过500KB</p>
                            <button type="button" class="layui-btn upload-img" id="imageUpload">
                                <i class="layui-icon">&#xe67c;</i>上传头像
                            </button>
                            <img id="thumbnail" src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
                            <span class="loading"></span>
                            <button id="upload" class="layui-btn" style="margin: 0 auto;">上传</button>
                        </div>
                    </div>
                </div>
                <div class="layui-form layui-form-pane layui-tab-item">
                    <form action="/user/repass" method="post">
                        <div class="layui-form-item">
                            <label for="pwdNow" class="layui-form-label">当前密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="pwdNow" name="pwdNow" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="pwdNew" class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="pwdNew" name="pwdNew" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                        </div>
                        <div class="layui-form-item">
                            <label for="pwdNew_c" class="layui-form-label">确认密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="pwdNew_c" name="pwdNew_c" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认修改</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>