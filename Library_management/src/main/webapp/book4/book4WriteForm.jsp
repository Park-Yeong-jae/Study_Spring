<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/book4Script.js?v=1"></script>
<style>
table {
	width: 300px;
}
</style>
</head>
<body>
	<form action="book4Write.do" method="post" name="book4WriteForm">
		<table border="1">
			<tr>
				<th>도서코드</th>
				<td><input type="text" name="book4_code" placeholder="*필수입력"></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="book4_name" placeholder="*필수입력"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="book4_author" placeholder="*필수입력"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="book4_publisher"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="book4_price"></td>
			</tr>
			<tr>
				<th>출시일</th>
				<td><input type="text" name="book4_date"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" value="저장" onclick="checkBook4Write()">저장</button>
					<button type="reset" value="다시작성">다시작성</button>
				</td>
			</tr>
		</table>
	</form>
	<br>
	<a href="book4List.do"> 목록 </a>
</body>
</html>