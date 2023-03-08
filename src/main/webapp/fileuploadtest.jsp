<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- request.getScheme() 获取协议--%>
<%-- request.getServerName() 获取服务器ip--%>
<%-- request.getServerPort() 获取服务器端口--%>
<%-- request.getContextPath() 获取项目路径--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <%--	使用base标签作为所用css，js 目录的前缀--%>
    <%--	这种方式还有进一步改进 ，是写死状态，需要变成变量--%>
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <base href="<%=basePath%>"></head>
<body>
<form action="workbench/activity/fileUpload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="myfile"><br/>
    <input type="text" name="userName"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
