$(function () {
    layui.use(['form', 'layer'], function () {
        let form = layui.form;
        let layer = layui.layer;
        form.on('submit(*)', function(data){
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            $.ajax({
                url: base + '/doLogin',
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
});
