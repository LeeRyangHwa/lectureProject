<%@ page import="java.lang.reflect.Array" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-06-03
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="card card-outline-secondary my-4">
    <div class="card-header">
        진행중인 과제
    </div>

    <c:if test="${size>-1}">
    <c:forEach var="i" begin="0" end="${size}" step="1">
    <div class="card-body">
        <h3>${lecture_nameList[i]}</h3>
            ${assigment_list[i].type}:${assigment_list[i].name}
        <a href="assignment_page?assignment_id=${assigment_list[i].id}" style="float: right" class="btn btn-success">확인</a>
        <br>
        <small class="text-muted">${assigment_list[i].start_date} ~ ${assigment_list[i].end_date}</small>
        <hr>
    </div>

    </c:forEach>
    </c:if>
</div>
</body>
</html>
