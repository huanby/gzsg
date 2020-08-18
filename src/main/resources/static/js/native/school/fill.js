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
	
}

function validSchoolEditForm(){
	$('#schoolEditForm').bootstrapValidator({
		message : '该值无效',
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
			}
		}
	});
}