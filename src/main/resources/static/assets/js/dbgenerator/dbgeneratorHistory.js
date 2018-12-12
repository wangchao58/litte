jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable( {
				"aoColumns": [
			      { "bSortable": false },
			      null, null,null, null, null,
				  { "bSortable": false }
				] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			});

function chk(){ 
	var obj=document.getElementsByName('tablehis'); //选择所有name="'test'"的对象，返回数组 
	var s=''; 
	for(var i=0; i<obj.length; i++){ 
		if(obj[i].checked) {
			s+=obj[i].value+','; //如果选中，将value添加到变量s中 
		}
	} 
	
	return s;
} 



$("#batchgeneratemysql").click(function() {
	var checkids = chk();
	//alert(checkids);
	var data = {
		"dbtype" : "mysql",
		"checkids":checkids
	};

	$.ajax({
		type : "POST",
		url : "/metadata/batchGenerate",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			$("#generateArea").val(message.result);
		},
		error : function(message) {
			alert("提交数据失败！");
		}
	});
}
);

$("#batchgenerateoracle").click(function() {
	var checkids = chk();
	//alert(checkids);
	var data = {
		"dbtype" : "oracle",
		"checkids":checkids
	};

	$.ajax({
		type : "POST",
		url : "/metadata/batchGenerate",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			$("#generateArea").val(message.result);
		},
		error : function(message) {
			alert("提交数据失败！");
		}
	});
}
);
$("#batchgeneratesqlserver").click(function() {
	var checkids = chk();
	//alert(checkids);
	var data = {
		"dbtype" : "sqlserver",
		"checkids":checkids
	};

	$.ajax({
		type : "POST",
		url : "/metadata/batchGenerate",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			$("#generateArea").val(message.result);
		},
		error : function(message) {
			alert("提交数据失败！");
		}
	});
}
);
$("#batchgeneratedameng").click(function() {
	var checkids = chk();
	//alert(checkids);
	var data = {
		"dbtype" : "DAMENG",
		"checkids":checkids
	};
	$.ajax({
		type : "POST",
		url : "/metadata/batchGenerate",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			$("#generateArea").val(message.result);
		},
		error : function(message) {
			alert("提交数据失败！");
		}
	});
}
);