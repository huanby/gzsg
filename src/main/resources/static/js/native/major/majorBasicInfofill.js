/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listenerMajorBasicInfo();
	/* 初始化 */
	initMajorBasicInfo();
});

function listenerMajorBasicInfo(){

	//专业（群）基本情况-基础信息 保存
	$("#saveBasicInfo").on("click",function () {
		$("#majorEditForm_basicInfo").data("bootstrapValidator").validate();
		var flag = $("#majorEditForm_basicInfo").data("bootstrapValidator").isValid();
		if(flag){
			majorBasicInfoSave();
		}else {
			showInfo("数据填报有误，请检查");
		}

	})

}

function initMajorBasicInfo(){


	$('.t5').datepicker({
		todayBtn : "linked",
		autoclose : true,
		todayHighlight : true,
		endDate : new Date(),
		format: 'yyyy-mm-dd',
		language:'zh-CN'
	});



	$("#t5").datepicker({
        todayBtn : "linked",
        autoclose : true,
        todayHighlight : true,
        endDate : new Date(),
        format: 'yyyy-mm-dd',
        language:'zh-CN'
    }).on('hide',function(e) {
		$('#majorEditForm_basicInfo').data('bootstrapValidator')
			.updateStatus('t5', 'NOT_VALIDATED',null)
			.validateField('t5');
	});
	/*$("#t6").datepicker({
		todayBtn : "linked",
		autoclose : true,
		todayHighlight : true,
		endDate : new Date(),
		format: 'yyyy-mm-dd',
		language:'zh-CN'
	}).on('hide',function(e) {
		$('#majorEditForm_basicInfo').data('bootstrapValidator')
			.updateStatus('t6', 'NOT_VALIDATED',null)
			.validateField('t6');
	});*/
	$("#t7").datepicker({
		todayBtn : "linked",
		autoclose : true,
		todayHighlight : true,
		endDate : new Date(),
		format: 'yyyy-mm-dd',
		language:'zh-CN'
	}).on('hide',function(e) {
		$('#majorEditForm_basicInfo').data('bootstrapValidator')
			.updateStatus('t7', 'NOT_VALIDATED',null)
			.validateField('t7');
	});


	/*验证 专业（群）基本情况-基础信息*/
	validMajorBasicInfoEditForm();
	
}

/*验证 专业（群）基本情况-基础信息*/
function validMajorBasicInfoEditForm(){
	$('#majorEditForm_basicInfo').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			t1 : {
				validators : {
					notEmpty : {
						message : '专业（群）名称不能为空'
					},
					stringLength: {
						min: 2,
						max: 100,
						message: '专业（群）名称不能超过100个字，不能少于2个字'
					}
				}
			},
			t2 : {
				validators : {
					notEmpty : {
						message : '专业所属大类不能为空'
					}
				}
			},
			t3 : {
				validators : {
					notEmpty : {
						message : '龙头专业代码不能为空'
					},
					stringLength: {
						min: 2,
						max: 50,
						message: '龙头专业代码不能超过50个字，不能少于2个字'
					}
				}
			},
			t4 : {
				validators : {
					notEmpty : {
						message : '所在院（系）不能为空'
					},
					stringLength: {
						min: 2,
						max: 50,
						message: '所在院（系）不能超过50个字，不能少于2个字'
					}
				}
			},
			t5 : {
				validators : {
					notEmpty : {
						message : '专业批准设置时间不能为空'
					},
					date : {
						format : 'YYYY-MM-DD',
						message : '日期格式不正确'
					}
				}
			},
			t6 : {
				validators : {
					notEmpty : {
						message : '是否为国示或省重专业不能为空'
					}
					// date : {
					// 	format : 'YYYY-MM-DD',
					// 	message : '日期格式不正确'
					// }
				}
			},
			t7 : {
				validators : {
					notEmpty : {
						message : '首届学生毕业时间不能为空'
					},
					date : {
						format : 'YYYY-MM-DD',
						message : '日期格式不正确'
					}
				}
			},
			n1 : {
				validators : {
					notEmpty : {
						message : '专业在校生数（含顶岗实习学生人数）不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			t22 : {
				validators : {
					notEmpty : {
						message : '申报学校不能为空'
					},
					stringLength: {
						min: 2,
						// max: 100,
						message: '申报学校字段不能少于2个字'
					}
				}
			},
			t23 : {
				validators : {
					notEmpty : {
						message : '申报类别不能为空'
					}
				}
			},
		}
	});
}


function majorBasicInfoSave(){
	var url = "/majordata/majorFillbasicInfoSave.json";
	var obj = $("#majorEditForm_basicInfo").serialize();
	// console.log(obj);
	$.post(
		getRootPath()+url,
		$("#majorEditForm_basicInfo").serialize(),
		function(data) {
			// console.log(data);
			if(data.status == 200){
				showInfo("保存成功");
				$('.nav-tabs li').siblings().find("a").show();
				initImages();
				$("#saveBasicInfo").val("修改");
			}else{
				if (data.response != null && typeof(data.response) != undeifned){
					if(data.response.length > 0){
						var errorInfo = "<ul><li>"+data.message+"</li>";
						$.each(data.response,function(key,value){
							errorInfo += "<li>" + value + "</li>";
						})
						errorInfo+= "</ul>";
						showInfo(errorInfo)
					}else{
						showInfo(data.message)
					}
				}else{
					showInfo(data.message)
				}
			}
		}
	);
}