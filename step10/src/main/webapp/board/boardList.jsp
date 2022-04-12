<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = 1;
	if(request.getParameter("pg") != null)
		pg = Integer.parseInt(request.getParameter("pg"));
	
	// 목록 : 1페이지당 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	BoardDAO dao = new BoardDAO();
	List<BoardDTO> list = dao.getBoardList(startNum, endNum);
	
	// 페이징 : 3블럭
	int totalA = dao.getTotalBoard();   // 총 데이터 갯수
	int totalP = (totalA + 4) / 5;		// 총 페이지 수
	
	int startPage = (pg-1) / 3*3 + 1;
	int endPage = startPage + 2;	
	if(endPage > totalP) endPage = totalP;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	text-align: center;
}
td , th {
	height: 2em;
}
#title {
	background-color: yellow;
}
#titleNo {
	width: 4em;
	font-weight: bold;
}
#titleSub {
	width: 20em;
	font-weight: bold;
}
#titleName {
	width: 6em;
	font-weight: bold;
}
#titleDate {
	width: 8em;
	font-weight: bold;
}
#titleHit {
	width : 4em;
	font-weight: bold;
}
.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	font-weight: bold;
	text-decoration: underline;
}
</style>

<script type="text/javascript">
	function isLogin(seq) {		
		if(<%=session.getAttribute("memId") != null%>) {
			location.href="boardView.jsp?seq=" + seq + "&pg=" + <%=pg%>;
		} else {			
			alert("먼저 로그인 하세요.");
		}
	}
</script>
</head>
<body>
	<div style="width: 700px;">
		<!-- 목록보기 -->
		<div style="height: 300px;">
			<table border="1">
			<tr id="title">
				<th id="titleNo">글번호</th>
				<th id="titleSub">제목</th>
				<th id="titleName">작성자</th>
				<th id="titleDate">작성일</th>
				<th id="titleHit">조회수</th>
			</tr>
			<%for(BoardDTO dto : list) { %>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><a href="#" onclick="isLogin(<%=dto.getSeq()%>)"><%=dto.getSubject() %></a></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getLogtime() %></td>
				<td><%=dto.getHit() %></td>
			</tr>
			<%} %>
		</table>
		</div>
		<!-- 페이징 번호보기 -->
		<div style="text-align: center;">
			<% if(startPage > 3) { %>
			[<a class="paging" href="boardList.jsp?pg=<%=startPage-1%>">이전</a>]
			<% } %>
		
			<% for(int i=startPage; i<=endPage; i++) {%>
				<% if(pg == i) {%>
					[<a class="currentPaging" href="boardList.jsp?pg=<%=i %>"><%=i%></a>]
				<%} else { %>
					[<a class="paging" href="boardList.jsp?pg=<%=i %>"><%=i%></a>]
				<% } %>
			<% } %>
			
			<% if(endPage < totalP) {%>
				[<a class="paging" href="boardList.jsp?pg=<%=endPage+1%>">다음</a>]
			<% } %>
		</div>
	</div>
	<br>
	<a href="boardWriteForm.jsp">새글쓰기</a>
</body>
</html>