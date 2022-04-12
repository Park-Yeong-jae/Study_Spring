<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	String studNo = request.getParameter("studNo");
	
	ScoreDAO dao = new ScoreDAO();
	int result = dao.deleteScore(studNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function () {
		if(<%=result > 0 %>) {
			alert("삭제 성공");
			location.href="scoreList.jsp?pg=<%=pg %>";
		} else {
			alert("삭제 실패");
			history.back();
		}
	}
</script>
</head>
<body>
	
</body>
</html>