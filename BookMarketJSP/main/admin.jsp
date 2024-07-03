<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메뉴</title>
</head>
<body>
	<ul>
		<li><a href="<%= request.getContextPath() %>/main/member/main.jsp">회원관리</a></li>
		<li><a href="<%= request.getContextPath() %>/main/book/main.jsp">도서관리</a></li>
	</ul>
</body>
</html>