/**
 * 编辑普通模板页面 author 梁雪峰
 */
var pathList=[];
var initPreviewConfig=[];  
var ks = {};
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
		case "学校基础信息":
			$("div.col-md-12").siblings().hide();
			$("#1").show();
			break;
		case "师资队伍*教学资源":
			$("div.col-md-12").siblings().hide();
			$("#2").show();
			break;
		case "支撑平台*科研项目*学生发展*专业":
			$("div.col-md-12").siblings().hide();
			$("#3").show();
			break;
		case "创新成果*国际交流*社会服务*办学声誉":
			$("div.col-md-12").siblings().hide();
			$("#4").show();
			break;
		case "办学经费*基本条件":
			$("div.col-md-12").siblings().hide();
			$("#5").show();
			break;
		case "标志性成果*其它国家级成果":
			$("div.col-md-12").siblings().hide();
			$("#6").show();
			break;
		case "附件材料管理":
			$("div.col-md-12").siblings().hide();
			$("#7").show();
			break;
		case "评分":
			$("div.col-md-12").siblings().hide();
			$("#8").show();
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
	
	$("#saveTT").click(function (){
		$("#schoolTTForm").data("bootstrapValidator").validate();
		var flag = $("#schoolTTForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolTTInfo(1)
		}
	})
	
	$("#updateTT").click(function (){
		$("#schoolTTForm").data("bootstrapValidator").validate();
		var flag = $("#schoolTTForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolTTInfo(2)
		}
	})
	
	$("#saveSRSM").click(function (){
		$("#schoolSRSMForm").data("bootstrapValidator").validate();
		var flag = $("#schoolSRSMForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolSRSMInfo(1)
		}
	})
	
	$("#updateSRSM").click(function (){
		$("#schoolSRSMForm").data("bootstrapValidator").validate();
		var flag = $("#schoolSRSMForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolSRSMInfo(2)
		}
	})
	
	$("#saveIISS").click(function (){
		$("#schoolIISSForm").data("bootstrapValidator").validate();
		var flag = $("#schoolIISSForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolIISSInfo(1)
		}
	})
	
	$("#updateIISS").click(function (){
		$("#schoolIISSForm").data("bootstrapValidator").validate();
		var flag = $("#schoolIISSForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolIISSInfo(2)
		}
	})
	
	$("#saveSB").click(function (){
		$("#schoolSBForm").data("bootstrapValidator").validate();
		var flag = $("#schoolSBForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolSBInfo(1)
		}
	})
	
	$("#updateSB").click(function (){
		$("#schoolSBForm").data("bootstrapValidator").validate();
		var flag = $("#schoolSBForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolSBInfo(2)
		}
	})
	
	$("#saveLAON").click(function (){
		$("#schoolLAONForm").data("bootstrapValidator").validate();
		var flag = $("#schoolLAONForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolLAONInfo(1)
		}
	})
	
	$("#updateLAON").click(function (){
		$("#schoolLAONForm").data("bootstrapValidator").validate();
		var flag = $("#schoolLAONForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSchoolLAONInfo(2)
		}
	})
	
	$("#saveSCORE").click(function (){
		$("#scoreForm").data("bootstrapValidator").validate();
		var flag = $("#scoreForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSCOREinfo(1)
		}
	})
	
	$("#updateSCORE").click(function (){
		$("#scoreForm").data("bootstrapValidator").validate();
		var flag = $("#scoreForm").data("bootstrapValidator").isValid();
		if(flag){
			saveSCOREinfo(2)
		}
	})
}

function saveSCOREinfo(flat){
	var url = flat == 1 ? "/score/scoreSave.json" : "/score/scoreUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#scoreForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveSCORE").hide();
					$("#updateSCORE").show();
					var str = data.message.split(",");
					$("#SCOREid").val(str[1]);
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

function saveSchoolLAONInfo(flat){
	var url = flat == 1 ? "/schooldata/schoolFillLAONSave.json" : "/schooldata/schoolFillLAONUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#schoolLAONForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveLAON").hide();
					$("#updateLAON").show();
					var str = data.message.split(",");
					$("#LAONid").val(str[1]);
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

function saveSchoolSBInfo(flat){
	var url = flat == 1 ? "/schooldata/schoolFillSBSave.json" : "/schooldata/schoolFillSBUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#schoolSBForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveSB").hide();
					$("#updateSB").show();
					var str = data.message.split(",");
					$("#SBid").val(str[1]);
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

function saveSchoolIISSInfo(flat){
	var url = flat == 1 ? "/schooldata/schoolFillIISSSave.json" : "/schooldata/schoolFillIISSUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#schoolIISSForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveIISS").hide();
					$("#updateIISS").show();
					var str = data.message.split(",");
					$("#IISSid").val(str[1]);
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

function saveSchoolSRSMInfo(flat){
	var url = flat == 1 ? "/schooldata/schoolFillSRSMSave.json" : "/schooldata/schoolFillSRSMUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#schoolSRSMForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveSRSM").hide();
					$("#updateSRSM").show();
					var str = data.message.split(",");
					$("#SRSMid").val(str[1]);
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

function saveSchoolTTInfo(flat){
	var url = flat == 1 ? "/schooldata/schoolFillTTSave.json" : "/schooldata/schoolFillTTUpdate.json";
	$.post(
		getRootPath()+url, 
		$("#schoolTTForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				if(flat==1){
					$("#saveTT").hide();
					$("#updateTT").show();
					var str = data.message.split(",");
					$("#TTid").val(str[1]);
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

function saveSchoolBaseInfo(flat){

	var url = flat == 1 ? "/schooldata/schoolFillBaseSave.json" : "/schooldata/schoolFillBaseUpdate.json"
	$.post(
		getRootPath()+url, 
		$("#schoolEditForm").serialize(),
		function(data) {
			if(data.status == 200){
				showInfo("保存成功");
				$('.nav-tabs li').siblings().find("a").show();
				if(flat==1){
					$("#save").hide();
					$("#update").show();
					var str = data.message.split(",");
					$("#id").val(str[1]);
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
	
	validSchoolTTForm();
	
	validSchoolSRSMForm();
	
	validSchoolIISSForm();
	
	validSchoolSBForm();
	
	validSchoolLAONForm();
	
	validScoreForm();
	
	if($("#id").val()!=""){
		$("#update").show();
		$("#save").hide();
	}else{
		$('.nav-tabs li').siblings().find("a").hide();
		$('.nav-tabs li.active').find("a").show();
	}
	if($("#TTid").val()!=""){
		$("#updateTT").show();
		$("#saveTT").hide();
	}
	
	if($("#SRSMid").val()!=""){
		$("#updateSRSM").show();
		$("#saveSRSM").hide();
	}
	
	if($("#IISSid").val()!=""){
		$("#updateIISS").show();
		$("#saveIISS").hide();
	}
	
	if($("#SBid").val()!=""){
		$("#updateSB").show();
		$("#saveSB").hide();
	}
	
	if($("#LAONid").val()!=""){
		$("#updateLAON").show();
		$("#saveLAON").hide();
	}
	
	if($("#SCOREid").val()!=""){
		$("#updateSCORE").show();
		$("#saveSCORE").hide();
	}
	
	if($("#isExamine").val() == "true"){
		$("input").attr("disabled",true)
		$("select").attr("disabled",true)
		$("#7 input").attr("disabled",false)
		$("#8 input").attr("disabled",false)
		$("input[type='radio']").not("input:checked").parent().parent().hide();
	}else{
		$("#score").hide();
	}
	
	if($("#isView").val() == "true"){
		$("#score").hide();
	}
	
	// initImages();
	initImages(0);
}

function validScoreForm(){
	$('#scoreForm').bootstrapValidator({
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

function validSchoolLAONForm(){
	$('#schoolLAONForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			g1 : {
				validators : {
					notEmpty : {
						message : '国家示范校、骨干校、优质校成果数（个）不能为空'
					},
					digits: {
						message : '国家示范校、骨干校、优质校成果数（个）只能是正整数'
					}
				}
			},
			g2 : {
				validators : {
					notEmpty : {
						message : '吉林省示范校、骨干校、优质校成果数（个）不能为空'
					},
					digits: {
						message : '国家示范校、骨干校、优质校成果数（个）只能是正整数'
					}
				}
			},
			g3 : {
				validators : {
					notEmpty : {
						message : '仅包括现代学徒制试点、教学工作诊断与改进工作试点、定向培养士官试点'
					},
					digits: {
						message : '国家级教育教学改革试点数（个）只能是正整数'
					}
				}
			},
			g4 : {
				validators : {
					notEmpty : {
						message : '仅包括现代学徒制试点、教学工作诊断与改进工作试点、定向培养士官试点'
					},
					digits: {
						message : '省级教育教学改革试点数（个）只能是正整数'
					}
				}
			},
			g5 : {
				validators : {
					notEmpty : {
						message : '填报2006年以来国家级示范、品牌、特色专业和高水平专业建设项目'
					},
					digits: {
						message : '国家级重点专业数（个）只能是正整数'
					}
				}
			},
			g6 : {
				validators : {
					notEmpty : {
						message : '填报2006年以来省级示范、品牌、特色专业和高水平专业建设项目'
					},
					digits: {
						message : '省级重点专业数（个）只能是正整数'
					}
				}
			},
			g7 : {
				validators : {
					notEmpty : {
						message : '国家级财政支持的实训基地数（个）不能为空'
					},
					digits: {
						message : '国家级财政支持的实训基地数（个）只能是正整数'
					}
				}
			},
			g8 : {
				validators : {
					notEmpty : {
						message : '省级财政支持的实训基地数（个）不能为空'
					}
				},
				digits: {
					message : '省级财政支持的实训基地数（个）只能是正整数'
				}
			},
			g9 : {
				validators : {
					notEmpty : {
						message : '国家职业教育教学资源库数（个）不能为空'
					}
				},
				digits: {
					message : '国家职业教育教学资源库数（个）只能是正整数'
				}
			},
			g10 : {
				validators : {
					notEmpty : {
						message : '填报近五年全国毕业生就业典型经验高校、创新创业典型经验高校、创新创业教育改革示范高校，国家“双创”基地、国家创新创业教育改革示范高校、国家大学科技园、国家级科技企业孵化器等'
					}
				},
				digits: {
					message : '全国就业创业典型数（个）只能是正整数'
				}
			},
			g11 : {
				validators : {
					notEmpty : {
						message : '填报近五年全国、吉林省毕业生就业典型经验高校、创新创业典型经验高校、创新创业教育改革示范高校，国家“双创”基地、国家创新创业教育改革示范高校、国家大学科技园、国家级科技企业孵化器等'
					}
				},
				digits: {
					message : '吉林省就业创业典型数（个）只能是正整数'
				}
			},
			g12 : {
				validators : {
					notEmpty : {
						message : '教师国家级荣誉数（个）不能为空'
					}
				},
				digits: {
					message : '教师国家级荣誉数（个）只能是正整数'
				}
			},
			g13 : {
				validators : {
					notEmpty : {
						message : '教师省级荣誉数（个）不能为空'
					}
				},
				digits: {
					message : '教师省级荣誉数（个）只能是正整数'
				}
			},
			g14 : {
				validators : {
					notEmpty : {
						message : '仅填报近五年学校承办过的全国职业院校技能大赛'
					}
				},
				digits: {
					message : '承办全国职业院校技能大赛数（个）只能是正整数'
				}
			},
			g15 : {
				validators : {
					notEmpty : {
						message : '仅填报近五年学校承办过的吉林职业院校技能大赛'
					}
				},
				digits: {
					message : '承办吉林省职业院校技能大赛数（个）只能是正整数'
				}
			},
			g16 : {
				validators : {
					notEmpty : {
						message : '学校须为第一完成单位'
					}
				},
				digits: {
					message : '国家级教学成果奖励数（个）只能是正整数'
				}
			},
			g17 : {
				validators : {
					notEmpty : {
						message : '学校须为第一完成单位'
					}
				},
				digits: {
					message : '吉林省教学成果奖励数（个）只能是正整数'
				}
			},
			g18 : {
				validators : {
					notEmpty : {
						message : '教师全国职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）不能为空'
					}
				},
				digits: {
					message : '教师全国职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）只能是正整数'
				}
			},
			g19 : {
				validators : {
					notEmpty : {
						message : '教师吉林省职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）不能为空'
					}
				},
				digits: {
					message : '教师吉林省职业院校教学能力比赛获奖（含职业院校信息化教学大赛）数（个）只能是正整数'
				}
			},
			g20 : {
				validators : {
					notEmpty : {
						message : '学生全国职业院校技能大赛获奖数（个）近五年不能为空'
					}
				},
				digits: {
					message : '学生全国职业院校技能大赛获奖数（个）近五年只能是正整数'
				}
			},
			g21 : {
				validators : {
					notEmpty : {
						message : '学生吉林省职业院校技能大赛获奖数（个）近五年不能为空'
					}
				},
				digits: {
					message : '学生吉林省职业院校技能大赛获奖数（个）近五年只能是正整数'
				}
			},
			g22 : {
				validators : {
					notEmpty : {
						message : '学生中国“互联网+”大学生创新创业大赛获奖数（个）近五年不能为空'
					}
				},
				digits: {
					message : '学生中国“互联网+”大学生创新创业大赛获奖数（个）近五年只能是正整数'
				}
			},
			g23 : {
				validators : {
					notEmpty : {
						message : '学生吉林省“互联网+”大学生创新创业大赛获奖数（个）近五年不能为空'
					}
				},
				digits: {
					message : '学生吉林省“互联网+”大学生创新创业大赛获奖数（个）近五年只能是正整数'
				}
			},
			g24 : {
				validators : {
					notEmpty : {
						message : '学生“挑战杯”全国大学生课外学术科技作品竞赛和中国大学生创业计划竞赛获奖数（个）近五年不能为空'
					}
				},
				digits: {
					message : '学生“挑战杯”全国大学生课外学术科技作品竞赛和中国大学生创业计划竞赛获奖数（个）近五年只能是正整数'
				}
			},
			g25 : {
				validators : {
					notEmpty : {
						message : '其它国家级成果数，学校须为主持单位（个）不能为空'
					}
				},
				digits: {
					message : '其它国家级成果数，学校须为主持单位（个）只能是正整数'
				}
			}
		}
	})
}

function validSchoolSBForm(){
	$('#schoolSBForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			x1 : {
				validators : {
					notEmpty : {
						message : '本学校年生均财政拨款水平（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x2 : {
				validators : {
					notEmpty : {
						message : '2017年学校总收入（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x3 : {
				validators : {
					notEmpty : {
						message : '2017年学校总支出（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x4 : {
				validators : {
					notEmpty : {
						message : '2018年学校总收入（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x5 : {
				validators : {
					notEmpty : {
						message : '2018年学校总支出（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x6 : {
				validators : {
					notEmpty : {
						message : '2019年学校总收入（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x7 : {
				validators : {
					notEmpty : {
						message : '2019年学校总支出（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			x8 : {
				validators : {
					notEmpty : {
						message : '请选择学校办学条件高于专科高职学校设置标准【是-否】'
					}
				}
			},
			x9 : {
				validators : {
					notEmpty : {
						message : '请选择年生均财政拨款水平达到国家统一要求【是-否】'
					}
				}
			},
			x10 : {
				validators : {
					notEmpty : {
						message : '请选择校园网全覆盖【是-否】'
					}
				}
			},
			x11 : {
				validators : {
					notEmpty : {
						message : '请选择有三届以上全日制普通专科（三年制）毕业生【是-否】'
					}
				}
			},
			x12 : {
				validators : {
					notEmpty : {
						message : '请选择重点建设专业群的全日制在校生规模在800人以上【是-否】'
					}
				}
			},
			x13 : {
				validators : {
					notEmpty : {
						message : '请选择学校师生在校期间获得过省级教学成果一等及以上奖【是-否】'
					}
				}
			},
			x14 : {
				validators : {
					notEmpty : {
						message : '请选择学校师生在校期间获得过吉林省高等职业院校技能大赛一等奖【是-否】'
					}
				}
			},
			x15 : {
				validators : {
					notEmpty : {
						message : '请选择2016年以来，学校（单位或现任主要领导）没有因违纪违法受到处分的情况【是-否】'
					}
				}
			}
		}
	})
}


function validSchoolIISSForm(){
	$('#schoolIISSForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			s39 : {
				validators : {
					notEmpty : {
						message : '国家级教学成果奖获奖数（个）不能为空'
					},
					digits: {
						message : '国家级教学成果奖获奖数（个）只能是正整数'
					}
				}
			},
			s40 : {
				validators : {
					notEmpty : {
						message : '省级教学成果奖获奖数（个）不能为空'
					},
					digits: {
						message : '省级教学成果奖获奖数（个）只能是正整数'
					}
				}
			},
			s41 : {
				validators : {
					notEmpty : {
						message : '获国家级科研奖项数（个）不能为空'
					},
					digits: {
						message : '获国家级科研奖项数（个）只能是正整数'
					}
				}
			},
			s42 : {
				validators : {
					notEmpty : {
						message : '获省部级和行业科研奖项数（个）不能为空'
					},
					digits: {
						message : '获省部级和行业科研奖项数（个）只能是正整数'
					}
				}
			},
			s43 : {
				validators : {
					notEmpty : {
						message : '师均论文数（篇/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s44 : {
				validators : {
					notEmpty : {
						message : '在校学历教育国际学生占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s45 : {
				validators : {
					notEmpty : {
						message : '学生国（境）外学习、实习占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s46 : {
				validators : {
					notEmpty : {
						message : '国际合作办学机构（项目）数（个）不能为空'
					},
					digits: {
						message : '国际合作办学机构（项目）数（个）只能是正整数'
					}
				}
			},
			s47 : {
				validators : {
					notEmpty : {
						message : '技术转让当年实际收入（万元）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s48 : {
				validators : {
					notEmpty : {
						message : '决策咨询报告采纳数（篇）不能为空'
					},
					digits: {
						message : '决策咨询报告采纳数（篇）只能是正整数'
					}
				}
			},
			s49 : {
				validators : {
					notEmpty : {
						message : '社会培训人时数（人天）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s50 : {
				validators : {
					notEmpty : {
						message : '第一志愿录取率（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s51 : {
				validators : {
					notEmpty : {
						message : '毕业生满意度（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s52 : {
				validators : {
					notEmpty : {
						message : '社会捐赠收入占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s53 : {
				validators : {
					notEmpty : {
						message : '国家级示范校、骨干校荣誉数（个）不能为空'
					},
					digits: {
						message : '国家级示范校、骨干校荣誉数（个）只能是正整数'
					}
				}
			},
			s54 : {
				validators : {
					notEmpty : {
						message : '国家级特色高水平院校荣誉数（个）不能为空'
					},
					digits: {
						message : '国家级特色高水平院校荣誉数（个）只能是正整数'
					}
				}
			},
			s55 : {
				validators : {
					notEmpty : {
						message : '国家级优质校荣誉数（个）不能为空'
					},
					digits: {
						message : '国家级优质校荣誉数（个）只能是正整数'
					}
				}
			},
			s56 : {
				validators : {
					notEmpty : {
						message : '省级示范校、骨干校、优质校荣誉数（个）不能为空'
					},
					digits: {
						message : '省级示范校、骨干校、优质校荣誉数（个）只能是正整数'
					}
				}
			},
			s57 : {
				validators : {
					notEmpty : {
						message : '产教融合规划项目（个）不能为空'
					},
					digits: {
						message : '产教融合规划项目（个）只能是正整数'
					}
				}
			},
			s58 : {
				validators : {
					notEmpty : {
						message : '承办过全国职业院校技能大赛个数（个）不能为空'
					},
					digits: {
						message : '承办过全国职业院校技能大赛个数（个）只能是正整数'
					}
				}
			},
			s59 : {
				validators : {
					notEmpty : {
						message : '发布《高等职业院校质量年度报告》个数（个）不能为空'
					},
					digits: {
						message : '发布《高等职业院校质量年度报告》个数（个）只能是正整数'
					}
				}
			},
			
		}
	})
}

function validSchoolSRSMForm(){
	$('#schoolSRSMForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			s20 : {
				validators : {
					notEmpty : {
						message : '国家级现代学徒制试点（个）不能为空'
					},
					digits: {
						message : '国家级现代学徒制试点（个）只能是正整数'
					}
				}
			},
			s21 : {
				validators : {
					notEmpty : {
						message : '省级现代学徒制试点（个）不能为空'
					},
					digits: {
						message : '省级现代学徒制试点（个）只能是正整数'
					}
				}
			},
			s22 : {
				validators : {
					notEmpty : {
						message : '省级及以上三全育人综合改革试点（个）不能为空'
					},
					digits: {
						message : '省级及以上三全育人综合改革试点（个）只能是正整数'
					}
				}
			},
			s23 : {
				validators : {
					notEmpty : {
						message : '省级及以上教学工作诊断与改进工作试点（个）不能为空'
					},
					digits: {
						message : '省级及以上教学工作诊断与改进工作试点（个）只能是正整数'
					}
				}
			},
			s24 : {
				validators : {
					notEmpty : {
						message : '国家级创新创业教育示范基地数（个）不能为空'
					},
					digits: {
						message : '国家级创新创业教育示范基地数（个）只能是正整数'
					}
				}
			},
			s25 : {
				validators : {
					notEmpty : {
						message : '省部级创新创业教育示范基地数（个）不能为空'
					},
					digits: {
						message : '省部级创新创业教育示范基地数（个）只能是正整数'
					}
				}
			},
			s26 : {
				validators : {
					notEmpty : {
						message : '省级示范性实习实训基地（个）不能为空'
					},
					digits: {
						message : '省级示范性实习实训基地（个）只能是正整数'
					}
				}
			},
			s27 : {
				validators : {
					notEmpty : {
						message : '师均科研经费（万元/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s28 : {
				validators : {
					notEmpty : {
						message : '师均新增省部级科研项目数（个/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s29 : {
				validators : {
					notEmpty : {
						message : '师均企事业委托项目数（个/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s30 : {
				validators : {
					notEmpty : {
						message : '高级职称人员、技术技能大师为学生授课比例（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s31 : {
				validators : {
					notEmpty : {
						message : '学生在国家级竞赛中获得奖励数（项）不能为空'
					},
					digits: {
						message : '学生在国家级竞赛中获得奖励数（项）只能是正整数'
					}
				}
			},
			s32 : {
				validators : {
					notEmpty : {
						message : '学生在省级竞赛中获得奖励数（项）不能为空'
					},
					digits: {
						message : '学生在省级竞赛中获得奖励数（项）只能是正整数'
					}
				}
			},
			s33 : {
				validators : {
					notEmpty : {
						message : '学生初次就业率（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s34 : {
				validators : {
					notEmpty : {
						message : '学生本省就业率（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s35 : {
				validators : {
					notEmpty : {
						message : '国家级特色高水平专业数（个）不能为空'
					},
					digits: {
						message : '国家级特色高水平专业数（个）只能是正整数'
					}
				}
			},
			s36 : {
				validators : {
					notEmpty : {
						message : '国家级重点专业数（个）不能为空'
					},
					digits: {
						message : '国家级重点专业数（个）只能是正整数'
					}
				}
			},
			s37 : {
				validators : {
					notEmpty : {
						message : '国家级优质（骨干）专业数（个）不能为空'
					},
					digits: {
						message : '国家级优质（骨干）专业数（个）只能是正整数'
					}
				}
			},
			s38 : {
				validators : {
					notEmpty : {
						message : '入选“特色高水平专业（群）”数（个）不能为空'
					},
					digits: {
						message : '入选“特色高水平专业（群）”数（个）只能是正整数'
					}
				}
			}
			
		}
	})
}

function validSchoolTTForm(){
	$('#schoolTTForm').bootstrapValidator({
		message : '该值无效',
		group: '.rowGroup',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		excluded : ':disabled',
		fields : {
			s1 : {
				validators : {
					notEmpty : {
						message : '生师比（X:1）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s2 : {
				validators : {
					notEmpty : {
						message : '国家级高层次人才数（人）不能为空'
					},
					digits: {
						message : '国家级高层次人才数（人）只能是正整数'
					}
				}
			},
			s3 : {
				validators : {
					notEmpty : {
						message : '省级人才数（人）不能为空'
					},
					digits: {
						message : '省级人才数（人）只能是正整数'
					}
				}
			},
			s4 : {
				validators : {
					notEmpty : {
						message : '国家级高层次教学、研究团队数 （个）不能为空'
					},
					digits: {
						message : '国家级高层次教学、研究团队数 （个）只能是正整数'
					}
				}
			},
			s5 : {
				validators : {
					notEmpty : {
						message : '省级教学、研究团队数（个）不能为空'
					},
					digits: {
						message : '省级教学、研究团队数（个）只能是正整数'
					}
				}
			},
			s8 : {
				validators : {
					notEmpty : {
						message : '具有国（境）外学习工作经历的专任教师占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s9 : {
				validators : {
					notEmpty : {
						message : '双师型专任教师占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s10 : {
				validators : {
					notEmpty : {
						message : '企业兼职教师占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s11 : {
				validators : {
					notEmpty : {
						message : '专业教师人均企业实践时间（天/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s12 : {
				validators : {
					notEmpty : {
						message : '实践课时占比（%）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					},
					between : {
						min : 0,
						max : 100,
						message : "输入百分比为0-100之间"
					}
				}
			},
			s13 : {
				validators : {
					notEmpty : {
						message : '公开出版的校企合作教材数（种）不能为空'
					},
					digits: {
						message : '公开出版的校企合作教材数（种）只能是正整数'
					}
				}
			},
			s14 : {
				validators : {
					notEmpty : {
						message : '国家级规划教材、精品教材数（种）不能为空'
					},
					digits: {
						message : '国家级规划教材、精品教材数（种）只能是正整数'
					}
				}
			},
			s15 : {
				validators : {
					notEmpty : {
						message : '省部级规划教材、精品教材数（种）不能为空'
					},
					digits: {
						message : '省部级规划教材、精品教材数（种）只能是正整数'
					}
				}
			},
			s16 : {
				validators : {
					notEmpty : {
						message : '省部级教学资源库开发数量（个）不能为空'
					},
					digits: {
						message : '省部级教学资源库开发数量（个）只能是正整数'
					}
				}
			},
			s17 : {
				validators : {
					notEmpty : {
						message : '生均图书流通量、生均电子资源访问量（次/人）不能为空'
					},
					regexp: {
					      regexp: /^\d+(\.\d{0,2})?$/,
					      message: '请输入大于0的正数'
					}
				}
			},
			s18 : {
				validators : {
					notEmpty : {
						message : '省级以上实习实训基地数（个）不能为空'
					},
					digits: {
						message : '省级以上实习实训基地数（个）只能是正整数'
					}
				}
			},
			s19 : {
				validators : {
					notEmpty : {
						message : '产学研合作项目（基地）数（个）不能为空'
					},
					digits: {
						message : '产学研合作项目（基地）数（个）只能是正整数'
					}
				}
			}
		}
	})
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
	                    message: '法人姓名长度为2到255个字节。'
	                }
				}
			},
			lePost : {
				validators : {
					notEmpty : {
						message : '法人职务不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 255,
	                    message: '法人职务长度为2到255个字节。'
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
	                    message: '法人办公电话长度为5到20个字节。'
	                }
				}
			},
			leFax : {
				validators : {
					notEmpty : {
						message : '法人传真不能为空'
					}
				}
			},
			leEmail : {
				validators : {
					notEmpty : {
						message : '法人email不能为空'
					},
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
	                    message: '法人电话长度为5到20个字节。'
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
			conPost : {
				validators : {
					notEmpty : {
						message : '联系人职务不能为空'
					},
					stringLength: {
	                    min: 2,
	                    max: 255,
	                    message: '联系人职务长度为2到255个字节。'
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
	                    message: '联系人公电话长度为5到20个字节。'
	                }
				}
			},
			conFax : {
				validators : {
					notEmpty : {
						message : '联系人传真不能为空'
					}
				}
			},
			conEmail : {
				validators : {
					notEmpty : {
						message : 'email不能为空'
					},
					emailAddress : {
						message : "请输入合法的email。"
					}
				}
			},
			conPhone : {
				validators : {
					notEmpty : {
						message : '联系人联系方式不能为空'
					},
					stringLength: {
	                    min: 5,
	                    max: 20,
	                    message: '联系人电话长度为5到20个字节。'
	                }
				}
			}
		}
	})
}

function initFileUpload(){
	$("#file").fileinput({
        language : 'zh',
        uploadUrl : $("#isExamine").val() == "true" ? "" : getRootPath()+"/schooldata/schoolFillUploadPDF.json",
        showUpload: $("#isExamine").val() == "false", //是否显示上传按钮
        showRemove : false, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: true,//是否显示标题
        autoReplace : true,
        dropZoneEnabled: true,//是否显示拖拽区域
        minFileCount: 0,
        uploadAsync: true,
	    preferIconicPreview: true, // this will force thumbnails to display icons for following file extensions
	    previewFileIconSettings: { // configure your icon file extensions
			'doc': '<i class="fa fa-file-word-o text-primary"></i>',
			'xls': '<i class="fa fa-file-excel-o text-success"></i>',
			'ppt': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
			'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
			'txt': '<i class="fa fa-file-text-o text-info"></i>',
			'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
			'htm': '<i class="fa fa-file-code-o text-info"></i>',
			'mov': '<i class="fa fa-file-movie-o text-warning"></i>',
			'mp3': '<i class="fa fa-file-audio-o text-warning"></i>'
		},
        initialPreview:pathList,
        initialPreviewAsData: true, 
        initialPreviewConfig:initPreviewConfig,
        maxFileCount: 10,//最大上传数量
        browseOnZoneClick: true,
        browseClass:"btn btn-primary",
        msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！",
        enctype: 'multipart/form-data',
        overwriteInitial: false,//不覆盖已上传的图片
        allowedFileExtensions : [ "pdf" ],
        browseClass : "btn btn-primary", //按钮样式
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
    }).on("fileuploaded", function(e, data) {//文件上传成功的回调函数，还有其他的一些回调函数，比如上传之前...
    	// initImages();
    	initImages(1);
    });
	if($("#isExamine").val() == "true" || $("#isView").val() == "true"){
		$(".file-caption-main").hide();
	}
	
}

function initImages(flag){
	var gurl = $("#isExamine").val() == "true" ? "/score/schoolFillgetImagesById.json?id="+$("#createId").val() : "/schooldata/schoolFillgetImagesById.json"
	var surl = $("#isExamine").val() == "true" ? "/score/" : "/schooldata/";
	$.post(
		getRootPath()+gurl, 
		function(data) {
    		if(data.length > 0){
	    		$(data).each(function(index,value){
	        		pathList[index] = getRootPath()+surl+"schoolFillshowFile.json?name="+value.name;
	        		ks = {
	        				type: value.type,
	        				caption: value.sourceName, 
	        				size: value.size, 
	        				url: $("#isExamine").val() == "true"  ? "" : getRootPath()+surl+"schoolFilldeleteFile.json", 
	        				key: value.id
	    			};
	        		initPreviewConfig[index] = ks;
	    		})
	    		
    		}
    		initFileUpload();

    		//上传成功提示
			if(flag == 1){
				showInfo("您已完成当前附件上传，可继续上传或填报其他内容");
			}
		}
    );
}
