<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.name {
	background: #E4B5F6;
}

.fixed {
	background: #87CEFA;
}
</style>
</head>
<body>
	<div>
		<table>
			<tr class="name">
				<td colspan="6">${dto.name }</td>
			</tr>
		
			<tr class="fixed">
				<td width="20%">학번</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>

			<tr>
				<td>${dto.studNo }</td>
				<td>${dto.kor }</td>
				<td>${dto.eng }</td>
				<td>${dto.mat }</td>
				<td>${dto.tot }</td>
				<td>${dto.avg }</td>
			</tr>
		</table>
		<br>
		<div align="center">
			<input type="button" value="목록" 
				onclick="location.href='scoreList.do?pg=${pg}'"> &nbsp; 
			<input type="button" value="성적수정" onclick="#"> &nbsp; 
			<input type="button" value="성적삭제" 
				onclick="location.href='scoreDelete.do?pg=${pg }&studNo=${dto.studNo }'">
		</div>
	</div>
</body>
</html>