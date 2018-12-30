
jQuery(function($) {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
        url: '/indent/listIndent',
        datatype: "json",
        mtype: "post",
        colModel:[
            {label:'id',name:'id', editable:false,hidden:true },
            {label:'订单号',name:'iCode', editable: true },
            {label:'订单价格',name:'iPrice',  editable: true},
            {label:'预定时间',name:'iTime', editable: true, formatter:formatDatebox},
            {label:'发型师',name:'userName', editable: true},
            {label:'预定人昵称',name:'realName', editable: true},
            // {label:'是否退款',name:'iRefund', editable: true, formatter:yon},
            {label:'退款金额',name:'iRefundMoney', editable: true},
            {label:'状态',name:'iCondition', editable: true, formatter:statusdd}
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
        var htmlstr ="<div class='col-xs-3'><label>";
        if(rowObject.isStatus=="1") {
            htmlstr+=
                "<input name='switch-field-1' class='ace ace-switch ace-switch-5'" +
                " onclick='openEditDiag("+rowObject.id+","+rowObject.isStatus+")' checked='checked' type='checkbox' />"
        } else {
            htmlstr+=
                "<input name='switch-field-1' class='ace ace-switch ace-switch-5'" +
                " onclick='openEditDiag("+rowObject.id+","+rowObject.isStatus+")' type='checkbox' />"
        }
        htmlstr+="<span class='lbl'></span></label></div>";
        return htmlstr;
    }

    /**
     * 操作
     * @param cellvalue
     * @param options
     * @param rowObject
     * @returns {string}
     */
    function openupd(cellvalue, options, rowObject) {
        var htmlstr = "<div class='visible-md visible-lg hidden-sm hidden-xs btn-group'>"
            + "<button class='btn btn-xs btn-info' onclick=openUpdDiag('"
            + rowObject.id
            + "')><i class='icon-edit bigger-120'></i></button></div>";
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

/**
 * 查询\刷新
 */
function selText() {
    // 使用jqgrid中的方法
    $("#grid-table").jqGrid('setGridParam',{
        postData:{
            'realName' : $("#realName").val()
        }
    }).trigger("reloadGrid"); //重新载入
}

/**
 * 删除
 */
function deletes() {
    //获取值
    var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
    var row="";
    //遍历访问这个集合
    $(ids).each(function (index, id){
        //由id获得对应数据行
        var name= jQuery('#grid-table').jqGrid('getCell',id,'id');//id是colModel中的一属性
        row += name+",";
    });
    row=row.substr(0,row.length-1);

    if(ids != null && ids != "") {
        layer.confirm('此操作不可逆,是否继续？', {
            btn: ['继续','取消'] //按钮
        }, function(){
            $.ajax({
                url: '/coupon/delCoupon',
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

/**
 * 对账
 * @param uuid
 * @param isLogin
 */
function openEditDiag() {

    $.ajax({
        url: '/indent/accountByList',
        data:{
            "startTime":$("#startTime").val(),
            "entTime":$("#entTime").val(),
            "userId":$("#userName").val(),
            "deptId":$("#deptName").val()
        },
        type: "POST",
        async: true,
        dataType: "json",
        success: function (result) {
            if(result != null) {
                if(result.weinxin != null) {
                    $("#weixin").html(result.weinxin);
                }else{
                    $("#weixin").html(0);
                }
                if(result.kaquan != null) {
                    $("#kaquan").html(result.kaquan);
                }else{
                    $("#kaquan").html(0);
                }


            }
        }
    });
}



function openUpdDiag(uuid) {
    //页面层
    var indext = layer.open({
        type: 2,
        title:'卡券编辑',
        area: ['70%', '80%'],
        fixed: false, //不固定
        maxmin: true,
        content: '/coupon/updCouponView?id='+uuid,
        btn:['确定','取消'],
        yes: function (layero, index) {
            var iframeWin = window[index.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            //调用授权提交方法
            iframeWin.mySubmit();
        } ,
    });
}

function openAddDiag() {
    //页面层
    var indext = layer.open({
        type: 2,
        title:'卡券增加',
        area: ['70%', '80%'],
        fixed: false, //不固定
        maxmin: true,
        content: '/indent/listAccountView',

        yes: function (layero, index) {
            var iframeWin = window[index.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            //调用授权提交方法
            iframeWin.mySubmit();
        } ,
    });
}

function mySubmit(){

    $.ajax({
        url: '/coupon/addCoupon',
        data:$("#aouCoupon").serialize(),
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


function formatDatebox(Value, options, rowObject){

    var time = new Date(Value);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add(m)+'-'+add(d)+' '+add(h)+':'+add(mm)+':'+add(s);

}

function add(m){return m<10?'0'+m:m };

/**
 * 是否退款
 * @param value
 * @returns {string}
 */
function yon(value) {
    var yon = '';
    if(value=='0') {
        yon ='否';
    } else {
        yon = '是';
    }
    return yon;
}

function statusdd(value) {
    var iCondition='';
    if(value=='0'){
        iCondition='未付款';
    } else if(value =='1') {
        iCondition='已付款';
    }else if(value =='2') {
        iCondition='已改签';
    }else if(value =='3') {
        iCondition='待评价';
    }else if(value =='4') {
        iCondition='已完成';
    }else if(value =='5') {
        iCondition='已退款';
    }else if(value =='6') {
        iCondition='退款中';
    }else if(value =='7') {
        iCondition='已取消';
    }else if(value =='8') {
        iCondition='已过期';
    }
    return iCondition;
}