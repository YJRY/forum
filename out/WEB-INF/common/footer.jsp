<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="fly-footer">
  <p>
    <a href="http://fly.layui.com/" target="_blank">萌新小白社区</a>
    2018 &cpoy;
    <a href="http://www.layui.com/" target="_blank">WXW All Right Reserved</a>
  </p>
</div>

<script src="${base}/res/layui/layui.js"></script>
<script>
layui.cache.page = '';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../res/mods/'  //这里实际使用时，建议改成绝对路径
}).extend({
  fly: 'index'
}).use('fly');
</script>