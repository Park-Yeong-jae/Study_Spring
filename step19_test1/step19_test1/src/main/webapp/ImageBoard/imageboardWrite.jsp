<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
	window.onload = function () {
		if(${result > 0}){
			alert("저장 성공");
		} else {
			alert("저장 실패");
		}
		location.href = "imageboardList.do?pg=1";
	}
</script>
</head>
<body>

</body>
</html>