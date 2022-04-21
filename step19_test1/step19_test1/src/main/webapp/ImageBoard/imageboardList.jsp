<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	width:500px;
}

th, td {
	border: 1px solid black;
}
.paging {color: blue; text-decoration: none;}
.currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
<div style="height: 330px;">
	<table>
	    <tr>
	        <th>번호</th>
	        <th>이미지</th>
	        <th>상품명</th>
	        <th>단가</th>
	        <th>개수</th>
	        <th>합계</th>
	    </tr>
	    <c:forEach var="dto" items="${list}">	        
	        <tr align="center">
	            <td>${dto.seq}</td>
	            <td>
	            	<a href="imageboardView.do?seq=${dto.seq }&pg=${pg }">
						<img alt="이미지" src="../storage/${dto.image1 }" width="50" height="45">
					</a>
	            </td>
	            <td>${dto.imageName}</td>
	            <td>${dto.imagePrice}</td>
	            <td>${dto.imageQty}</td>
	            <td>${dto.imageQty * dto.imagePrice}</td>
	        </tr>
	    </c:forEach>
	</table>
</div>	
	<div style="text-align: center;">
		<c:if test="${startPage > 3 }">
			[<a class="paging" href="imageboardList.do?pg=${startPage - 1 }">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${pg == i }">
				[<a class="currentPaging" href="imageboardList.do?pg=${i }">${i }</a>]
			</c:if>
			<c:if test="${pg != i }">
				[<a class="paging" href="imageboardList.do?pg=${i }">${i }</a>]
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < pCnt }">
			[<a class="paging" href="imageboardList.do?pg=${endPage + 1 }">다음</a>]
		</c:if>
	</div>
</body>
</html>