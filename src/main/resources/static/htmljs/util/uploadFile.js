$(function () {
    $("#uploadClick").change(function () {
        var formData = new FormData();
        var localhostPath = getRoot();
        formData.append("file", document.getElementById("uploadClick").files[0]);
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