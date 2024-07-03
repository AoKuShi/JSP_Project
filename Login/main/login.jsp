<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  String userId = "kth";
  String userPwd = "0000";

  String id = request.getParameter("id");
  String password = request.getParameter("password");

  if (userId.equals(id) && userPwd.equals(password)) {
    response.sendRedirect("welcomePage.jsp?id="+userId);
  } else {
    response.sendRedirect("loginPage.jsp?error=1");
  }
%>
