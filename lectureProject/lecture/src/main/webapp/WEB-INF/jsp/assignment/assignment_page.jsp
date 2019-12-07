<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-05-31
  Time: 오전 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>Lecture_listpage</title>

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
                <a href="Lecture_assignment" class="list-group-item active">과제</a>
                <a href="mypage_main" class="list-group-item">마이페이지</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->
        <div class="col-lg-9">

            <div class="card mt-4">
                <jsp:include page="assignment_detail.jsp" flush="false"/>
            </div>
        </div>
        <!-- /.col-lg-9 -->
        <div class="card card-outline-secondary my-4">
            <!-- /.col-lg-9 -->
        </div>
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
