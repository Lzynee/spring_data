<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%-- title과 dueDate를 POST 방식으로 전송한다. --%>
  <form action="/todo/register" method="post">
    <div><input type="text" name="title" placeholder="INSERT TITLE"></div>
    <div><input type="date" name="dueDate"></div>
    <div>
      <button type="reset">RESET</button>
      <button type="submit">REGISTER</button>
    </div>
  </form>
</body>
</html>
