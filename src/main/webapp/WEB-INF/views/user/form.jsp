<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<h3>新增&编辑用户信息</h3>
</div>
<div class="user-form">
	<c:if test="${user==null }">
		<form action="saveUser" method="post">

			<div class="input-group">
				<label class="input-label">用户名称：</label> <label
					class="input-content"> <input class="input" type="text"
					name="user.name" placeholder="请输入您的用户名！" minlength="2"
					maxlength="20" autofocus="true" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">登陆密码：</label> <label
					class="input-content"> <input class="input" type="password"
					name="user.password" placeholder="请输入您的密码" minlength="6"
					maxlength="20" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">重复密码：</label> <label
					class="input-content"> <input class="input" type="password"
					name="user.passwordAgain" placeholder="请输入您的确认密码" minlength="6"
					maxlength="20" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">电子邮箱：</label> <label
					class="input-content"> <input class="input" type="email"
					name="user.email" placeholder="请输入您的邮箱" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">性 别：</label> <label class="input-content">
					<input type="radio" name="user.gender" value="male" checked>男
					<input type="radio" name="user.gender" value="female">女

				</label>
			</div>
			<div class="button-group">
				<button>保存</button>
				<button type="reset">重置</button>
				<button type="button">返回</button>
			</div>
		</form>
	</c:if>
	<c:if test="${user != null }">
		<form action="saveUser" method="post"
			onsubmit="return checkInput(this)">

			<div class="input-group">
				<label class="input-label">用户名称：</label> <label
					class="input-content"> <input class="input" type="text"
					name="user.name" value="${user.name }"
					placeholder="请输入您的用户名！" minlength="2" maxlength="20"
					autofocus="true" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				<label class="input-label">登陆密码：</label> <label
					class="input-content"> <input class="input" type="password"
					name="user.password" value="${user.password }"
					placeholder="请输入您的密码" minlength="6" maxlength="20" required>
					<span></span>
				</label>
			</div>

			<div class="input-group">
				<label class="input-label">电子邮箱：</label> <label
					class="input-content"> <input class="input" type="email"
					name="user.email" value="${user.email }"
					placeholder="请输入您的邮箱" required> <span></span>
				</label>
			</div>
			<div class="input-group">
				
				<label class="input-label">性 别：</label> <label class="input-content">
					
				<c:choose>
					<c:when test="${user.gender eq male}">
					<input type="radio" name="user.gender" value="male" checked>男
					<input type="radio" name="user.gender" value="female">女
					</c:when>
					<c:otherwise>
					<c:choose>
					<c:when test="${user.gender eq male}">
					<input type="radio" name="user.gender" value="male">男
					<input type="radio" name="user.gender" value="female" checked>女
					</c:when>
				</c:choose>
					</c:otherwise>
				</c:choose>
				</label>
			</div>
			<div class="button-group">
				<button>保存</button>
				<button type="reset">重置</button>
				<button type="button">返回</button>
			</div>
			<input type="hidden" name="user.id" value="${user.id }">
		</form>
	</c:if>
</div>
<script type="text/javascript">
var $form=$rightPanel.find(".user-form").find("form");
$form.on("submit",function(e){
	//阻止原标签原有的默认事件
	 e.preventDefault();
	 //得到a标签href属性的值
    var pageRef=$(this).prop("action");
	 console.log(pageRef);
	 $rightPanel.load(pageRef,$form.serialize());
	/*  $.ajax({
	        cache: true,
	        type: "POST",
	        url:$form.prop("action"),
	        data:$form.serialize(),// 你的formid
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	$rightPanel.load(findUser);
	        }
	    }); */
});
</script>