
var urlZtreeMenu = "/tree/menuTree";//查询所有菜单

$(function(){

    $("#tree").show();
    treeClick();
});

function ajaxRequest(url) {
    var rslt;

    $.ajax({
        url : encodeURI(url),
        async : false,
        data : {"sta":"1","roleId":$("#roleId").val()},
        type : "POST",
        success : function(response) {
            rslt = response;

        }
    });

    return rslt;
}

var zNodes = "";
function treeClick() {

    var setting = {
        check: {
            enable: true,
            chkStyle: "checkbox",
            radioType: "all"
        },
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: onClick,
            onCheck: onCheck
        }
    };

    if(zNodes == "") {
        zNodes= eval("(" + ajaxRequest(urlZtreeMenu) + ")");
        var menuId = $("#menuId"),ids="";
        $.each(zNodes,function(index) {
            if(zNodes[index].checked == "true") {
                ids+= zNodes[index].id+",";
            }
        });
        if (ids.length > 0 ) ids = ids.substring(0, ids.length-1);
        menuId.attr("value", ids);
    }

    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("tree");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    function onCheck(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("tree"),
            nodes = zTree.getCheckedNodes(true),
            ids = "";
        for (var i=0, l=nodes.length; i<l; i++) {
            ids += nodes[i].id + ",";
        }
        if (ids.length > 0 ) ids = ids.substring(0, ids.length-1);
        var menuId = $("#menuId");
        menuId.attr("value", ids);
    }

    $.fn.zTree.init($("#tree"), setting, zNodes);

}
