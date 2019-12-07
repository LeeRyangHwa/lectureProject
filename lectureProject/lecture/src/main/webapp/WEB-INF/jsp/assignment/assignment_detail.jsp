
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if(session.getAttribute("id")== null){
        response.sendRedirect("logout");
    }
%>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-06-03
  Time: 오후 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>assignment_detail</title>
</head>
<body>

<c:if test="${overlap!=2}">
    <div class="card-body">
        <form method="post" href="/assignment_page?assignment_id=${Assign_id}">
            <h2>참석 신청</h2>
            <div style="font-size:25px;">
                ID: ${ID}<br>
                이름: ${Name}<br>
                역할: <input type="text" name="part"/>
                <br><br>
                <div style="float: right">
                    <input type="submit" class="btn btn-outline-warning"  value="참가"/>
                </div>
            </div style>
        </form>
    </div>
</c:if>

<div class="card-header">
    <h3>과제 참석자 명단</h3>
</div>
<div class="card-body">
<table class="display" id="search" width="100%" cellspacing="0">
    <thead>
    <div>
    <tr>
        <th align="center" width="20" style="font-size: 20px;">ID</th>
        <th align="center" width="150" style="font-size: 20px;">이름</th>
        <th align="center" width="150" style="font-size: 20px;">역할</th>
        <!-- <th align="center" width="30"></th>-->
    </tr>
    </div>
    </thead>

    <c:if test="${size>-1}">
    <tbody>
    <c:forEach var="i" begin="0" end="${size}" step="1">
        <tr>
            <td>${Student_id[i]}</td>
            <td>${Student_name[i]}</td>
            <td>${Student_type[i]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </c:if>
</table>
</div>
<div>

</div>
</body>
</html>
