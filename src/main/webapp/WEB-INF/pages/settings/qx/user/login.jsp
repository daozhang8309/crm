<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- request.getScheme() 获取协议--%>
<%-- request.getServerName() 获取服务器ip--%>
<%-- request.getServerPort() 获取服务器端口--%>
<%-- request.getContextPath() 获取项目路径--%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
<%--	使用base标签作为所用css，js 目录的前缀--%>
<%--	这种方式还有进一步改进 ，是写死状态，需要变成变量--%>
	<base href="<%=basePath%>">
<meta charset="UTF-8">
<%--	不建议使用../--%>
<%--	http://127.0.0.1:8080/crm/  使用这种形式还是太繁琐--%>
<%--<link href="http://127.0.0.1:8080/crm/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />--%>
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function () {
			//给整个浏览器加上键盘按下事件
			$(window).keydown(function (e) {  //e代表事件本身
				if (e.keyCode==13){
					//再次模拟使用一次按钮单机事件
					$("#loginBtn").click();
				}
			})
			//给登录按钮添加单击时间
			//id选择器
			$("#loginBtn").click(function () {
				//收集参数
				//这里是用户名，密码，是否记住密码
				var loginAct = $.trim($("#loginAct").val());
				var loginPwd = $.trim($("#loginPwd").val());
				var isRemPwd = $("#isRemPwd").prop("checked");

				//表单验证
				if (loginAct==""){
					alert("用户名不能为空");
					return;
				}
				if (loginPwd==""){
					alert("密码不能为空");
					return;
				}
				//发送请求
				//异步请求 ajax
				$.ajax({
					url:'settings/qx/user/login.do',   //controller方法里面的url
					data:{
						loginAct:loginAct,
						loginPwd:loginPwd,
						isRemPwd:isRemPwd
					},
					type:'post',		//以什么方式发送请求
					dataType:'json',   //返回响应信息的类型
					success:function (data) {  //处理响应信息  data用来接收后台返回的响应信息
						if (data.code=="1"){
							//登录成功，跳转页面
							//无法直接跳转，还是需要controller
							window.location.href="workbench/index.do";
						}else {
							//登录失败
							//提示信息，提示到网页的某个标签中
							$("#msg").html(data.message);
						}
					},
					beforeSend:function () {	//在ajax之前执行
						$("#msg").text("正在努力验证。。。");
					}
				})

			});
		});
	</script>
</head>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2019&nbsp;动力节点</span></div>
	</div>
	
	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>登录</h1>
			</div>
			<form action="workbench/index.html" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input class="form-control" id="loginAct" type="text" value="${cookie.loginAct.value}" placeholder="用户名">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input class="form-control" id="loginPwd" type="password" value="${cookie.loginPwd.value}" placeholder="密码">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						<label>
							<c:if test="${not empty cookie.loginAct and not empty cookie.loginPwd}">
								<input type="checkbox" id="isRemPwd" checked>
							</c:if>
							<c:if test="${empty cookie.loginAct and empty cookie.loginPwd}">
								<input type="checkbox" id="isRemPwd" >
							</c:if>
							十天内免登录
						</label>
						&nbsp;&nbsp;
						<span id="msg"></span>
					</div>
					<%-- submit 同步刷新  button 异步刷新--%>
					<button type="button" id="loginBtn" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>