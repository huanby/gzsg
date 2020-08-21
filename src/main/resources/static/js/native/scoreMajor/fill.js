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
	// $("div.col-md-12").siblings().hide();
	// $("#1").show();

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

	// document.getElementsByTagName("input").disabled = true;
	// $("input").attr("disabled",true);
	$("input").attr("readonly",true);
	// $("input[type='radio']:checked").attr("disabled",true);
	$("input[type='radio']").not("input:checked").attr("disabled",true);
	$("input[type='checkbox']:checked").attr("onclick","return false");
	$("input[type='checkbox']").not("input:checked").attr("disabled",true);
	$("select").attr("disabled",true);
	//初始化保存按钮
	initSaveBtn();

}


function initSaveBtn() {
	var majorId = $("#hidden_majorId").val();
	$("#saveBasicInfo").remove();
	$("#saveBasciData").remove();
	$("#saveLeaderInfo").remove();
	$("#saveAchievements").remove();

}



