<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-06-02
  Time: 오후 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecture_detail</title>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.5/css/jquery.dataTables.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>


    <script type="text/javascript" class="init">
        jQuery(function($){
            $("#search").DataTable();
        });
    </script>
</head>
<body>

<div class="card card-outline-secondary my-4">
    <div class="card-header">
        강의일정
    </div>
    <table class="display" id="search" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th align="center" width="20">일정</th>
            <th align="center" width="5"></th>


            <!-- <th align="center" width="30"></th>-->
        </tr>
        </thead>
        <tbody>
        <c:forEach var="List" items="${lecture_details}" varStatus="status">
            <tr id="add_lecture">
                <td>${List.lecture_day}</td>
                <c:if test="${List.canceled == 1}">
                    <td bgcolor="red" align="center">휴강</td>
                </c:if>
                <c:if test="${List.canceled == 0}">
                    <td align="center">&nbsp;</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
