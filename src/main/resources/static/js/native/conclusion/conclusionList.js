/**
 * 编辑普通模板页面 author 梁雪峰
 */
$(document).ready(function() {
	/* 自定义监听器 */
	listener();
	/* 初始化 */
	init();
});

function init(){
	//初始化用户列表
	initTables();
	//初始化用户操作状态
	if($("#info").val() != ""){
		showInfo($("#info").val());
	}
}

function listener(){
	$("#btn_query").click(function(){
		$('#tb_conclusions').bootstrapTable('refresh');
	});
	
}

function initTables(){

	$('#tb_conclusions').bootstrapTable({
		url : getRootPath() + '/conclusion/conclusionList.json', // 请求后台的URL（*）
		method : 'get', // 请求方式（*）
		//toolbar : '#toolbar', // 工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : true, // 是否启用排序
		sortOrder : "asc", // 排序方式
		singleSelect : true,
		queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求 
			return { 
				limit: params.limit, // 每页要显示的数据条数 
				offset: params.offset, // 每页显示数据的开始行号 
				sort: params.sort, // 要排序的字段 
				sortOrder: params.order
			} 
		},
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 20, // 每页的记录行数（*）
		pageList : [ 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
		search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : true, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
        
		columns : [ 
			{checkbox : true}, 
			{field : "schoolData.schoolName",valign: 'middle',align: 'center',title : '学校名称',formatter: toView},
			{field : 'g1',valign: 'middle',align: 'center',title : '国家示范校、骨干校、</br>优质校成果数（个）',sortable: true,visible : false}, 
			{field : 'g2',valign: 'middle',align: 'center',title : '吉林省示范校、骨干校</br>、优质校成果数（个）',sortable: true}, 
			{field : 'g3',valign: 'middle',align: 'center',title : '国家级教育教学改革试</br>点数（个）',sortable: true,visible : false}, 
			{field : 'g4',valign: 'middle',align: 'center',title : '省级教育教学改革试点</br>数（个）',sortable: true}, 
			{field : 'g5',valign: 'middle',align: 'center',title : '国家级重点专业数（个</br>）',sortable: true,visible : false}, 
			{field : 'g6',valign: 'middle',align: 'center',title : '省级重点专业数（个）',sortable: true}, 
			{field : 'g7',valign: 'middle',align: 'center',title : '国家级财政支持的实训</br>基地数（个）',sortable: true,visible : false},
			{field : 'g8',valign: 'middle',align: 'center',title : '省级财政支持的实训基</br>地数（个）',sortable: true},
			{field : 'g9',valign: 'middle',align: 'center',title : '国家职业教育教学资源</br>库数（个）',sortable: true,visible : false},
			{field : 'g10',valign: 'middle',align: 'center',title : '全国就业创业典型数（</br>个）',sortable: true,visible : false},
			{field : 'g11',valign: 'middle',align: 'center',title : '吉林省就业创业典型数</br>（个）',sortable: true},
			{field : 'g12',valign: 'middle',align: 'center',title : '教师国家级荣誉数（个）',sortable: true,visible : false},
			{field : 'g13',valign: 'middle',align: 'center',title : '教师省级荣誉数（个）',sortable: true},
			{field : 'g14',valign: 'middle',align: 'center',title : '承办全国职业院校技能</br>大赛数（个）',sortable: true,visible : false},
			{field : 'g15',valign: 'middle',align: 'center',title : '承办吉林省职业院校技</br>能大赛数（个）',sortable: true},
			{field : 'g16',valign: 'middle',align: 'center',title : '国家级教学成果奖励数</br>（个）',sortable: true,visible : false},
			{field : 'g17',valign: 'middle',align: 'center',title : '吉林省教学成果奖励数</br>（个）',sortable: true},
			{field : 'g18',valign: 'middle',align: 'center',title : '教师全国职业院校教学</br>能力比赛获奖（含职业</br>院校信息化教学大赛）</br>数（个）',sortable: true,visible : false},
			{field : 'g19',valign: 'middle',align: 'center',title : '教师吉林省职业院校教</br>学能力比赛获奖（含职</br>业院校信息化教学大赛</br>）数（个）',sortable: true},
			{field : 'g20',valign: 'middle',align: 'center',title : '学生全国职业院校技能</br>大赛获奖数（个）',sortable: true,visible : false},
			{field : 'g21',valign: 'middle',align: 'center',title : '学生吉林省职业院校技</br>能大赛获奖数（个）',sortable: true},
			{field : 'g22',valign: 'middle',align: 'center',title : '学生中国“互联网+”大</br>学生创新创业大赛获奖</br>数（个）',sortable: true,visible : false},
			{field : 'g23',valign: 'middle',align: 'center',title : '学生吉林省“互联网+”</br>大学生创新创业大赛获</br>奖数（个）',sortable: true},
			{field : 'g24',valign: 'middle',align: 'center',title : '学生“挑战杯”全国大学</br>生课外学术科技作品竞</br>赛和中国大学生创业计</br>划竞赛获奖数（个）',sortable: true,visible : false},
			{field : 'g25',valign: 'middle',align: 'center',title : '其它国家级成果数，学校</br>须为主持单位（个）',sortable: true},
			{field : 'scoreEnd',valign: 'middle',align: 'center',title : '专家评分',sortable: true}
		]
	});
};

function toView(value, row, index){
	return "<a href='"+getRootPath()+"/conclusion/conclusionSchoolDataShow.html?id="+row.createId+"'>"+row.schoolData.schoolName+"</a>";
}
