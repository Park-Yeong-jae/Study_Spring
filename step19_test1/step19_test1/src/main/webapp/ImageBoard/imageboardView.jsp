<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.view {
	text-align: left;
	width: 220px;
}
</style>
</head>
<body>
<div style="text-align: center;">
	<table border="1">
		<tr>
			<td rowspan="4">
				<img alt="이미지" src="../storage/${dto.image1 }" width="150" height="150">
			</td>
			<td class="view">상품명 : ${dto.imageName }</td>
		</tr>
		<tr>
			<td class="view">단가 : ${dto.imagePrice }</td>
		</tr>
		<tr>
			<td class="view">개수 : ${dto.imageQty }</td>
		</tr>
		<tr>
			<td class="view">합계 : ${dto.imagePrice * dto.imageQty }</td>
		</tr>
		<tr>
			<td colspan="2" height="200" valign="top" align="left"><pre>${dto.imageContent }</pre></td>
		</tr>
	</table>
</div>
	<input type="button" value="목록" onclick="location.href='imageboardList.do?pg=${pg }'">
	<input type="button" value="수정" 
		onclick="location.href='imageboardModifyForm.do?pg=${pg }&seq=${dto.seq }'">
	<button type="button" 
		onclick="location.href='imageboardDelete.do?seq=${dto.seq}&pg=${pg}'">삭제</button>
</body>
</html>