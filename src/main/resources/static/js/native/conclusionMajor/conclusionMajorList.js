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
		$('#tb_majorConclusions').bootstrapTable('refresh');
	});
	
}

//初始化展示表
function initTables(){
	$('#tb_majorConclusions').bootstrapTable({
		url : getRootPath() + '/conclusion/majorConclusionList.json', // 请求后台的URL（*）
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
				sortOrder: params.order,
				t1: $("#t1").val(),
				t2: $("#t2").val()
			} 
		},
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
		search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		// height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : true, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		// theadClasses: "thead-blue",//这里设置表头样式
		// classes: "table table-bordered table-striped table-sm table-dark",
		// fixedColumns: true,
		// fixedNumber: 6,
		columns : [ 
			{checkbox : true},
			{field : 't22',title : '<br><br>申报学校<br><br><br>',valign: 'middle',align: 'center'},
			{field : 't1',title : '专业（群）名称',valign: 'middle',align: 'center',formatter:toView},
			{field : 't2',title : '专业所属大类',valign: 'middle',align: 'center'},
			// {field : 't3',title : '龙头专业代码',valign: 'middle',align: 'center'},
			{field : 't4',title : '所在院（系）',valign: 'middle',align: 'center'},
			{field : 'scoreEnd',title : '得分',valign: 'middle',align: 'center',
				formatter : function (value, row, index) {
					if(value != null){
						return value;
					}else {
						return "未评分";
					}
				}
			},
			{field : 'n1',title : '专业在校生数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n2',title : '2017年<br>专业<br>招生人数',valign: 'middle',align: 'center',sortable: true,visible : true,class: ''},
			{field : 'n3',title : '2018年<br>专业<br>招生人数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n4',title : '2019年<br>专业<br>招生人数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n5',title : '2017年<br>毕业生数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n6',title : '2018年<br>毕业生数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n7',title : '2019年<br>毕业生数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n8',title : '2018届<br>毕业生<br>年底就业率（%）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n9',title : '2018届<br>毕业生<br>用人单位<br>满意或基本<br>满意比例（%）',valign: 'middle',align: 'center',sortable: true,visible : true,width:200},
			{field : 'n10',title : '校内专任<br>教师数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n11',title : '专任教师双师<br>素质比例（%）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n12',title : '校内专任教师<br>高级职称人数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n13',title : '专任教师研究生<br>以上学历<br>人数比例（%）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n14',title : '2018-2019<br>学年兼职教师总数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n15',title : '兼职教师人数<br>占专业课教师<br>总数的比例（%）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n16',title : '校内实训<br>基地数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n17',title : '校内实训<br>基地工位数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n18',title : '校内实训基地生均<br>设备值（万元/生）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n19',title : '2018-2019学年<br>校内实训基地<br>使用频率（人时）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n20',title : '校外实习<br>实训基地数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n21',title : '2018-2019学年<br>校外实习实训基地<br>接受半年顶岗<br>实习学生数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n22',title : '校外实习实训基地接收<br>2019届毕业生就业数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n23',title : '本专业合作<br>企业总数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n24',title : '本专业合作企业<br>订单培养总数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n25',title : '本专业合作企业<br>共同开发课程总数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n26',title : '本专业合作企业<br>支持学校兼职教师总数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n27',title : '合作企业对<br>本专业准捐赠设备总值（万元）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n28',title : '合作企业对<br>本专业捐赠设备总值（万元）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n29',title : '本专业为<br>企业培训员工总数（人天）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n30',title : '骨干专业<br>国家级现代<br>学徒制试点项目数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n31',title : '骨干专业<br>省级现代<br>学徒制试点项目数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n32',title : '近两届骨干专业<br>国家级教学成果奖数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n33',title : '近两届骨干专业<br>省级教学成果奖数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n34',title : '专业群学生<br>国赛获奖数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n35',title : '专业群学生<br>省赛获奖数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n36',title : '"专业群教师队伍<br>建设成果数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n37',title : '专业群三年累计<br>社会培训和鉴定人数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n38',title : '专业群三年累计<br>社会培训和鉴定人数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n39',title : '省级科研成果、<br>论文与专利数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n40',title : '骨干专业<br>在校生规模',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n41',title : '专业（群）实训基地<br>建设成果数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n42',title : '专业群服务“一带一路”战略的<br>国际交流与合作项目数',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n43',title : '专业群建设各级<br>专项资金投入（单位：万元）',valign: 'middle',align: 'center',sortable: true,visible : true},
			{field : 'n44',title : '其他省级以上<br>标志性成果数',valign: 'middle',align: 'center',sortable: true,visible : true},
		]
	});
};

function toView(value, row, index){
	// console.log(row);
	return "<a href='"+getRootPath()+"/conclusion/conclusionMajorShow.html?majorId="+row.majorid+"'>"+row.t1+"</a>";
}

//表格展示样式
function toShow(value, row, index){
	// console.log(index);
	// console.log(value);
	// console.log(row);
	return value;
	// return "<a href='"+getRootPath()+"/conclusion/conclusionMajorShow.html?majorId="+row.majorid+"'>"+row.t1+"</a>";
}


