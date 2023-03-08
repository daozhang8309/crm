<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <base href="<%=basePath%>">
    <meta charset="UTF-8">


    <!--  It is a good idea to bundle all CSS in one file. The same with JS -->

    <!--  JQUERY -->
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>

    <!--  BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="jquery/bootstrap_3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <!--  PAGINATION plugin -->
    <link rel="stylesheet" type="text/css" href="jquery/bs_pagination-master/css/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="jquery/bs_pagination-master/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="jquery/bs_pagination-master/localization/en.js"></script>

    <script type="text/javascript">
        $(function () {

            $("#demo_pag1").bs_pagination({
                currentPage:1,//当前页号，相当于pageNo
                rowsPerPage:10,//每页显示条数，相当于pageSize
                totalRows:1000,//总条数
                totalPages: 100,  //总页数，必填参数

                visiblePageLinks: 6,//最多可以显示的卡片数
                showGoToPage: true,
                showRowsPerPage: true,
                showRowsInfo: true,

                onChangePage: function(event,pageObj) { // returns page_num and rows_per_page after a link has clicked
                    alert(pageObj.currentPage);
                    alert(pageObj.rowsPerPage);
                },
            });

        });
    </script>
    <title>演示翻页插件</title>
</head>
<body>
<!--  Just create a div and give it an ID -->

<div id="demo_pag1"></div>
</body>
</html>
