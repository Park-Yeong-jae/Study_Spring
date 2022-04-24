<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 400px;
	border-collapse: collapse;
	border: 2px solid black;
	font-family: Gothic;
}

tr, th, td {
	border: 2px solid black;
	padding: 5px;
}

input {
	width: 90%;
}
</style>

<script type="text/javascript">
	function check() {
		var frm = document.loginForm;

		if (!frm.id.value.trim()) {
			alert("아이디를 입력하세요");
			frm.id.focus();
		} else if (!frm.pwd.value.trim()) {
			alert("비밀번호를 입력하세요");
			frm.pwd.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="login.do" method="post" name="loginForm"
		onsubmit="check(); return false;">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">로그인</button>
					<button type="button">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>