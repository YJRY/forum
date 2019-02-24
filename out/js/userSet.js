$(function () {
    layui.use(['form', 'layer', 'upload'], function () {
        let form = layui.form;
        let layer = layui.layer;
        let upload = layui.upload;

        let imageUpload = upload.render({
            elem: '#imageUpload',
            url: base + '/upload',
            size: 500,
            auto: false,
            bindAction: '#upload',
            choose: function (obj) {
                //将每次选择的文件追加到文件队列
                let files = obj.pushFile();
                //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                obj.preview(function(index, file, result){
                    $("#thumbnail").attr('src', result);
                    console.log(file); //得到文件对象
                    //这里还可以做一些 append 文件列表 DOM 的操作
                });
            },
            done: function (res, index, upload) {
                //res（服务端响应信息）、index（当前文件的索引）、upload（重新上传的方法，一般在文件上传失败后使用）
                layer.msg(res.msg);
                setTimeout(function () {
                    location.reload();
                }, 2000);
            },
            error: function () {
                layer.msg("系统繁忙，请稍候再试");
            }
        });

        form.on('submit(*)', function (data) {
            $.ajax({
                url: base + '/doChange',
                data: data.field,
                async: false,
                dataType: 'json',
                success: function (data) {
                    layer.msg(data.msg);
                    setTimeout(function () {
                        location.reload();
                    }, 2000);
                },
                error: function () {
                    layer.msg("系统繁忙，请稍候再试");
                }
            });
            return false;
        });
    });


    $("#info").click(function () {
        $(this).addClass("layui-this").siblings().removeClass("layui-this");
        $(".layui-tab-content>div:eq(0)").addClass("layui-show").siblings().removeClass("layui-show");
    });
    $("#image").click(function () {
        $(this).addClass("layui-this").siblings().removeClass("layui-this");
        $(".layui-tab-content>div:eq(1)").toggleClass("layui-show").siblings().removeClass("layui-show");
    });
    $("#pass").click(function () {
        $(this).addClass("layui-this").siblings().removeClass("layui-this");
        $(".layui-tab-content>div:eq(2)").toggleClass("layui-show").siblings().removeClass("layui-show");
    });
});
function RndNum(){
    var rnd="";
    for(var i=0;i<10;i++)
        rnd+=Math.floor(Math.random()*10);
    return rnd;
}