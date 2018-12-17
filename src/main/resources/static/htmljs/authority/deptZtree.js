
var urlZtreeDept = "/tree/deptZtree";//查询所有菜单

var zNodes = "";
function ajaxRequest(url) {
    var rslt;

    $.ajax({
        url : encodeURI(url),
        async : false,
        data : {"sta":"1"},
        type : "POST",
        success : function(response) {
            rslt = response;
        }
    });

    return rslt;
}

function outTree() {
    $("#tree").hide();
}

function treeClick() {

    var setting = {
        check: {
            enable: true,
            chkStyle: "radio",
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
        zNodes= eval("(" + ajaxRequest(urlZtreeDept) + ")");
    }

    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("tree");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    function onCheck(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("tree"),
            nodes = zTree.getCheckedNodes(true),
            v = "",ids = "";
        for (var i=0, l=nodes.length; i<l; i++) {
            v += nodes[i].name + ",";
            ids += nodes[i].id + ",";
        }
        if (v.length > 0 ) v = v.substring(0, v.length-1);
        if (ids.length > 0 ) ids = ids.substring(0, ids.length-1);
        var deptName = $("#deptName");
        var deptId = $("#deptId");
        deptName.attr("value", v);
        deptId.attr("value", ids);
    }

    $.fn.zTree.init($("#tree"), setting, zNodes).expandAll(true);
    $("#tree").show();
}

