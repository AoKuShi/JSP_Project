<%@ page language="java" contentType="text/html; charset=UTF-8"
   import = "java.util.Arrays"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인 화면</title>
</head>
<body>
  <h1>로그인</h1>
  <%
    String error = request.getParameter("error");
    if (error != null && error.equals("1")) {
      %>
        <script>alert("아이디 혹은 비밀번호 오류")</script>
      <%
    }
  %>

  <form action="login.jsp" method="post">
    <input type="text" name="id" placeholder="아이디 입력"><br>
    <input type="password" name="password" placeholder="비밀번호 입력"><br>
    <input type="submit" value="로그인">
  </form>
</body>
</html>