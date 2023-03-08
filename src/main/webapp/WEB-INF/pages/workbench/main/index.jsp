<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
	<img src="image/home.png" style="position: relative;top: -10px; left: -10px;"/>
</body>
</html>