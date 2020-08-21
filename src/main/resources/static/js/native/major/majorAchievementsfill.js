/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listenerMajorAchievements();
	/* 初始化 */
	initMajorAchievements();
});

function listenerMajorAchievements(){

	//专业（群）建设成果表- 保存
	$("#saveAchievements").on("click",function () {
		$("#majorEditForm_achievements").data("bootstrapValidator").validate();
		var flag = $("#majorEditForm_achievements").data("bootstrapValidator").isValid();
		if(flag){
			//保存数据
			majorAchievementsSave();
		}
	})

}

function initMajorAchievements(){

	/*验证 专业（群）建设成果表*/
	validMajorAchievementsEditForm();
	
}

/*验证 专业（群）建设成果表-*/
function validMajorAchievementsEditForm(){
	$('#majorEditForm_achievements').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'

		},
		excluded : ':disabled',
		fields : {
			t19 : {
				validators : {
					notEmpty : {
						message : '是否入选“吉林省普通高等学校高水平专业（群）建设计划不能为空'
					},
					// stringLength: {
					// 	min: 2,
					// 	max: 50,
					// 	message: '姓名不能超过50个字，不能少于2个字'
					// }
				}
			},
			t20 : {
				validators : {
					notEmpty : {
						message : '是否选入国家、省级重点专业不能为空'
					},
					/*stringLength: {
						min: 1,
						max: 1,
						message: '性别不能超过1个字'
					}*/
				}
			},
			t21 : {
				validators : {
					notEmpty : {
						message : '是否入选“吉林省现代职业教育改革发展示范校建设计划项目”不能为空'
					},
					// date : {
					// 	format : 'YYYY-MM-DD',
					// 	message : '出生年月日期格式不正确'
					// }
				}
			},
			n30 : {
				validators : {
					notEmpty : {
						message : '骨干专业国家级现代学徒制试点项目数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n31 : {
				validators : {
					notEmpty : {
						message : '骨干专业省级现代学徒制试点项目数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n32 : {
				validators : {
					notEmpty : {
						message : '近两届骨干专业国家级教学成果奖数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n33 : {
				validators : {
					notEmpty : {
						message : '近两届骨干专业省级教学成果奖数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n34 : {
				validators : {
					notEmpty : {
						message : '专业群学生国赛获奖数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n35 : {
				validators : {
					notEmpty : {
						message : '专业群学生省赛获奖数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n36 : {
				validators : {
					notEmpty : {
						message : '专业群教师队伍建设成果数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n37 : {
				validators : {
					notEmpty : {
						message : '专业群三年累计社会培训和鉴定人数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n38 : {
				validators : {
					notEmpty : {
						message : '国家级科研成果、论文与专利数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n39 : {
				validators : {
					notEmpty : {
						message : '省级科研成果、论文与专利数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n40 : {
				validators : {
					notEmpty : {
						message : '骨干专业在校生规模不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n41 : {
				validators : {
					notEmpty : {
						message : '专业（群）实训基地建设成果数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n42 : {
				validators : {
					notEmpty : {
						message : '专业群服务“一带一路”战略的国际交流与合作项目数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},
			n43 : {
				validators : {
					notEmpty : {
						message : '专业群建设各级专项资金投入不能为空'
					},
					regexp: { //正则表达式
						regexp: /^\d+(\.\d{0,2})?$/,
						message: '字段只能为整数或两位小数'
					},
				}
			},
			n44 : {
				validators : {
					notEmpty : {
						message : '其他省级以上标志性成果数不能为空'
					},
					digits : {
						message : '字段必须是正整数'
					}
				}
			},


		}
	});
}


//提交保存数据
function majorAchievementsSave(){
	var url = "/majordata/majorFillbasicInfoSave.json";
	$.post(
		getRootPath()+url,
		$("#majorEditForm_achievements").serialize(),
		function(data) {
			// console.log(data);
			if(data.status == 200){
				showInfo("保存成功");
				$("#saveAchievements").val("修改");
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