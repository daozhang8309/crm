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
    <base href="<%=basePath%>">
    <title>演示文件下载</title>

    <script type="text/javascript">
        $(function () {
            $("#fileDownLoadBtn").click(function () {

                //发送文件下载的请求
                //所有文件的下载只能发送同步请求
                window.location.href = "workbench/activity/fileDownLoad.do";
            });
        });
    </script>
</head>
<body>
<input type="button" value="下载" id="fileDownLoadBtn">
</body>
</html>
