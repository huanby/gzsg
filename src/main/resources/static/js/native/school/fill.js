/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function listener(){
	$(".nav-tabs li").click(function(){
		$(".nav-tabs li").siblings().attr("class","");
		$(this).attr("class","active");
		switch($(this).find("a").html()){
			case "Tutorials":
				$("div.col-md-12").siblings().hide();
				$("#2").show();
				break;
			case "学校基础信息":
				$("div.col-md-12").siblings().hide();
				$("#1").show();
				break;
		}

	})
	
	$("#save").click(function (){
		$("#schoolEditForm").data("bootstrapValidator").validate();
		var flag = $("#schoolEditForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolBaseInfo(1)
		}
	})
	
	$("#update").click(function (){
		$("#schoolEditForm").data("bootstrapValidator").validate();
		var flag = $("#schoolEditForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolBaseInfo(2)
		}
	})
}

function saveSchoolBaseInfo(flat){

	var url = flat == 1 ? "/schooldata/schoolFillBaseSave.json" : "/schooldata/schoolFillBaseUpdate.json"
	$.post(
		getRootPath()+url, 
		$("#schoolEditForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
			}else{
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
			}
		}
	);
}

function init(){
	var onResize = function(){
	    $("body").css("margin-top",$(".navbar").height());
	};
	$(window).resize(onResize);
	$(function(){
	    onResize();
	});
	$("div.col-md-12").siblings().hide();
	$("#1").show();
	
	
	$("#buildDay").datepicker({
        todayBtn : "linked",
        autoclose : true,
        todayHighlight : true,
        endDate : new Date(),
        format: 'yyyy-mm-dd',
        language:'zh-CN'
    }).on('hide',function(e) {
        $('#schoolEditForm').data('bootstrapValidator')
            .updateStatus('buildDay', 'NOT_VALIDATED',null)
            .validateField('buildDay');
    });
	
	validSchoolEditForm();
	
	if($("#id").val()!=""){
		$("#update").show();
		$("#save").hide();
		$("#nature").val($("#nat").val());
		$("#type").val($("#typ").val());
	}
	
}

function validSchoolEditForm(){
	$('#schoolEditForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			buildDay : {
				validators : {
					notEmpty : {
						message : '建校日不能为空'
					},
					date : {
						format : 'YYYY-MM-DD',
						message : '日期格式不正确'
					}
				}
			},
			schoolName : {
				validators : {
					notEmpty : {
						message : '学校名称不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 100,
	                    message: '学校名称不能超过100个字，不能少于2个字'
	                }
				}
			},
			address : {
				validators : {
					notEmpty : {
						message : '学校地址不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 100,
	                    message: '学校地址不能超过255个字，不能少于2个字'
	                }
				}
			},
			nature : {
				validators : {
					notEmpty : {
						message : '学校性质必填为【公办】/【私立】'
					}
				}
			},
			type : {
				validators : {
					notEmpty : {
						message : '举办单位不能为空'
					}
				}
			},
			website : {
				validators : {
					notEmpty : {
						message : '网址不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 100,
	                    message: '网址长度为5到100个字节。'
	                },
	                uri : {
	                	message : "请输入合法网址。"
	                }
				}
			},
			postalAddress : {
				validators : {
					notEmpty : {
						message : '通讯地址不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 100,
	                    message: '通讯地址长度为5到255个字节。'
	                }
				}
			},
			postcode : {
				validators : {
					notEmpty : {
						message : '邮政编码不能为空'
					},
					digits: {
						message : '邮编只能是数字'
					},
					stringLength: {
						min: 6,
						max: 6,
						message: '邮编只能是6位数'
					}
				}
			},
			leName : {
				validators : {
					notEmpty : {
						message : '法人姓名不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 255,
	                    message: '联系人长度为2到255个字节。'
	                }
				}
			},
			leOfficePhone : {
				validators : {
					notEmpty : {
						message : '法人办公电话不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 20,
	                    message: '法人办公电话长度为2到20个字节。'
	                }
				}
			},
			leEmail : {
				validators : {
					emailAddress : {
						message : "请输入合法的email。"
					}
				}
			},
			lePhone : {
				validators : {
					notEmpty : {
						message : '法人办联系方式不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 20,
	                    message: '法人电话长度为2到20个字节。'
	                }
				}
			},
			conName : {
				validators : {
					notEmpty : {
						message : '联系人姓名不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 255,
	                    message: '联系人姓名长度为2到255个字节。'
	                }
				}
			},
			conOfficePhone : {
				validators : {
					notEmpty : {
						message : '联系人办公电话不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 20,
	                    message: '联系人公电话长度为2到20个字节。'
	                }
				}
			},
			conEmail : {
				validators : {
					emailAddress : {
						message : "请输入合法的email。"
					}
				}
			},
			conPhone : {
				validators : {
					notEmpty : {
						message : '联系人办联系方式不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 20,
	                    message: '联系人电话长度为2到20个字节。'
	                }
				}
			}
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		saveSchoolBaseInfo(1);
	});
}