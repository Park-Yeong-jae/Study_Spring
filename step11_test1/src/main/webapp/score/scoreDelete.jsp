<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function () {
		if(${result > 0}) {
			alert("삭제 성공");
			location.href="scoreList.do?pg=${pg}";
		} else {
			alert("삭제 실패");
			location.href="scoreView.do?studNo=${studNo}&pg=${pg}";
		}
	}
</script>
</head>
<body>
	
</body>
</html>