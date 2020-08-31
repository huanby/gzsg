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
			case "1.专业（群）基本情况-1":
				$("div.col-md-12").siblings().hide();
				$("#1").show();
				break;
			case "2.专业（群）基本情况-2":
				$("div.col-md-12").siblings().hide();
				$("#2").show();
				break;
			case "3.专业（群）带头人":
				$("div.col-md-12").siblings().hide();
				$("#3").show();
				break;
			case "4.专业（群）建设成果表":
				$("div.col-md-12").siblings().hide();
				$("#4").show();
				break;
			case "5.附件材料管理":
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
	
}


function initSaveBtn() {
	var majorId = $("#hidden_majorId").val();
	if(majorId != "" && majorId != null){

	}


}



