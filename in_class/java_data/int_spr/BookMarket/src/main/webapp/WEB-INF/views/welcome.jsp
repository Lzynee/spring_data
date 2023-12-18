<%--
  Created by IntelliJ IDEA.
  User: sec
  Date: 2023-12-18
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <title>Welcome</title>
</head>
<body>
  <nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="container">
      <div class="navbar-header">
        <a href="./home.jsp" class="navbar-brand">Home</a>
      </div>
    </div>
  </nav>
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">${greeting}</h1>
    </div>
  </div>
  <div class="container">
    <div class="container">
      <div class="text-center">
        <h3>${strapline}</h3>
      </div>
    </div>
  </div>
  <footer class="container">
    <hr>  <%-- 수평선 --%>
    <p>&copy; WebMarket</p>
  </footer>
</body>
</html>
