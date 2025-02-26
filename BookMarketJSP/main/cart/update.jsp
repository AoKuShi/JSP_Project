<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/main/common/isLoggedIn.jsp" %>
<%
	String idStr = request.getParameter("id");
	String quanStr = request.getParameter("quantity");
	
	if (idStr == null || idStr.isEmpty() || quanStr == null || quanStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/main/common/errorPage.jsp?cartUpdateErr=1");
		return;
	}
	
	CartService service = new HJCartService(new ListCartDAO());
	if (service.update(Integer.parseInt(idStr), memberNo, Integer.parseInt(quanStr))) {
		response.sendRedirect(request.getContextPath() + "/main/cart/main.jsp");
	} else {
		response.sendRedirect(request.getContextPath() + "/main/common/errorPage.jsp?cartUpdateErr=2");
	}
		

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>

</body>
</html>