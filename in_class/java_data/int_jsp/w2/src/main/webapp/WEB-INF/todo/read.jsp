<%--
  Created by IntelliJ IDEA.
  User: sec
  Date: 2023-12-13
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Todo Read</title>
</head>
<body>
  <div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
  </div>
  <div>
    <input type="text" name="title" value="${dto.title}" readonly>
  </div>
  <div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
  </div>
  <div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}
           readonly>
  </div>
  <div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>  <%-- 수정/삭제 기능으로 이동 --%>
    <a href="/todo/list">List</a>  <%-- 목록으로 이동 --%>
  </div>
</body>
</html>