/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listenerMajorBasicData();
	/* 初始化 */
	initMajorBasicData();
});

function listenerMajorBasicData(){

	//专业（群）基本情况-基础数据 保存
	$("#saveBasciData").on("click",function () {
		$("#majorEditForm_basicData").data("bootstrapValidator").validate();
		var flag = $("#majorEditForm_basicData").data("bootstrapValidator").isValid();
		if(flag){
			//保存数据
			majorBasicDataSave();
		}else {
			showInfo("本填报页存在格式错误或内容遗漏，请检查后提交，请检查");
		}
	})

}

function initMajorBasicData(){
	/*验证 专业（群）基本情况-基础数据*/
	validMajorBasicDataEditForm();
	
}

/*验证 专业（群）基本情况-基础数据*/
function validMajorBasicDataEditForm(){
	$('#majorEditForm_basicData').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			n2 : {
				validators : {
					notEmpty : {
						message : '2017年专业招生人数/专业在校生人数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n3 : {
				validators : {
					notEmpty : {
						message : '2018年专业招生人数/专业在校生人数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n4 : {
				validators : {
					notEmpty : {
						message : '2019年专业招生人数/专业在校生人数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n5 : {
				validators : {
					notEmpty : {
						message : '2017年毕业生数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n6 : {
				validators : {
					notEmpty : {
						message : '2018年毕业生数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n7 : {
				validators : {
					notEmpty : {
						message : '2019年毕业生数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n8 : {
				validators : {
					notEmpty : {
						message : '2018届毕业生年底就业率不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
					// 内容最小值验证
					greaterThan: {
						value : 0,
						message : '字段最小输入0'
					},
					//内容最大值验证
					lessThan: {
						value : 100,
						message : '字段最大输入100'
					}
				}
			},
			n9 : {
				validators : {
					notEmpty : {
						message : '2018届毕业生用人单位满意或基本满意比例不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
					// 内容最小值验证
					greaterThan: {
						value : 0,
						message : '字段最小输入0'
					},
					//内容最大值验证
					lessThan: {
						value : 100,
						message : '字段最大输入100'
					}
				}
			},
			n10 : {
				validators : {
					notEmpty : {
						message : '校内专任教师数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n11 : {
				validators : {
					notEmpty : {
						message : '专任教师双师素质比例不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
					// 内容最小值验证
					greaterThan: {
						value : 0,
						message : '字段最小输入0'
					},
					//内容最大值验证
					lessThan: {
						value : 100,
						message : '字段最大输入100'
					}
				}
			},
			n12 : {
				validators : {
					notEmpty : {
						message : '校内专任教师高级职称人数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n13 : {
				validators : {
					notEmpty : {
						message : '专任教师研究生以上学历人数比例不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
					// 内容最小值验证
					greaterThan: {
						value : 0,
						message : '字段最小输入0'
					},
					//内容最大值验证
					lessThan: {
						value : 100,
						message : '字段最大输入100'
					}
				}
			},
			n14 : {
				validators : {
					notEmpty : {
						message : '2018-20198学年兼职教师总数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n15 : {
				validators : {
					notEmpty : {
						message : '兼职教师人数占专业课教师总数的比例不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
					// 内容最小值验证
					greaterThan: {
						value : 0,
						message : '字段最小输入0'
					},
					//内容最大值验证
					lessThan: {
						value : 100,
						message : '字段最大输入100'
					}
				}
			},
			n16: {
				validators : {
					notEmpty : {
						message : '校内实训基地数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n17 : {
				validators : {
					notEmpty : {
						message : '校内实训基地工位数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n18 : {
				validators : {
					notEmpty : {
						message : '校内实训基地生均设备值不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,4})?$/,
						message: '字段只能为整数或四位小数'
					}
				}
			},
			n19 : {
				validators : {
					notEmpty : {
						message : '2018-2019学年校内实训基地使用频率不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,1})?$/,
						message: '字段只能为整数或一位小数'
					}
				}
			},
			n20 : {
				validators : {
					notEmpty : {
						message : '校外实习实训基地数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n21 : {
				validators : {
					notEmpty : {
						message : '2018-2019学年校外实习实训基地接受半年顶岗实习学生数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n22 : {
				validators : {
					notEmpty : {
						message : '校外实习实训基地接收2019届毕业生就业数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n23 : {
				validators : {
					notEmpty : {
						message : '本专业合作企业总数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n24 : {
				validators : {
					notEmpty : {
						message : '本专业合作企业订单培养总数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n25 : {
				validators : {
					notEmpty : {
						message : '本专业合作企业共同开发课程总数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n26 : {
				validators : {
					notEmpty : {
						message : '本专业合作企业支持学校兼职教师总数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n27 : {
				validators : {
					notEmpty : {
						message : '合作企业对本专业准捐赠设备总值不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,4})?$/,
						message: '字段只能为整数或四位小数'
					}
				}
			},
			n28 : {
				validators : {
					notEmpty : {
						message : '合作企业对本专业捐赠设备总值不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,4})?$/,
						message: '字段只能为整数或四位小数'
					}
				}
			},
			n29 : {
				validators : {
					notEmpty : {
						message : '本专业为企业培训员工总数不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,1})?$/,
						message: '字段只能为整数或一位小数'
					}
				}
			},

		}
	});
}


//提交保存数据
function majorBasicDataSave(){
	var url = "/majordata/majorFillbasicInfoSave.json";
	$.post(
		getRootPath()+url,
		$("#majorEditForm_basicData").serialize(),
		function(data) {
			// console.log(data);
			if(data.status == 200){
				showInfo("保存成功");
				$("#saveBasciData").val("修改");
			}else{
				if (data.response != null && typeof (data.response) != undeifned) {
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
				} else {
					showInfo(data.message)
				}
			}
		}
	);
}