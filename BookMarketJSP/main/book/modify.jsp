<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
 <%@ include file = "/main/common/isAdminLogged.jsp" %>

 <%
 	String idStr = request.getParameter("id");
 	String titleStr = request.getParameter("title");
 	String authorStr = request.getParameter("author");
 	String publisherStr = request.getParameter("publisher");
	String priceStr = request.getParameter("price");
	String instockStr = request.getParameter("instock");

	if (idStr == null || titleStr == null || authorStr == null || publisherStr == null || priceStr == "" || instockStr == "") {
		response.sendRedirect("main.jsp");
	} else {
		BookService service = new BookService(new BookDAO());
		Book book = null;
		try {
			book = new Book(idStr, titleStr, authorStr, publisherStr, Integer.parseInt(priceStr), Integer.parseInt(instockStr));
		} catch(Exception e) {
			response.sendRedirect("modifyPage.jsp");
			e.printStackTrace();
			return;
		}
		
		if (book == null) {
			response.sendRedirect("main.jsp");
		} else {
			if (service.edit(book)) {
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect("modifyPage.jsp");
			}
		}
	}
%>