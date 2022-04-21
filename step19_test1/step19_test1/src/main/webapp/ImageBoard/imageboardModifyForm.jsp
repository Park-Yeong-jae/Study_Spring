<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/imageboardScript.js?v=1"></script>
</head>
<body>
	<form action="imageboardModify.do" 
			method="post" enctype="multipart/form-data"  name="imageboardWriteForm">
		<input type="hidden" name="pg" value="${pg}">
		<input type="hidden" name="seq" value="${seq}">
		<input type="hidden" name="image_org" value="${dto.image1}">  
		
		<h3>이미지 수정</h3>
		<table border="1" width="500">
			<tr>
				<th width="100">상품코드</th>
				<td><input type="text" name="imageId" value="${dto.imageId }" size="53"></td>
			</tr>
			
			<tr>
				<th>상품명</th>
				<td><input type="text" name="imageName" value="${dto.imageName }" size="53"></td>
			</tr>
			
			<tr>
				<th>단가</th>
				<td><input type="text" name="imagePrice" value="${dto.imagePrice }" size="53"></td>
			</tr>
			
			<tr>
				<th>개수</th>
				<td><input type="text" name="imageQty" value="${dto.imageQty }" size="53"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="imageContent" rows="10" 
						cols="55" placeholder="* 필수입력">${dto.imageContent }</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="file" name="image1" size="50"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="doSubmit1()">	<!-- button은 return false를 써줄 필요가 없다 -->
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>