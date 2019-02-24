let dataCount = 0;//总数据数
let showCount = 6;//每页显示条数

$(function () {
    layui.use(['laypage', 'layer'], function () {
        let laypage = layui.laypage;
        let layer = layui.layer;
        laypage.render({
            elem: 'show',
            count: dataCount,
            limit: showCount,
            jump: function (obj, first) {
                let pageNow = obj.curr;
                getData(pageNow);
            }
        });
    });
});
getData(1);
function getData(page){
    $.ajax({
        url: base + "/doPage",
        type: "post",
        data: {"pageNow": page, "showCount": showCount},
        async: false,
        dataType: "json",
        success: function (data) {
            dataCount = data.data.page.totalRowCount;
            let postData = data.data.dataList;
            let userData = data.data.userList;
            let expData = data.data.expList;
            let htmlstr = "";
            for(let i in postData){
                htmlstr += ['<li>',
                    '                            <a href="', base + '/userHome?id=' + userData[i].id , '" class="fly-avatar">',
                    '                                <img src="', userData[i].image, '"',
                    '                                     alt="', userData[i].name , '">',
                    '                            </a>',
                    '                            <h2>',
                    '                                <a href="',base + '/detail?id=' + postData[i].id , '">',postData[i].title,'</a>',
                    '                            </h2>',
                    '                            <div class="fly-list-info">',
                    '                                <a href="', base + '/userHome?id=' + userData[i].id , '" link>',
                    '                                    <cite>',postData[i].user,'</cite>',
                    '                                    <i class="iconfont icon-renzheng"',
                    '                                       title="经验值：', expData[i].exp , '&nbsp;&nbsp;称号：', expData[i].name , '"></i>',
                    '                                    <i class="layui-badge fly-badge-vip">', expData[i].level , '</i>',
                    '                                </a>',
                    '                                <span>',getDate(postData[i].time),'</span>',
                    '                                <span class="fly-list-nums">',
                    '                                    <i class="iconfont icon-pinglun1" title="评论"></i> 66',
                    '                                </span>',
                    '                            </div>',
                    '                        </li>'].join("");
            }
            $(".fly-list").html(htmlstr);
        },
        error: function () {
            layer.msg("系统繁忙，请稍候再试");
        }
    });
}
function getDate(time) {
    let date = new Date(time),
        y = date.getFullYear(),
        m = date.getMonth() + 1,
        d = date.getDate();
    return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + date.toTimeString().substr(0, 8);
}
