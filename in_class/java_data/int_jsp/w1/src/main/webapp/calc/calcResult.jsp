<%--
  교재 p.38 JSP를 이용해서 GET/POST 처리하기
  input.jsp에서 전달되는 num1/num2를 받아서 처리한다.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%-- 출력 내용:
  NUM1 ${input.jsp의 num1 필드에 입력한 값}
  NUM2 ${input.jsp의 num2 필드에 입력한 값}
  SUM ${NUM1으로 받은 값과 NUM2로 받은 값의 합}
  --%>
  <h1>NUM1 ${ param.num1 }</h1>
  <h1>NUM2 ${ param.num2 }</h1>
  
  <h1>SUM ${ Integer.parseInt(param.num1) + Integer.parseInt(param.num2) }</h1>

</body>
</html>
