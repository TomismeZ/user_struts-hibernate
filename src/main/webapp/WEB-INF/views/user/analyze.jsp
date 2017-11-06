<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<div class="user-analyze">
	<div class="gender-analyze">
		<h5>用户性别分析统计</h5>
		<div>
			<span></span>male
		</div>
		<canvas id="canvas" height="150" width="400"></canvas>
	</div>
	<div class="date-analyze">
		<h5>用户创建日期统计</h5>
		<div>
			<span></span>创建日期
		</div>
		<canvas id="canvas1" height="150" width="500"></canvas>
	</div>

</div>

<script type="text/javascript" src="<%=path%>/plugins/Chart.js"></script>
<script type="text/javascript">
	var ctx = new Chart(document.getElementById("canvas").getContext("2d"));
	var ctx1 = new Chart(document.getElementById("canvas1").getContext("2d"));
	var options = {
		scaleFontSize : 13,
		scaleFontColor : "#ffa45e"
	};

	// 饼状图  
	var pieChart = [ {
		value : 50,
		color : "#FF6E8F"
	}, {
		value : 30,
		color : "#40ACEF"
	},
	/*  {value: 60, color: "#ffddfb"},  */
	];
	var myPieChart = ctx.Pie(pieChart);

	// 线型图  
	var LineChart = {
		labels : [ "Ruby", "jQuery", "Java", "ASP.Net", "PHP" ],
		datasets : [ {
			fillColor : "rgba(151,249,190,0.5)",
			strokeColor : "rgba(255,255,255,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : [ 10, 20, 30, 40, 50 ]
		}, {
			fillColor : "rgba(252,147,65,0.5)",
			strokeColor : "rgba(255,255,255,1)",
			pointColor : "rgba(173,173,173,1)",
			pointStrokeColor : "#fff",
			data : [ 28, 68, 40, 19, 96 ]
		} ]
	};
	var myLineChart = ctx1.Line(LineChart, options);
</script>