<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="${base}/res/css/global.css">
    <link rel="stylesheet" href="${base}/css/login.css">
    <script type="text/javascript" src="${base}/js/register.js"></script>
</head>
<body>
<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li><a href="${base}/login">登入</a></li>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post">
              <div class="layui-form-item">
                <label for="username" class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required lay-verify="required|username" autocomplete="off" class="layui-input" placeholder="username">
                </div>
                <span id="nametip"></span>
              </div>
              <div class="layui-form-item">
                <label for="pwd" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="pwd" name="pwd" required lay-verify="required|pwd|pwd_c" autocomplete="off" class="layui-input" placeholder="password">
                </div>
                <span id="pwdtip"></span>
              </div>
              <div class="layui-form-item">
                <label for="password_c" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="password_c" name="repass" required lay-verify="required|pwd_c" autocomplete="off" class="layui-input" placeholder="password">
                </div>
                <span id="pwdtip_c"></span>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">验证码</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请输入验证码(忽略大小写)" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid">
                  <img  id="validateImage" src="${base}/validate" style="position: absolute; top: 2px;" alt="替代文字">
                  <a id="change">看不清？</a>
                </div>
              </div>
              <div class="layui-form-item">
                <button id="loginbtn" class="layui-btn" lay-filter="*" lay-submit>立即注册</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>
<%@ include file="../footer.jsp"%>

</body>
</html>