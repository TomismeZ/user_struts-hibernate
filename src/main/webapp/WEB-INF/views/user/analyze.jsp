<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
%>
<div id="right" class="right" style="display: flex; margin-top: 50px;">
	<div style="flex-basis:300px;">
		<canvas id="userGenderChartCanvas"></canvas>
	</div>
	<div style="width: 500px; height: 450px; display: flex; justify-content: center;	">
		<canvas id="userCreateChartCanvas"></canvas>
	</div>
</div>

<script type="text/javascript" src="<%=path%>/plugins/Chart.min.js"></script>
<script type="text/javascript">
$(function() {
    resizeWindow();

    // 浏览器窗口大小调整时，触发 resize 事件，之后重新调整界面高度
    $(window).resize(function() {
        resizeWindow();
    });
})

function resizeWindow() {
    // 浏览器窗口高度 - header高度 = 内容区高度
    var contentHeight = $(window).height() - 80;
    $("#left").height(contentHeight);
    $("#right").height(contentHeight);
}
</script>
<script type="text/javascript">
// 用户性别统计参数（饼状图）
var userGenderChartConfig = {
    type : 'pie',
    data : {
        labels : ${userGenderData.names},
        datasets : [ {
            data : ${userGenderData.values},
            backgroundColor : [ "#FF6384", "#36A2EB" ]
        } ]
    },
    options : {
        title : {
            display : true,
            text : '用户性别分布统计'
        },
        responsive : true
    }
};

// 用户创建日期统计参数（折线图）
var userCreateChartConfig = {
    type : 'line',
    data : {
        labels : ${userCreateData.names},
        datasets : [ {
            label: "创建日期",
            fill: false,
            data : ${userCreateData.values}
        } ]
    },
    options : {
        title : {
            display : true,
            text : '用户创建日期统计'
        },
        responsive : true
    }
};

$(function() {
    // 生成用户性别统计图
    var userGenderChartCtx = document.getElementById("userGenderChartCanvas").getContext("2d");
    var  userGenderChartCanvas = new Chart(userGenderChartCtx, userGenderChartConfig);
    
    // 生成用户创建日期统计图            
    var userCreateChartCtx = document.getElementById("userCreateChartCanvas").getContext("2d");
    var  userCreateChartCanvas = new Chart(userCreateChartCtx, userCreateChartConfig);
});
</script>