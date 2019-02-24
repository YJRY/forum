$(function () {
    layui.use(["layer"], function () {
        $("#logout").click(function () {
            $.ajax({
                url: base + "/doLogout",
                dataType: "json",
                success: function (data) {
                    layer.msg(data.msg);
                    setTimeout(function () {
                        location.href = base + "/index";
                    }, 1000);
                },
                error: function () {
                    layer.alert("系统繁忙，请稍后再试");
                }
            });
        });
    });


    $("#userImage").hover(function () {
        $(".layui-nav-child").css("display", "block");
    });

    $("*").on("click", function () {
        if ("layui-nav-child" !== $(this).attr("class")) {
            $(".layui-nav-child").css("display", "none");
        }
    });
});