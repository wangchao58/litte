
jQuery(function($) {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: '/menu/listMenu',
        datatype: "json",
        mtype: "post",
        colModel:[
            {label:'菜单名',name:'text', editable: true },
            {label:'地址',name:'url', editable: true },
            {label:'父ID',name:'pid',  editable: true},
            {label:'样式',name:'iconCls', editable: true },
            {label:'是否打开',name:'state', editable: true },
            {label:'操作',name:'state', editable: true ,formatter: operation}
        ],

        viewrecords : true,//定义是否要显示总记录数
        rowNum:10,//每页显示的条数
        rownumbers: true,
        rowList:[10,20,30],//用来改变显示记录数
        pager : pager_selector,//定义翻页用的导航栏
        height: 'auto',        //自动行高
        shrinkToFit:false,  //设置为true时，列数充满表格，当列数较多时，只会缩小列宽，并不会出现滚动条，需要将属性设置为false
        autoScroll: true,    //设置滚动条
        altRows: true,//设置行交替样式
        multiselect: true, //是否可以多选
        loadComplete : function() {
            var table = this;
            setTimeout(function(){
                updatePagerIcons(table);
            }, 0);
        },
        autowidth: true// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
    });

    function operation(cellvalue, options, rowObject) {
        var htmlstr = "<div class='visible-md visible-lg hidden-sm hidden-xs btn-group'>"
            + "<button class='btn btn-xs btn-info' onclick=openEditDiag("
            + rowObject.id
            + ")><i class='icon-edit bigger-120'></i></button></div>";
        return htmlstr;

    }

    function updatePagerIcons(table) {
        var replacement =
            {
                'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
                'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
                'ui-icon-seek-next' : 'icon-angle-right bigger-140',
                'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
            };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
        })
    }
});

function refresh() {
    $("#grid-table").trigger("reloadGrid");
}

function selText() {
    // 首先获取查询条件中的值
   /* var theNumber = $("input[name='theNumber']").val();
    var theId = $("input[name='theId']").val();*/
// 使用jqgrid中的方法
    $("#grid-table").jqGrid('setGridParam',{
        postData:{
            'text' : $("#nav-search-input").val()
        }
    }).trigger("reloadGrid"); //重新载入
    
}

function deletes() {
    //询问框
    var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
    var row="";
    //遍历访问这个集合
    $(ids).each(function (index, id){
        //由id获得对应数据行
        row += id+",";
    });
    row=row.substr(0,row.length-1);

    if(ids != null && ids != "") {
        layer.confirm('此操作不可逆,是否继续？', {
            btn: ['继续','取消'] //按钮
        }, function(){
            $.ajax({
                url: '/menu/delTmenu',
                data: {'ids':row},
                type: "POST",
                success: function (result) {
                    if (result >= "1") {
                        layer.msg('操作成功', {icon: 1});
                        selText();
                    } else {
                        layer.alert('操作失败', {icon: 1});
                    }
                }
            });

        });
    } else {
        layer.msg("请选择要操作的数据!");
    }



}