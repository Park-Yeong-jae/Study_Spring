<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js?v=1"></script>
<style>
	table {
		width: 500px;
	}
	
	table tr td:nth-child(1) {
		text-align: center;
		width: 15%;
	}
	
	input[name=subject] {
		width: 98%;
	}
	
	textarea {
		width: 98%;
		height: 300px;
		resize: none;
	}
</style>
</head>
<body>
	<form action="boardWrite.do" method="post" name="boardWriteForm">
	
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="checkBoardWrite()">
					<input type="reset" value="다시 작성">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>