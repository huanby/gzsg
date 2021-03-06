/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listenerMajorLeaderInfo();
	/* 初始化 */
	initMajorLeaderInfo();
});

function listenerMajorLeaderInfo(){

	//专业（群）带头人基本情况 保存
	$("#saveLeaderInfo").on("click",function () {
		$("#majorEditForm_leaderInfo").data("bootstrapValidator").validate();
		var flag = $("#majorEditForm_leaderInfo").data("bootstrapValidator").isValid();
		if(flag){
			//保存数据
			majorLeaderInfoSave();
		}else {
			showInfo("本填报页存在格式错误或内容遗漏，请检查后提交，请检查");
		}
	})

}

function initMajorLeaderInfo(){

	$("#t10").datepicker({
		todayBtn : "linked",
		autoclose : true,
		todayHighlight : true,
		endDate : new Date(),
		startView : 1,
		minViewMode : 1,
		format: 'yyyy-mm',
		language:'zh-CN'
	}).on('hide',function(e) {
		$('#majorEditForm_leaderInfo').data('bootstrapValidator')
			.updateStatus('t10', 'NOT_VALIDATED',null)
			.validateField('t10');
	});

	/*验证 专业（群）带头人基本情况*/
	validMajorLeaderInfoEditForm();
	
}

/*验证 专业（群）带头人基本情况*/
function validMajorLeaderInfoEditForm(){
	$('#majorEditForm_leaderInfo').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			t8 : {
				validators : {
					notEmpty : {
						message : '姓名不能为空'
					},
					stringLength: {
						min: 2,
						max: 50,
						message: '姓名不能超过50个字，不能少于2个字'
					}
				}
			},
			t9 : {
				validators : {
					notEmpty : {
						message : '性别不能为空'
					},
					stringLength: {
						min: 1,
						max: 1,
						message: '性别不能超过1个字'
					}
				}
			},
			t10 : {
				validators : {
					notEmpty : {
						message : '出生年月不能为空'
					},
					callback: {
						message: '日期格式不正确',
						callback: function(value, validator) {
							//这里可以自定义value的判断规则
							if(value.match(/^((?:19|20)\d\d)-(0[1-9]|1[012])$/)) {
								return true;
							} else {
								return false;
							}
						}
					}
					/*date : {
						format : 'YYYY-MM-DD',
						message : '出生年月日期格式不正确'
					}*/
				}
			},
			t11 : {
				validators : {
					notEmpty : {
						message : '参加工作时学历及所学专业不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '参加工作时学历及所学专业不能少于1个字,没有可以填无'
					}
				}
			},
			t12 : {
				validators : {
					notEmpty : {
						message : '最后学历及所学专业不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '最后学历及所学专业不能少于1个字,没有可以填无'
					}
				}
			},
			t13 : {
				validators : {
					notEmpty : {
						message : '专业技术职称不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '专业技术职称不能少于1个字,没有可以填无'
					}
				}
			},
			t14 : {
				validators : {
					notEmpty : {
						message : '证书擅长专业领域不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '证书擅长专业领域不能少于1个字,没有可以填无'
					}
				}
			},
			t15 : {
				validators : {
					notEmpty : {
						message : '职务不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '职务不能少于1个字,没有可以填无'
						// message: '职务不能超过50个字，不能少于1个字'
					}
				}
			},
			t16 : {
				validators : {
					notEmpty : {
						message : '职业资格（含行业企业认证）不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '职业资格（含行业企业认证）不能少于1个字,没有可以填无'
					}
				}
			},
			t17 : {
				validators : {
					notEmpty : {
						message : '主要社会兼职不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '主要社会兼职不能少于1个字,没有可以填无'
					}
				}
			},
			t18 : {
				validators : {
					notEmpty : {
						message : '主要业绩（含企业实践）及相关荣誉不能为空'
					},
					stringLength: {
						min: 1,
						// max: 50,
						message: '主要业绩（含企业实践）及相关荣誉不能少于1个字,没有可以填无'
					}
				}
			},


		}
	});
}


//提交保存数据
function majorLeaderInfoSave(){
	var url = "/majordata/majorFillbasicInfoSave.json";
	$.post(
		getRootPath()+url,
		$("#majorEditForm_leaderInfo").serialize(),
		function(data) {
			// console.log(data);
			if(data.status == 200){
				showInfo("保存成功");
				$("#saveLeaderInfo").val("修改");
			}else{
				if (data.response != null && typeof(data.response) != undeifned){
					if (data.response.length > 0) {
						var errorInfo = "<ul><li>" + data.message + "</li>";
						$.each(data.response, function (key, value) {
							errorInfo += "<li>" + value + "</li>";
						})
						errorInfo += "</ul>";
						showInfo(errorInfo)
					} else {
						showInfo(data.message)
					}
				}else {
					showInfo(data.message)
				}
			}
		}
	);
}