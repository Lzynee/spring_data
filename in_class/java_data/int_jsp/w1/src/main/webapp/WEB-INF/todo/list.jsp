<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  TodoService에서 제공하는 List<TodoDTO>를
  TodoListController에서 전달 받아서 화면에 표시한다.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <h1>List Page</h1>

  <ul>
    <%-- 리스트를 반복문으로 처리 --%>
    <c:forEach var="dto" items="${ list}">  <%-- dto 단위로 데이터를 불러온다.--%>
      <li>${ dto }</li>
    </c:forEach>
  </ul>

</body>
</html>
