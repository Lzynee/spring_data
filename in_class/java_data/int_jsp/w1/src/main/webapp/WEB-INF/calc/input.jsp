<%--
  교재 p.38 JSP를 이용해서 GET/POST 처리하기
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2>1. GET 방식으로 전송하기</h2>
<%-- GET 방식인 경우 주소표시줄 출력 내용: "/calc/input.jsp?num1=${num1입력내용}&num2=${num2입력내용}" --%>
<form>
  <input type="number" name="num1">
  <input type="number" name="num2">
  <button type="submit">SEND</button>
</form>
<br><br>

<%-- POST 방식인 경우 주소표시줄 출력 내용: "/calc/calcResult.jsp" --%>
<h2>2. POST 방식으로 전송하기</h2>
<form action="/calc/makeResult" method="post">  <%-- action, method 속성 추가 --%>
  <input type="number" name="num1">
  <input type="number" name="num2">
  <button type="submit">SEND</button>
</form>

</body>
</html>
