
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-06-05
  Time: 오전 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8' />

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

<div>
    <div class="card mb-3">
        <div class="card-header">
            강좌 검색
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form method="post" action="/Lecture_addpage">
                <table class="display" id="search" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th align="center" width="20">ID</th>
                        <th align="center" width="150">강좌명</th>
                        <th align="center" width="60">교수명</th>
                        <th align="center" width="200">시간</th>
                        <th align="right" width="20"></th>
                       <!-- <th align="center" width="30"></th>-->
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="List" items="${lecture_list}" varStatus="status">
                        <tr id="add_lecture">
                            <td >${List.id}</td>
                            <td>${List.name}</td>
                            <td>${List.professor_id}</td>
                            <td>${List.lecture_day}</td>
                            <td><button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#myModal">
                                수강
                            </button>
                                <div class="modal" id="myModal">
                                    <div class="modal-dialog">
                                        <div class="modal-content">

                                            <!-- Modal Header -->
                                            <div class="modal-header">
                                                <h3 class="modal-title">알림!!</h3>
                                            </div>
                                            <!-- Modal body -->
                                            <div class="modal-body" style="font-size: 20px">
                                                ${List.name}강좌를 추가하시겠습니다.
                                            </div>

                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                                <button onclick="location.href='/Lecture_addPage?Lecture_id=${List.id}'" type="button" class="btn btn-success" data-dismiss="modal">강좌추가</button>
                                                <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </td>
                            <!--<td><input type="button" onclick="location.href='/Lecture_addPage?Lecture_id=${List.id}'" value="강좌추가"> </td>
                            <td><input type="submit" value="추가"/> </td>
                         onclick="location.href='/Lecture_addPage?Lecture_id='"
                         -->
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </form>

                <!--
                <a href="Lecture_addPage" class="col-lg-12" id="Result" ></a>
                -->
            </div>
        </div>
    </div>
</div>
</body>
</html>
