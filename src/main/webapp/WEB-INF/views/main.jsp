<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	background-color: red;
	overflow: hidden;
	margin: 0;
}

body {
	display: flex;
	flex-direction: column;
}

#headerPanel {
	flex-basis: 60px;
	flex-shrink: 0;
	background-color: #2A3542;
	position: relative;
	/* border-bottom: 1px solid red; */
	display: flex;
}

#contentPanel {
	flex-grow: 1;
	display: flex;
	flex-direction: row;
}

/**
top.jsp
**/
#headerPanel .logo-panel{
	flex-basis: 300px;
}

#headerPanel .logo-panel h5{
	color: white;
	font-size: 24px;
	margin: 0;
	line-height: 60px;
	position: absolute;
	left: 50px;
	cursor: pointer;
}

#headerPanel .menu-panel{
	flex-grow: 1;
	display: flex;
	justify-content: flex-end;
	align-items: center;
	margin: 0 10px;
}

 #headerPanel .menu-panel .userinfo {
      	
        padding: 6px 18px 6px 6px;
        background:url(../images/userinfoarrow.png) no-repeat right center;
       /*  border-radius: 2px; */
       /*  width:43%; 
        position:absolute;
        right:0;
        top:10px;    */  
       /*  border-bottom: 1px solid #445775;  */
      /*   box-shadow: inset 1px 1px 2px #2b384e; */
        cursor: pointer;
        border: 0;
    }

 #headerPanel .menu-panel .changetheme {
        position: absolute;
        left: 10px;
        bottom: 10px;
        font-size: 11px;
    }

  #headerPanel .menu-panel .changetheme a {
        display: inline-block;
        margin-top: 5px;
        width: 15px;
        height: 15px;
        cursor: pointer;
    }

 #headerPanel .menu-panel .changetheme a.default {
        background: #FB9337;
    }

  #headerPanel .menu-panel .changetheme a.blueline {
        background: #319cff;
    }

   #headerPanel .menu-panel .changetheme a.greenline {
        background: #78ce07;
    }

   #headerPanel .menu-panel .changetheme a.contrast {
        background: #ff4800;
    }

   #headerPanel .menu-panel .changetheme a.custombg {
        background: #666;
    }

   #headerPanel .menu-panel .userinfo:hover {
        /* background-color: #2d3b53; */
    }

   #headerPanel .menu-panel h4, #top-panel .menu-panel span {

        background: transparent;
        border: 0;
        margin: 0;
        padding: 0;
        vertical-align: baseline;
        font-weight: normal;
    }

    #headerPanel .menu-panel ul {
        margin: 0;
        padding: 0;
    }

   #headerPanel .menu-panel .userinfo img {
        border: 1px solid #b9c1ce;
        vertical-align: middle;
    }

  #headerPanel .menu-panel .userinfo span {
        color: #b9c2cf;
        display: inline-block;
        padding: 0 5px;
    }

   #headerPanel .menu-panel .userinfodrop {
        padding: 10px;
        min-width: 300px;
        position: absolute;
        top: 48px;
        right: 0;
        display: none;
        border-radius: 10px;
        background: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        z-index: 200;
    }

   #headerPanel .menu-panel .userinfodrop .avatar {
        float: left;
    }

   #headerPanel .menu-panel .userdata {
        margin-left: 105px;
    }

   #headerPanel .menu-panel .userdata h4 {

        color: #2d3c54;
        display: inline-block;
    }

   #headerPanel .menu-panel .userdata .phone-number {
        color: #999;
        font-size: 11px;
        display: inline-block;
    }

   #headerPanel .menu-panel .userdata ul {
        list-style: none;
        margin-top: 10px;
    }

   #headerPanel .menu-panel .userdata ul li {
        display: block;
        margin-bottom: 1px;
    }

   #headerPanel .menu-panel .userdata ul li:last-child {
        margin-bottom: 0;
    }

   #headerPanel .menu-panel .userdata ul li a {
        display: block;
        padding: 5px;
        background: #f7f7f7;
        border-radius: 2px;
        text-decoration: none;
        color: black;
        font-size: 12px;
    }

   #headerPanel .menu-panel .userdata ul li a:hover {
        background: #fb9337;
        color: #fff;
    }
    
    
/**
内容区
**/    
#contentPanel .left-panel {
	flex-grow: 1;
	min-width: 150px;
	max-width: 150px;
	background-color: #F0F0F0;
}

#contentPanel .right-panel {
	flex-grow: 1;
	background-color: #FFFFFF;
	display: flex;
	flex-direction: column;
}
/**
left.jsp，style代码
**/
#contentPanel .left-panel ul {
	padding: 0;
	margin: 0;
	list-style: none;
}

#contentPanel .left-panel ul li {
	height: 40px;
	line-height: 40px;
	padding-left: 30px;
	cursor: pointer;
	border-bottom: 1px solid grey;
}

#contentPanel .left-panel ul li a {
	text-decoration: none;
	color: #000000;
}

#contentPanel .left-panel ul li:hover, #contentPanel .left-panel ul li.active
	{
	background-color: #CCCCCC;
	color: white;
}
/**
list.jsp，CSS样式
**/
#contentPanel .right-panel .search,
#contentPanel .right-panel .header{
	flex-grow: 1;
	min-height: 60px;
	max-height: 60px;
}
#contentPanel .right-panel .user-list,
#contentPanel .right-panel .user-form{
flex-grow: 1;
}
#contentPanel .right-panel .search .input-group{
	margin: 20px 0 20px 30px;
	width: calc(100%-20px);
}
#contentPanel .right-panel .search .input-group button{
	margin-left: 5px;
	border: none;
	width: 80px;
	height:25px;
	background-color: #F0F0F0;
}
#contentPanel .right-panel .tab,
#contentPanel .right-panel form{
	margin:15px;
	width: 98%;
	border-collapse: collapse;
}
#contentPanel .right-panel .tab thead{
	background-color: #F1F1F1;
}
#contentPanel .right-panel .tab th,
#contentPanel .right-panel .tab td{
	border: 1px solid #E4E4E4;
}
/**
form.jsp，CSS样式
**/
#contentPanel .right-panel .header{
	text-align: center;
}
#contentPanel .right-panel .user-form .input-group{
	width: 100%;
	text-align: center;
	height: 30px;
	line-height: 30px;
	margin-bottom: 5%;
}
#contentPanel .right-panel .user-form .input-group .input{
	width: 90%;
	height: 21px;
	border: 1px solid black;
	font-size: 15px;
	padding-left: 10px;
	margin-top: 10px;
}
#contentPanel .right-panel .user-form .input-group .input-content{
	width: 70%;
	/*对于外部其他元素是行内元素，对于内部是块级元素*/
	display: inline-block;
	text-align: left;
}
#contentPanel .right-panel .user-form .button-group {
	flex-grow: 1;
	min-height: 45px;
	max-height: 45px;
	border-top: 1px solid red;
	text-align: center;
}

#contentPanel .right-panel .user-form .button-group button {
	margin: 10px;
	border: 1px solid grey;
	background-color: white;
	width: 60px;
	float: right;
}
#contentPanel .right-panel .user-list .footer{
width:-moz-calc(100% - 8px);
	width:-webkit-calc(100% - 8px);
	width:calc(100%-8px);
	margin:0;
	padding:0;
	height: 80px;
	text-align: right;
}
/**
analyze.jsp（用户分析），CSS样式
**/
#contentPanel .right-panel .user-analyze{
	flex-grow: 1;
	position: relative;
}
#contentPanel .right-panel .user-analyze .gender-analyze{
	position: absolute;
	left: 20px;
	top:20px;
}
#contentPanel .right-panel .user-analyze .date-analyze{
	position: absolute;
	right: 50px;
	top:20px;
}
</style>
</head>
<body>
	<div id="headerPanel">
	
	</div>
	<div id="contentPanel">
		<div class="left-panel"></div>
		<div class="right-panel"></div>
	</div>
	<script src="<%=path%>/plugins/jquery2.1.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		var $contentPanel = $("#contentPanel");
		var $topPanel=$("#headerPanel");
		var $leftPanel=$(".left-panel");
		var $rightPanel=$(".right-panel");
		//加载头部列表
		$topPanel.load("common/top.jsp");
		//加载列表
		$leftPanel.load("common/left.jsp",function(){
			var $parent = $(this);
			
			//点击
			$parent.find(".left-item").on("click", function(e) {
				var $this = $(this);

				//高亮处理
				$parent.find(".left-item").removeClass("active");
				$this.addClass("active");
				//使用SPA，在一个URL加载两个界面
				//阻止a标签原有的默认事件
				e.preventDefault();
				//得到a标签href属性的值
				var pageRef = $this.find("a").prop("href");
				//JQuery load页面
				$rightPanel.load(pageRef);
			}).first().click();
		});
	</script>
</body>
</html>