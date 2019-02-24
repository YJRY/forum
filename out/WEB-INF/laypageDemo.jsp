<%--
  Created by IntelliJ IDEA.
  User: yjry
  Date: 2018/12/23
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base">${pageContext.request.contextPath}</c:set><%--这是jstl赋值的另一种写法--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
    <table class="layui-table">

    </table>
    <div id="show"></div>
    <script type="text/javascript">
        layui.use(['laypage'], function () {
            let laypage = layui.laypage;
            laypage.render({
                elem: 'show',
                count: 50,
                jump: function (obj, first) {
                    let pageNow = obj.curr;
                    $.ajax({
                        url:"${base}/pageDemo2",
                        data: {'pageNow': pageNow},
                        type: 'post',
                        dataType: 'json',
                        async:false,
                        success: function (data) {
                            
                        }
                    });
                }
            });
        });
    </script>
</body>
</html>
