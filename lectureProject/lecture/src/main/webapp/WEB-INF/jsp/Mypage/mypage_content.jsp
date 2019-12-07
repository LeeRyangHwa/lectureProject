<%--
  Created by IntelliJ IDEA.
  User: dlfid
  Date: 2019-06-03
  Time: 오후 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="card">
    <div class="card-header">
        <h1>회원정보</h1>

    </div>
    <div class="card-body" style="font-size:20px;">
        <form method="post" action="/mypage_main">
            <h2>아이디</h2>${studentinfo[0]}
            <h2>이름</h2><input type="text" name="name" value="${studentinfo[1]}"/>
            <h2>전화번호</h2><input type="text" name="phone" value="${studentinfo[3]}"/>
            <h2>이메일</h2><input type="text" name="email" value="${studentinfo[2]}"/>
            <br><br>
            <div style="float: right">
                <input type="submit" class="btn btn-outline-warning" value="편집"/>
                <input type="reset" class="btn btn-outline-secondary" value="취소"/>
            </div>
        </form>

    </div>
</div>
</body>
</html>
