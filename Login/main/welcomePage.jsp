<%@ page language="java" contentType="text/html; charset=UTF-8"
   import = "java.util.Arrays"
    pageEncoding="UTF-8"%>

<%
  String id = request.getParameter("id");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>welcome</title>
</head>
<body>
  <h1>
    <%
      if (id != null) {
        out.print(id + "님, ");
      }
    %>
    로그인 성공!</h1>
</body>
</html>