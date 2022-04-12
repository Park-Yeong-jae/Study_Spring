<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = 1;
	if (request.getParameter("pg") != null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}
	
	// 목록 : 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	ScoreDAO dao = new ScoreDAO();
	List<ScoreDTO> list = dao.getScoreList(startNum, endNum);
	
	// 페이징 : 3블럭
	int totalA = dao.getTotalA();	// 총 데이터 수
	int totalP = (totalA + 4) / 5;	// 총 페이수 수
	
	int startPage = (pg - 1) / 3 * 3 + 1;
	int endPage = startPage + 2;
	if (endPage > totalP)
		endPage = totalP;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	width: 100%;
}

table {
	margin: auto;
	border-collapse: collapse;
	width: 500px;
	text-align: center;
}

table, td {
	border: 1px solid;
	padding: 4px;
}

.fixed {
	background: #87CEFA;
}

td>a:link {color: black; text-decoration: none;}
td>a:visited {color: black; text-decoration: none;}
td>a:hover {color: green; text-decoration: underline;}
td>a:active {color: black; text-decoration: none;}

.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="wrap">
		<h2 align="center">글 목록</h2>
		<br>
		<table>
			<tr class="fixed">
				<td width="20%">학번</td>
				<td width="20%">이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>
			
			<% for (ScoreDTO dto : list) { %>
				<tr>
					<td><%=dto.getStudNo() %></td>
					<td><a href="scoreView.jsp?pg=<%=pg %>&studNo=<%=dto.getStudNo() %>"><%=dto.getName() %></a></td>
					<td><%=dto.getKor() %></td>
					<td><%=dto.getEng() %></td>
					<td><%=dto.getMat() %></td>
					<td><%=dto.getTot() %></td>
					<td><%=dto.getAvg() %></td>
				</tr>
			<% } %>
		</table>
		<br>
		<div align="center">
			<% if (startPage > 3) { %>
				<a href="scoreList.jsp?pg=<%=startPage - 1 %>" class="paging">이전</a> &nbsp;
			<% } %>
			
			<% for (int i = startPage; i <= endPage; i++) { %>
				<% if (pg == i) { %>
					<a href="scoreList.jsp?pg=<%=i %>" class="currentPaging"><%=i %></a> &nbsp;
				<% } else { %>
					<a href="scoreList.jsp?pg=<%=i %>" class="paging"><%=i %></a> &nbsp;
				<% } %>	
			<% } %>
			
			<% if (endPage < totalP) { %>
				<a href="scoreList.jsp?pg=<%=endPage + 1 %>" class="paging">다음</a> &nbsp;
			<% } %>
		</div>
		<a href="scoreWriteForm.jsp">성적입력</a>
	</div>
</body>
</html>