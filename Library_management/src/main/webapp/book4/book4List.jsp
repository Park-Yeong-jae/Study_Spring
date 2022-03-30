<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	text-align: center;
}

td, th {
	height: 2em;
}

#title {
	background-color: yellow;
}

.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	font-weight: bold;
	text-decoration: underline;
}
</style>
</head>
<body>
	<div style="width: 500px;">
		<!-- 목록보기 -->
		<div style="height: 300px;">
			<table border="1">
				<tr id="title">
					<th id="titleCode">도서코드</th>
					<th id="titleName">도서명</th>
					<th id="titleAuthor">저자</th>
					<th id="titlePublisher">출판사</th>
					<th id="titlePrice">가격</th>
					<th id="titleDate">출시일</th>
				</tr>

				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.book4_code}</td>
						<td>${dto.book4_name}</td>
						<td>${dto.book4_author}</td>
						<td>${dto.book4_publisher}</td>
						<td>${dto.book4_price}</td>
						<td>${dto.book4_date}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<!-- 페이징 번호보기 -->
		<div style="text-align: center">
			<c:if test="${startPage > 3}">
				[<a class="paging" href="book4List.do?pg=${startPage-1}">이전</a>]
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i}">
					[<a class="currentPaging" href="book4List.do?pg=${i}">${i}</a>>]
				</c:if>

				<c:if test="${pg != i}">
					[<a class="paging" href="book4List.do?pg=${i}">${i}</a>>]
				</c:if>
			</c:forEach>

			<c:if test="${endPage < totalP}">
				[<a class="paging" href="book4List.do?pg=${endPage+1}">다음</a>]			
			</c:if>
		</div>
	</div>
	<br>
	<br>
	<a href="book4WriteForm.do">도서 등록하러가기</a>
</body>
</html>