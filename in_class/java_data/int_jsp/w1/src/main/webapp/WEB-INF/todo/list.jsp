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

  ${ list[0].tno } --- ${ list[0].title }
</body>
</html>
