<%@ page language="java" contentType="text/html; charset=UTF-8"
   import = "java.util.Arrays"
    pageEncoding="UTF-8"%>
<%
   String id = request.getParameter("id");
   String course = request.getParameter("course");
   String[] favArr = request.getParameterValues("favorite");
   String favorite = Arrays.toString(favArr);
   String intro = request.getParameter("intro").replace("\n", "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Request Parameter reading result</title>
</head>
<body>
   <ul>
      <li>id : <%= id %></li>
      <li>course : <%= course %></li>
      
      <li>favorite : <%= favorite %></li>
      <li>self-introduction : <%= intro %></li>
   </ul>
</body>
</html>

