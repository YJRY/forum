$(function () {
    layui.use(['form', 'layer'], function () {
        let form = layui.form;
        let layer = layui.layer;
        form.on('submit(*)', function (data) {
            // console.log(data.field);
            $.ajax({
                url: base + '/doAdd',
                data: data.field,
                dataType: 'json',
                success: function (data) {
                    layer.msg(data.msg);
                    setTimeout(function () {
                        location.href = base + "/index";
                    }, 2000);
                },
                error: function () {
                    layer.msg("系统繁忙，请稍候再试");
                }
            });
            return false;
        });
    });


    $("#change").click(function () {
        $("#validateImage").attr("src", base + "/validate?time=" + new Date().getMilliseconds());
    });
});