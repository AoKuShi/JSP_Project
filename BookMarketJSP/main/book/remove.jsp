<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="book.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if (idStr == null) {
		response.sendRedirect("main.jsp");
	} else {
		BookService service = new BookService(new BookDAO());
		if (service.remove(Integer.parseInt(idStr))) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("detailPage.jsp?id=" + idStr);
		}
	}
%>