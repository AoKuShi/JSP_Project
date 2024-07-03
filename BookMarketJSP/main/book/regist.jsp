<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String priceStr = request.getParameter("price");
	String instockStr = request.getParameter("instock");
	
	if (title == null || author == null || publisher == null || priceStr == "" || instockStr == "") {
		response.sendRedirect("registPage.jsp");
	} else {
		out.print(priceStr);
		BookService service = new BookService(new BookDAO());
		if (service.regist(new Book(title, author, publisher, Integer.parseInt(priceStr), Integer.parseInt(instockStr)))) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("registPage.jsp");
		}
	}
%>