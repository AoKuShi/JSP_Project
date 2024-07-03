<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <a href="<%= request.getContextPath() %>/main/index.jsp"><button>Home</button></a>
    
<%	if (session.getAttribute("MemberId") != null) { %>
	<a href="<%= request.getContextPath() %>/main/member/logout.jsp"><button>로그아웃</button></a>
	<a href="<%= request.getContextPath() %>/main/member/detailPage.jsp?no=<%= (Integer)session.getAttribute("MemberNo") %>"><button>My Page</button></a>
	<a href="<%= request.getContextPath() %>/main/cart/main.jsp"><button>장바구니</button></a>
<%	} else if (session.getAttribute("AdminId") != null){ %>
	<a href="<%= request.getContextPath() %>/main/admin/main.jsp"><button>관리자 Home</button></a>
	<a href="<%= request.getContextPath() %>/main/member/logout.jsp"><button>로그아웃</button></a>

<%	} else { %>
	<a href="<%= request.getContextPath() %>/main/member/loginPage.jsp"><button>로그인</button></a>
	<a href="<%= request.getContextPath() %>/main/member/joinPage.jsp"><button>회원가입</button></a>
<% } %>
	
	<h2>온라인 서점</h2>
	<hr>