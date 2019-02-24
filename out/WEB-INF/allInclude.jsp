<%--
  Created by IntelliJ IDEA.
  User: yjry
  Date: 2018/12/27
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%--公共包含页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base">${pageContext.request.contextPath}</c:set>
<%
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
%>
<link rel="stylesheet" href="${base}/layui/css/layui.css">
<script type="text/javascript" src="${base}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${base}/layui/layui.js"></script>
<script type="text/javascript">
    let base = "${base}";
</script>
