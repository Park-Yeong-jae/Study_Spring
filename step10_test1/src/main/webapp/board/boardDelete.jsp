<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// db
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardDelete(seq);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   <% if(flag > 0) { %> 
      alert("삭제 성공");
      location.href = "boardList.jsp?pg=<%=pg%>";
   <% } else { %>
      alert("삭제 실패");
      location.href = "boardView.jsp?seq=" + <%=seq%> + "&pg=" + <%=pg%>;
   <% } %>
</script>
</head>
<body>

</body>
</html>