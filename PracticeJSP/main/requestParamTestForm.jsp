<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Request Parameter reading practice</title>
</head>
<body>
   <h1>Client Request Parameter reading practice</h1>
   <form action = "requestParamTest.jsp" method = "post" >
      id : <input type = "text" name = "id" value = "">
          <br>
      course : <input type = "radio" name = "course" value = "1학년" checked = "checked">1학년
             <input type = "radio" name = "course" value = "2학년">2학년 
             <br>
      
      favorite : <input type = "checkbox" name = "favorite" value = "java">java
               <input type = "checkbox" name = "favorite" value = "JSP" checked = "checked">jsp
               <input type = "checkbox" name = "favorite" value = "database">database
               <br>
      self-indroduction : <textarea name = "intro" rows = "5" cols = "50"></textarea>
                     <br>
      
      <input type = "submit" value = "전송">
   </form>
</body>
</html>