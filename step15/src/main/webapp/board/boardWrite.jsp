<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(${result > 0}) {
			alert("저장되었습니다");
			location.href="boardList.do?pg=1";
		} else {
			alert("저장하지 못했습니다");
			history.back();
		} 
	}
</script>
</head>
<body>

</body>
</html>