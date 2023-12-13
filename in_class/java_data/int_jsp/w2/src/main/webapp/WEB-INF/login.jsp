<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <%-- 에러가 발생하는 경우 처리 --%>
  <c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
  </c:if>
  
  <%-- 로그인에 필요한 아이디와 패스워드 데이터를 /login 경로로 전송한다 (post 방식). --%>
  <form action="/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
    <button type="submit">LOGIN</button>
  </form>
</body>
</html>
