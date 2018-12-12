$(function () {
    treeMenu();
    getSessionUser();
});

/**
 * 获取用户
 */
function getSessionUser() {
    $.ajax({
        url: '/session/loginSession',
        type: "POST",
        async: true,
        dataType: "json",
        success: function (result) {
            if (result != null) {
                $("#SessionUser").html(result.userName);
            } else {

            }
        }
    });
}

/**
 * 加载菜单
 */
function treeMenu() {
    var treeMenu = "";

    $.ajax({
        url: "/menu/menuTree",
        type: "POST",
        async: true,
        dataType: "json",
        success: function (result) {

            $.each(result, function (index, item) {
                if(item.pid == 0) {
                    treeMenu+="<li id = "+item.id+">" +
                        "<a href='#' class='dropdown-toggle'>" +
                        "<i class="+item.iconCls+"></i>" +
                        "<span class='menu-text'>"+item.text+"  </span>" +
                        "<b class='arrow icon-angle-down'></b>" +
                        "</a><ul class='submenu'>";
                }
                $.each(result, function (index, itemobj) {
                    if(item.id == itemobj.pid ) {
                        treeMenu+="<li id="+itemobj.id+">" +
                            "<a href="+itemobj.url+"?pid="+item.id+"&id="+itemobj.id+">" +
                            "<i class=\"icon-double-angle-right\"></i>" +
                            itemobj.text +
                            "</a>" +
                            "</li>";
                    }
                });
                if(item.pid == 0) {
                    treeMenu+="</ul></li>";
                }
            });
            $("#treeMenu").html(treeMenu);
        }
    });

}

// 退出系统
function logout() {
    window.location.href = '/login';
}