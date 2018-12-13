$(function () {
    $("#uploadTrecruClick").change(function () {
        var formData = new FormData();
        var localhostPath = getRoot();
        formData.append("file", document.getElementById("uploadTrecruClick").files[0]);
        $.ajax({
            url: localhostPath + "/file/uploadFile",
            type: "POST",
            data: formData,
            dataType: "json",
            contentType: false,
            processData: false,
            success: function (data) {
                $("#headPortrait").val(data.fileName);
                $("#previewImg").attr('src', localhostPath + "/file/download?fileName=" + data.fileName);
                // 修改图片提交
                updTrecruitInfo();
            },
            error: function () {
                alert("上传失败！");
            }
        });
    });

    function getRoot() {
        var curWwwPath = window.document.location.href;
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        var localhostPath = curWwwPath.substring(0, pos);
        return localhostPath;
    }

});

/**
 * 招聘信息修改
 */
function updTrecruitInfo(){
    $.ajax({
        url: '/trecruitInfo/updTrecruitInfo',
        data:$("#updateTreInf").serialize(),
        type: "POST",
        async: true,
        dataType: "json",
        success: function (result) {
            if (result == "1") {
                layer.alert('操作成功！',function () {
                    parent.location.reload(); // 父页面刷新
                });
            } else {
                layer.msg('对不起，操作失败！');
            }
        }
    });
}