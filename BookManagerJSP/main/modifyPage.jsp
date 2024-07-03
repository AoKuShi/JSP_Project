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
		if (book == null) {
			response.sendRedirect("main.jsp");
		} else {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 가격 수정</title>
</head>
<body>
	<h3>도서 가격 수정</h3>
	<form action="modify.jsp?id=<%= book.getId() %>" method="post">
		<input type="text" name="title" value="<%= book.getTitle() %>" placeholder="이름 입력"><br>
		<input type="text" name="author" value="<%= book.getAuthor() %>" placeholder="저자 입력"><br>
		<input type="text" name="publisher" value="<%= book.getPublisher() %>" placeholder="출판사 입력"><br>
		<input type="text" name="price" value="<%= book.getPrice() %>" placeholder="가격 입력"><br>
		<input type="text" name="instock" value="<%= book.getInstock() %>" placeholder="재고 입력"><br>
		<br>
		<input type="submit" value="수정">
		<a href="detailPage.jsp?id=<%= book.getId() %>"><input type="button" value="취소"></a>
	</form>
</body>
</html>
<%	
		}
	}
%>