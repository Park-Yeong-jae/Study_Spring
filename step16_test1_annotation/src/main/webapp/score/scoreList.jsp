<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
			
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.studNo }</td>
					<td><a href="scoreView.do?pg=${pg }&studNo=${dto.studNo }">${dto.name }</a></td>
					<td>${dto.kor }</td>
					<td>${dto.eng }</td>
					<td>${dto.mat }</td>
					<td>${dto.tot }</td>
					<td>${dto.avg }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div align="center">
			<c:if test="${startPage > 3 }">
				<a href="scoreList.do?pg=${startPage - 1 }" class="paging">이전</a> &nbsp;
			</c:if>

			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg == i }">
					<a href="scoreList.do?pg=${i }" class="currentPaging">${i }</a> &nbsp;
				</c:if>

				<c:if test="${pg != i }">
					<a href="scoreList.do?pg=${i }" class="paging">${i }</a> &nbsp;
				</c:if>
			</c:forEach>

			<c:if test="${endPage < totalP }">
				<a href="scoreList.do?pg=${endPage + 1 }" class="paging">다음</a> &nbsp;
			</c:if>
		</div>
		<a href="scoreWriteForm.do">성적입력</a>
	</div>
</body>
</html>