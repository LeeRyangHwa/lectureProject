<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-05-31
  Time: 오전 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id= request.getParameter("user_id");
    if(id != null) {
        session.setAttribute("id", id);
    }
%>
<%
    if(session.getAttribute("id")== null){
        response.sendRedirect("logout");
    }
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>학생메인페이지</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/shop-item.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="Main_page">학생 시간표</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Main_page">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4"></h1>
            <div class="list-group">
                <a href="Lecture_listpage" class="list-group-item">강좌</a>
                <a href="Lecture_assignment" class="list-group-item">과제</a>
                <a href="mypage_main" class="list-group-item">마이페이지</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div class="card mt-4">
                <jsp:include page="time_table.jsp" flush="false"/>
            </div>
            <!-- /.card -->

            <div class="card card-outline-secondary my-4">
                <div class="card-header">
                    진행중인 과제
                </div>
                <%
                    int i=0;
                %>
            <c:if test="${size>-1}">
                <c:forEach var="i" begin="0" end="${size}" step="1">
                    <div class="card-body">
                        <h3>${lecture_nameList[i]}</h3>
                            ${assigment_list[i].type}:${assigment_list[i].name}
                        <a href="assignment_page?assignment_id=${assigment_list[i].id}" style="float: right" class="btn btn-success">참여</a>
                        <br>
                        <small class="text-muted">${assigment_list[i].start_date} ~ ${assigment_list[i].end_date}</small>
                        <hr>
                    </div>
                    <% i++; %>
                </c:forEach>
            </c:if>
            </div>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">GeonYeong&RyangHwa &copy; Student management 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
