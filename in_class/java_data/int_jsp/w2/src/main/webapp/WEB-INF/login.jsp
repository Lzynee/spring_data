<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%-- 로그인에 필요한 아이디와 패스워드 데이터를 /login 경로로 전송한다 (post 방식). --%>
  <form action="/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpx">
    <button type="submit">LOGIN</button>
  </form>
</body>
</html>
