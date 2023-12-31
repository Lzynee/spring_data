<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Todo List</title>
</head>
<body>
  <h1>Todo List</h1>
  
  <%-- Servlet Context 출력부 --%>
  <h2>${appName}</h2>
  <h2>${loginInfo}</h2>
  <h3>${loginInfo.mname}</h3>
  
  <%-- 테스트 코드 추가 : 현재 로그인한 사용자의 이름을 확인 --%>
  <h2>${loginInfo}</h2>
  <h3>${loginInfo.mname}</h3>

  <ul>
    <c:forEach items="${dtoList}" var="dto">
      <li>
        <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
        <span>${dto.title}</span>
        <span>${dto.dueDate}</span>
        <span>${dto.finished ? "DONE" : "NOT YET"}</span>
      </li>
    </c:forEach>
  </ul>

  <form action="/logout" method="post">
    <button>LOGOUT</button>
  </form>
</body>
</html>
