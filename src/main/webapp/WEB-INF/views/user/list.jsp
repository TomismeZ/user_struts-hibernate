<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<link type="text/css" rel="stylesheet" href="<%=path%>/plugins/bootstrap.min.css"/> 
<div class="search">
	<div class="input-group">
	<label class="input-label">用户名：</label> <label class="input-content">
		<input type="text" class="input" name="account.userName">
	</label>
	 <label class="input-button"><button>查询</button></label>
	</div>
	
</div>
<div class="user-list">
	<table class="tab">
		<thead>
			<th>编号</th>
			<th>用户名称</th>
			<th>邮箱</th>
			<th>性别</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>操作</th>
		</thead>
		<tbody>
		<c:forEach items="${pageBean.list}" var="user">

			<tr data-id="${user.id }">
				<td><input type="checkbox" name="checkbox"> 轻实训</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				<td>${user.gender }</td>
				<td>${user.creatTime }</td>
				<td>${user.updateTime }</td>
				<td><a href="toUser" data-id="${user.id }">编辑</a> <a
						href="deleteUser" data-id="${user.id }">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="footer">
		<font size="3">共<font color="red">${pageBean.totalPage }</font>页
		</font>&nbsp;&nbsp; <font size="3">共<font color="red">${pageBean.allRows }</font>条记录
		</font><br> 
		<input type="hidden"
			data-currentpage="${pageBean.currentPage }"> 
			<input
			type="hidden" data-totalpages="${pageBean.totalPage }">

		<ul class="pagination" id="pagination1"></ul>
	</div>
</div>
<!-- 引入外部脚本 -->
<script src="<%=path%>/plugins/jqPaginator.js"></script>
<script type="text/javascript">

var $search=$rightPanel.find(".search");
var $manageClass=$rightPanel.find(".user-list");

//Jquery分页插件用到时的变量
var $inputFirst = $manageClass.find(".footer").find("input:first");
var $inputLast = $manageClass.find(".footer").find("input:last");
var totalPage = $inputLast.data("totalpages");
var currentPage = $inputFirst.data("currentpage");
console.log("currentPage:"+currentPage);

var $table = $rightPanel.find("table");
//同一行上删除当前选中账户
var $operator = $table.find("tbody").find("tr");

/**
 * 通过用户名查询
 */
 $search.find(".input-group").find("button").on("click",function(){
	var username= $search.find(".input-group").find("input[type='text']").val();
	if(!$.trim(username)){
		alert("用户名不能为空！");
	}else{
		/**
		实现异步刷新，
		**/
		/*  $.ajax({
	        cache: true,
	        type: "POST",
	        url:"findNameUser",
	        data:{
	        	"user.name" : username
	        },
	        async: true,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	$rightPanel.load(findAllInfo);
	        }
	    });  */
		$rightPanel.load("findNameUser",{"user.name" : username});
	}
 });
/**
 * 实现全选功能
 */
$table.find("thead").find("th:first").on("click", function() {
	// 获取列表中所有的checkbox
	var checkboxItems = $table.find("input[name='checkbox']");

	// 获取列表中选中的checkBox
	var checkedboxItems = $table.find("input[name='checkbox']:checked");

	// 如果两个列表的数量相等，表示所有的checkbox都被选中，则反选
	// 反之，则全选
	var isChecked = checkboxItems.length === checkedboxItems.length;

	// 去两个列表长度判断的反值
	checkboxItems.prop("checked", !isChecked);
});

/**
 * 选中一行就可以选中复选框，除了第一个和最后一个td
 */
$table.find("tbody").find("tr td:not(:first-child,:last-child)").on(
		"click", function() {
			var $this = $(this).parent();
			var nowItem = $this.find("input[name='checkbox']");
			// 获取当前行CheckBox的状态值
			var isChecked = nowItem.prop("checked");

			// 最新的状态值只需要与当前状态值相反即可
			nowItem.prop("checked", !isChecked);
		});
		
//同一行上删除当前选中账户
$table.find("tbody").find("tr:odd").css("background-color", "#F0F0F0");
$operator.find("a:last").on("click", function(e) {
	var $this = $(this);
	
	//阻止a标签原有的默认事件
	e.preventDefault();

	var ckbs = $operator.find("input[name='checkbox']:checked");
	var id=$this.data("id");
	var trId = ckbs.parent().parent().data("id");
	console.log("id:" + id);
	console.log("trId:" + trId);
	//得到a标签href属性的值
	var pageRef = $this.prop("href");
	console.log(pageRef);
	console.log("ckbsValue:" + ckbs.val());
	if(trId!=id){
		alert("要删除指定行，需要选中当前的复选框！");
		return;
	} else {
		if (confirm("确定要删除选中项？")) {
			
			/**
			实现异步刷新，
			**/
			/* $.ajax({
		        cache: true,
		        type: "POST",
		        url:pageRef,
		        data:{
		        	id : id
		        },
		        async: true,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		        	$rightPanel.load(findAllInfo);
		        }
		    }); */
		    $rightPanel.load(pageRef,{id:id})
		}
	}
});

//编辑该账户
//同一行上编辑当前选中账户

$operator.find("a:first").on("click", function(e) {
	var $this = $(this);
	
	//阻止a标签原有的默认事件
	e.preventDefault();

	var ckbs = $operator.find("input[name='checkbox']:checked");
	var id=$this.data("id");
	var trId = ckbs.parent().parent().data("id");
	console.log("id:" + id);
	console.log("trId:" + trId);
	//得到a标签href属性的值
	var pageRef = $this.prop("href");
	console.log(pageRef);
	console.log("ckbsValue:" + ckbs.val());
	if(trId!=id){
		alert("要编辑指定行，需要选中当前的复选框！");
		return;
	} else {
		if (confirm("确定要编辑选中项？")) {
			/* ckbs.parent().parent().remove(); */
			$rightPanel.load(pageRef, {
				//左边是Action里的值，右边是js定义的变量
				id: id
			});
		}
	}
});
/**
 * jQuery 分页插件
 */

$.jqPaginator('#pagination1',{
					totalPages : totalPage,
					visiblePages : 8,
					currentPage : currentPage,
					first : '<li class="first"><a href="javascript:;">First</a></li>',
					prev : '<li class="prev"><a href="javascript:;" data-page="${pageBean.currentPage - 1 }">Previous</a></li>',
					next : '<li class="next"><a href="javascript:;" data-page="${pageBean.currentPage + 1 }">Next</a></li>',
					last : '<li class="last"><a href="javascript:;" data-page="${pageBean.totalPage }">Last</a></li>',
					page : '<li class="page"><a href="javascript:;" data-page="{{page}}">{{page}}</a></li>',
				/* onPageChange : function(num, type) {
					$('font').text(type + '：' + num);
				} */
				});
/**
实现分页（超链接跳转功能）模块
**/
$manageClass.find(".footer").find("a").on(
		"click", function(e) {
			
			var $this = $(this);		
			var page = $this.data("page");

			console.log(page);
			//阻止a标签原有的默认事件
			e.preventDefault();
			//得到a标签href属性的值
			/* var pageRef = $this.prop("href"); */
			var pageRef="findUser";
			$rightPanel.load(pageRef, {
				page : page
			});

		});
</script>
