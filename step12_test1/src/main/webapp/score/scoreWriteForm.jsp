<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/scoreScript.js"></script>
<style type="text/css">
#wrap {
	width: 100%;
}

table {
	margin: auto;
	border-collapse: collapse;
	width: 400px;
}

table, td {
	border: 1px solid;
	padding: 4px;
}

.fixed {
	background: #87CEFA;
	width: 100px;
	text-align: center;
}

input[type='text'] {
	width: 97.5%;
}
</style>
</head>
<body>
	<div id="wrap">
		<form action="scoreWrite.do" name="form" method="post" >
			<h2 align="center">성적 입력</h2>
			<table>
				<tr>
					<td class="fixed">학번</td>
					<td><input type="text" name="studNo"></td>
				</tr>

				<tr>
					<td class="fixed">이름</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td class="fixed">국어</td>
					<td><input type="text" name="kor"></td>
				</tr>

				<tr>
					<td class="fixed">영어</td>
					<td><input type="text" name="eng"></td>
				</tr>

				<tr>
					<td class="fixed">수학</td>
					<td><input type="text" name="mat"></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<input type="button" value="등록" onclick="check()"> &nbsp;
				<input type="reset" value="다시 작성">
			</div>
		</form>
	</div>
	
	<a href="scoreList.do">목록보기</a>
</body>
</html>