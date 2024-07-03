<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/main/common/isLoggedIn.jsp" %>
<%
	CartService service = new HJCartService(new ListCartDAO());

	String bookIdStr = request.getParameter("bookId");
	
	if (bookIdStr == null || bookIdStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/main/common/errorPage.jsp?bookIdErr=1");
		return;
	}
	
	if (service.add(new CartItem(memberNo, Integer.parseInt(bookIdStr), 1))) {
		response.sendRedirect(request.getContextPath() + "/main/cart/main.jsp");
	} else {
		response.sendRedirect(request.getContextPath() + "/main/common/errorPage.jsp?bookAddErr=1");
	}
%>