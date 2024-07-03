<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if (idStr == null) {
		response.sendRedirect("main.jsp");
	} else {
		BookService service = new BookService(new BookDAO());
		Book book = service.read(Integer.parseInt(idStr));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
	<h3>도서 상세 정보</h3>
	<% if (book == null) { %>
		<p>도서 정보가 없습니다.</p>
	<% } else { %>
		<ul>
			<li>아이디 : <%= book.getId() %></li>
			<li>제목 : <%= book.getTitle() %></li>
			<li>저자 : <%= book.getAuthor() %></li>
			<li>출판사 : <%= book.getPublisher() %></li>
			<li>가격 : <%= book.getPrice() %></li>
			<li>재고 : <%= book.getInstock() %></li>
		</ul>
		<br>
		<a href="modifyPage.jsp?id=<%= book.getId() %>"><button>수정</button></a>
		<a href="removePage.jsp?id=<%= book.getId() %>"><button>삭제</button></a>
		<a href="main.jsp"><button>뒤로가기</button></a>
	<% } %>
</body>
</html>
<% } %>