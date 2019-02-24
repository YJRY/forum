$(function () {
    let $username = $("#username");
    let $password = $("#pwd");
    let $nametip = $("#nametip");
    let $pwdtip = $("#pwdtip");
    let $password_c = $("#password_c");
    let $pwdtip_c = $("#pwdtip_c");
    let $loginbtn = $("#loginbtn");
    let reg = /^[A-Za-z0-9]{4,10}$/;//账号由字母和数字组成，长度在4-10位
    let pwdreg = /^[A-Za-z0-9]{10,16}$/;//账号由字母和数字组成，长度在10-16位
    layui.use(['form', 'laydate', 'layer'], function () {
        let form = layui.form;
        let laydate = layui.laydate;
        let layer = layui.layer;

        laydate.render({
            elem: '#birthday'
        });

        form.verify({
            username: [/^[A-Za-z0-9]{4,10}$/, '账号由数字或字母组成，长度在4-10位'],
            pwd: [/^[A-Za-z0-9]{10,16}$/, '密码由数字或字母组成，长度在10-16位'],
            pwd_c: function (value) {
                if(value !== $password_c.val() || value !== $password.val()){
                    return '两次输入不一致';
                }
            }
        });

        form.on('submit(*)', function(data){
            // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            $.ajax({
                url: base + '/doReg',
                type: 'post',
                data: data.field,
                async: false,
                dataType: 'json',
                success: function (data) {
                    layer.msg(data.msg);
                    if(data.flag === 1){
                        setTimeout(function () {
                            location.href = base + "/index";
                        }, 2000);
                    }
                },
                error: function () {
                    layer.msg("系统繁忙，请稍后再试！");
                }
            });
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
    });
    $("#change").click(function () {
        $("#validateImage").attr("src", base + "/validate?time=" + new Date().getMilliseconds());
    });

    $username.focus(function () {
        if($(this).val() === "" || !reg.test($(this).val())){
            $nametip.text("账号由数字或字母组成，长度在4-10位").css("color", "red");
        }
    });
    $password.focus(function () {
        if($(this).val() === "" || !pwdreg.test($(this).val())){
            $pwdtip.text("密码由数字或字母组成，长度在10-16位").css("color", "red");
        }
    });
    $password_c.focus(function () {
        if($(this).val() === "" || $(this).val() !== $password.val()){
            $pwdtip_c.text("两次输入不一致").css("color", "red");
        }
    });
    $username.bind("input propertychange change", function(){
        if($(this).val() !== "" && reg.test($(this).val())){
            $nametip.text("账号符合要求").css("color", "green");
        }else{
            $nametip.text("账号由数字或字母组成，长度在4-10位").css("color", "red");
        }
    });
    $password.bind("input propertychange change", function () {
        if($(this).val() !== $password_c.val()){
            $pwdtip_c.text("两次输入不一致").css("color", "red");
        }else{
            $pwdtip_c.text("密码一致").css("color", "green");
        }
        if($(this).val() !== "" && pwdreg.test($(this).val())){
            $pwdtip.text("密码符合要求").css("color", "green");
        }else{
            $pwdtip.text("密码由数字或字母组成，长度在10-16位").css("color", "red");
        }
    });
    $password_c.bind("input propertychange change", function () {
        if ($password.val() === $password_c.val()){
            $pwdtip_c.text("密码一致").css("color", "green");
        }else{
            $pwdtip_c.text("两次输入不一致").css("color", "red");
        }
    });
});
