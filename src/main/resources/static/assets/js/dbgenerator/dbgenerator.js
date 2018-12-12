$(function() {

	$("#dbgenerateform")
			.validate(
					{
						errorElement : 'div',
						errorClass : 'help-block',
						focusInvalid : false,
						rules : {
							tableName : {
								required : true
							},
							tableCode : {
								required : true
							},
							tableCols : {
								required : true
							}

						},
						messages : {
							tableName : {
								required : "请输入表名"
							},
							tableCode : {
								required : "请输入表名编码"
							},
							tableCols : {
								required : "请输入字段"
							},
						},
						errorPlacement : function(error, element) {

							if (element.is(':checkbox') || element.is(':radio')) {
								var controls = element
										.closest('div[class*="col-"]');
								if (controls.find(':checkbox,:radio').length > 1)
									controls.append(error);
								else
									error.insertAfter(element.nextAll(
											'.lbl:eq(0)').eq(0));
							} else if (element.is('.select2')) {
								error
										.insertAfter(element
												.siblings('[class*="select2-container"]:eq(0)'));
							} else if (element.is('.chosen-select')) {
								error
										.insertAfter(element
												.siblings('[class*="chosen-container"]:eq(0)'));
							} else
								error.insertAfter(element.parent());
						},

						submitHandler : function(form) {
							// /form.submit();
							ajaxSubmitFrom();

						},
						invalidHandler : function(form) {
						}
					});

});

function ajaxSubmitFrom() {
	var tableName = $("#tableName").val();
	var tableCode = $("#tableCode").val();
	var tableCols = $("#tableCols").val();
	var mysqlBoot = $("#mysqlBoot").val();
	var oracleBoot = $("#oracleBoot").val();
	var sqlserverBoot = $("#sqlserverBoot").val();
	var dmBoot = $("#dmBoot").val();
	var data = {
		"tableName" : tableName,
		"tableCode" : tableCode,
		"cols" : tableCols,
		"mysqlBoot" : mysqlBoot,
		"oracleBoot" : oracleBoot,
		"sqlserverBoot" : sqlserverBoot,
		"dmBoot" : dmBoot
	};

	$.ajax({
		type : "POST",
		url : "/metadata/dbgenerate",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			// alert(JSON.stringify(message));

			var status = message.status;
			if (status == '1') {
				var mysqlBoot1 = message.result.mysqlSql;
				var oracleBoot1 = message.result.oracleSql;
				var sqlserverBoot1 = message.result.sqlserverSql;
				var dmBoot1 = message.result.dmSql;
				// alert(mysqlBoot1);
				// alert(oracleBoot1);

				$("#mysqlBoot").val(mysqlBoot1);
				$("#oracleBoot").val(oracleBoot1);
				$("#sqlserverBoot").val(sqlserverBoot1);
				$("#dmBoot").val(dmBoot1);

			} else {
				alert(message.message);
			}

		},
		error : function(message) {
			$("#request-process-patent").html("提交数据失败！");
		}
	});

}



$("#generatesave").click(function() {
	var tableName = $("#tableName").val();
	var tableCode = $("#tableCode").val();
	var tableCols = $("#tableCols").val();
	var mysqlBoot = $("#mysqlBoot").val();
	var oracleBoot = $("#oracleBoot").val();
	var sqlserverBoot = $("#sqlserverBoot").val();
	var dmBoot = $("#dmBoot").val();
	var data = {
		"tableName" : tableName,
		"tableCode" : tableCode,
		"cols" : tableCols,
		"mysqlBoot" : mysqlBoot,
		"oracleBoot" : oracleBoot,
		"sqlserverBoot" : sqlserverBoot,
		"dmBoot" : dmBoot
	};

	$.ajax({
		type : "POST",
		url : "/metadata/dbgenerateSave",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(message) {
			alert(message.message);

		},
		error : function(message) {
			alert("提交数据失败！");
		}
	});
}
);


