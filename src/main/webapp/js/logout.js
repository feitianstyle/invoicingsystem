$(function () {
    $("#logout").click(function () {
        if (confirm("确定要退出系统吗？")){
            location.href="logout"
        }
    });
})