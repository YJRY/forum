$(function () {
    layui.use(["layer"], function () {
        let layer = layui.layer;
        $("#signIn").click(function () {
            $.ajax({
                url: base + "/doExp",
                data: {
                    num: 5
                },
                dataType: "json",
                success: function (data) {
                    layer.msg(data.msg);
                    if(data.flag === 1){
                        $("#signIn").text("今日已签到")
                            .css({"background-color": "#FF784E", "cursor": "not-allowed"})
                            .attr("disabled", "disabled")
                            .next().remove();
                        setTimeout(function () {
                            location.reload();
                        }, 2000);
                    }
                },
                error: function () {
                    layer.msg("系统繁忙，请稍候再试！");
                }
            });
        });
        $("#describe").click(function () {
            layer.open({
                type: 2,
                title: "积分说明",
                content: [base + "/exp", "no"],
                area: ["300px", "500px"],
                offset: ["100px"]
            });
        });
    });


});