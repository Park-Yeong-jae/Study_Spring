<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	text-align: center;
}
td , th {
	height: 2em;
}
#title {
	background-color: yellow;
}
#titleNo {
	width: 4em;
	font-weight: bold;
}
#titleSub {
	width: 20em;
	font-weight: bold;
}
#titleName {
	width: 6em;
	font-weight: bold;
}
#titleDate {
	width: 8em;
	font-weight: bold;
}
#titleHit {
	width : 4em;
	font-weight: bold;
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

<script type="text/javascript">
	function isLogin(seq) {		
		if(${memId != null}) {
			location.href="boardView.do?seq=" + seq + "&pg=" + ${pg};
		} else {
			alert("먼저 로그인 하세요.");
		}		
	}

</script>
</head>
<body>
	<div style="width: 700px;">
		<!-- 목록보기 -->
		<div style="height: 300px;">
			<table border="1">
			<tr id="title">
				<th id="titleNo">글번호</th>
				<th id="titleSub">제목</th>
				<th id="titleName">작성자</th>
				<th id="titleDate">작성일</th>
				<th id="titleHit">조회수</th>
			</tr>
			
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.seq}</td>
					<td><a href="#" onclick="isLogin(${dto.seq})">${dto.subject}</a></td>
					<td>${dto.name}</td>
					<td>${dto.logtime}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>			
		</table>
		</div>
		<!-- 페이징 번호보기 -->
		<div style="text-align: center;">
			<c:if test="${startPage > 3}">
				[<a class="paging" href="boardList.do?pg=${startPage-1}">이전</a>]
			</c:if>
		
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i}">
					[<a class="currentPaging" href="boardList.do?pg=${i}">${i}</a>]
				</c:if>
					
				<c:if test="${pg != i}">
					[<a class="paging" href="boardList.do?pg=${i}">${i}</a>]
				</c:if>
			</c:forEach>			
			
			<c:if test="${endPage < totalP}">
				[<a class="paging" href="boardList.do?pg=${endPage+1}">다음</a>]
			</c:if>
			
		</div>
	</div>
	<br>
	<a href="boardWriteForm.do">새글쓰기</a>
	<c:if test="${memId==null }">
		<a href="../member/loginForm.jsp">로그인</a>
	</c:if>
	
</body>
</html>