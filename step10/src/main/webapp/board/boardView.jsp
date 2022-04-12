<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	BoardDAO dao = new BoardDAO();
	// 조회수 증가
	dao.updateHit(seq);
	// 상세보기 데이터
	BoardDTO dto = dao.boardView(seq); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3">
				<font size="5"><%=dto.getSubject() %></font>
			</td>			
		</tr>
		<tr align="center">
			<td width="150">글번호 : <%=dto.getSeq() %></td>
			<td width="150">작성자 : <%=dto.getName() %></td>
			<td width="150">조회수 : <%=dto.getHit() %></td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top"><pre>
				<%=dto.getContent() %></pre></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
	<!-- 글수정, 글삭제 버튼은 글쓴이에게만 표시함 -->
<% if(session.getAttribute("memId").equals(dto.getId())) { %>
	<input type="button" value="수정">
	<input type="button" value="삭제" onclick="location.href='boardDelete.jsp?seq=<%=seq%>&pg=<%=pg%>'">	
<% } %>		
</body>
</html>




