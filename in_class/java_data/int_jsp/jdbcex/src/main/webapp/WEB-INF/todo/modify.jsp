<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Todo Modify/Remove</title>
</head>
<body>
  <%-- 수정 폼 --%>
  <form id="form1" action="/todo/modify" method="post">
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
      <button type="submit">Modify</button>
    </div>
  </form>

  <%-- 삭제 폼 --%>
  <form id="form2" action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${dto.tno}" readonly>
    <div>
      <button type="submit">Remove</button>
    </div>
  </form>
</body>
</html>
