<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/main/common/isLoggedIn.jsp" %>
<%
	CartService service = new HJCartService(new ListCartDAO());

	if (service.clear(memberNo)) {
		response.sendRedirect(request.getContextPath() + "/main/cart/main.jsp");
	} else {
		response.sendRedirect(request.getContextPath() + "/main/common/errorPage.jsp?cartClearErr=1");
	}
%>