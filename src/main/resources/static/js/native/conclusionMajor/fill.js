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
	/*标签页切换*/
	$(".nav-tabs li").click(function(){
		$(".nav-tabs li").siblings().attr("class","");
		$(this).attr("class","active");
		switch($(this).find("a").html()){
			case "专业（群）基本情况-基础信息":
				$("div.col-md-12").siblings().hide();
				$("#1").show();
				break;
			case "专业（群）基本情况-基础数据":
				$("div.col-md-12").siblings().hide();
				$("#2").show();
				break;
			case "专业（群）带头人基本情况":
				$("div.col-md-12").siblings().hide();
				$("#3").show();
				break;
			case "专业（群）建设成果表":
				$("div.col-md-12").siblings().hide();
				$("#4").show();
				break;
			case "佐证材料管理":
				$("div.col-md-12").siblings().hide();
				$("#5").show();
				break;
			case "评分":
				$("div.col-md-12").siblings().hide();
				$("#6").show();
				break;
		}
	})


	//保存、修改得分
	$("#saveSCORE").click(function (){
		$("#majorScoreForm").data("bootstrapValidator").validate();
		var flag = $("#majorScoreForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSCOREinfo(1)
		}
	})

	$("#updateSCORE").click(function (){
		$("#majorScoreForm").data("bootstrapValidator").validate();
		var flag = $("#majorScoreForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSCOREinfo(2)
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
	// 初始化展示第一页
	$("div.col-md-12").siblings().hide();
	$("#1").show();

	// 初始化标签页
	if($("#hidden_majorId").val() == ""){
		$('.nav-tabs li').siblings().find("a").hide();
		$('.nav-tabs li.active').find("a").show();
	}else{
		$("#saveBasicInfo").val("修改");
		$("#saveBasciData").val("修改");
		$("#saveLeaderInfo").val("修改");
		$("#saveAchievements").val("修改");
	}

	if($("#SCOREid").val()!=""){
		$("#updateSCORE").show();
		$("#saveSCORE").hide();
	}


	// document.getElementsByTagName("input").disabled = true;
	// $("input").attr("disabled",true);
	// $("input[type='radio']:checked").attr("disabled",true);
	$("input").attr("readonly",true);
	// $("#6 input").attr("readonly",false)
	$("#5 input").attr("readonly",true);
	// console.log($("#5 button"));
	// $("#5 input button").attr("data-url","");
	$("input[type='radio']").not("input:checked").attr("disabled",true);
	$("input[type='checkbox']:checked").attr("onclick","return false");
	$("input[type='checkbox']").not("input:checked").attr("disabled",true);
	$("select").attr("disabled",true);


	//初始化保存按钮
	initSaveBtn();

	// 验证得分提交表单
	// validMajorScoreForm();


}


function initSaveBtn() {
	var majorId = $("#hidden_majorId").val();
	$("#saveBasicInfo").remove();
	$("#saveBasciData").remove();
	$("#saveLeaderInfo").remove();
	$("#saveAchievements").remove();
}

//验证得分提交表单
function validMajorScoreForm(){
	$('#majorScoreForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			score : {
				validators : {
					notEmpty : {
						message : '评分结果不能为空'
					},
					between : {
						min : 0,
						max : 100,
						message : "评分必须是0-100之间"
					}
				}
			},
			remark : {
				validators : {
					notEmpty : {
						message : '评分评价不能为空'
					}
				}
			}
		}
	})
}


function saveSCOREinfo(flat){
	var url = flat == 1 ? "/score/majorScoreSave.json" : "/score/majorScoreUpdate.json";
	$.post(
		getRootPath()+url,
		$("#majorScoreForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveSCORE").hide();
					$("#updateSCORE").show();
				}
			}else{
				if(data.response != null){
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



