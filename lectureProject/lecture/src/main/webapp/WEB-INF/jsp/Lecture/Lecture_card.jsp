<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-05-31
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
        p { margin:20px 0px; }
    </style>
</head>
<body>
<br>
<h1>강의 카드</h1>
<br>
<div class="container">
    <div class="row">

        <c:forEach var="List" items="${Lecture_info}" varStatus="status">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h3>${List.name} <a href="Lecture_listpage?check=${List.id}" class="btn btn-outline-danger" style="float: right">삭제</a></h3>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${List.professor_id}교수님</h5>
                        <p class="card-text">수업 시간:${List.lecture_time}</p>
                        <p class="card-text">학점: ${List.score}</p>
                        <a href="Lecture_page?id=${List.id}" class="btn btn-outline-primary">보기</a>
                    </div>
                </div>
            </div>

        </c:forEach>



    </div>
</div>
<br>

<div>
    <dir>

    </dir>
    <div style="float: right">
        <div>
            <a href="Lecture_addPage" class="btn btn-outline-success">추가</a>
        </div>
    </div>
</div>
<br>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>