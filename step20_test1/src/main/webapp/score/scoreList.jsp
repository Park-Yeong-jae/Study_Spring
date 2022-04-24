<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	width: 100%;
}

table {
	margin: auto;
	border-collapse: collapse;
	width: 500px;
	text-align: center;
}

table, td {
	border: 1px solid;
	padding: 4px;
}

.fixed {
	background: #87CEFA;
}

td>a:link {color: black; text-decoration: none;}
td>a:visited {color: black; text-decoration: none;}
td>a:hover {color: green; text-decoration: underline;}
td>a:active {color: black; text-decoration: none;}

.paging {
	color: blue;
	text-decoration: none;
}

.currentPaging {
	color: red;
	text-decoration: none;
}
</style>

<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(function() {
		$.ajax({
			url: "scoreListJson.do",
			type: "post",
			data: {"pg": "${pg}"},
			dataType: "json",
			success: function(json) {
				if(json.rt == "OK") {
					$.each(json.items, function(index, item) {
						var tr = $("<tr>", {align: "center"});
						var td1 = $("<td>").html(item.studNo);
						var td2 = $("<td>").append($("<a>", {
							id: "nameA",
							href: "#",
							click: function() {
								location.href="scoreView.do?studNo=" + item.studNo + "&pg=" + ${pg};
							},
							text: item.name
						}));
						var td3 = $("<td>").html(item.kor);
						var td4 = $("<td>").html(item.eng);
						var td5 = $("<td>").html(item.mat);
						var td6 = $("<td>").html(item.tot);
						var td7 = $("<td>").html(item.avg);
						
						// 조립
						tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6).append(td7);
						$("#scoreList").append(tr);
					});
				}				
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("[Error] " + xhr.status);
			}
		});
	});
</script>
</head>
<body>
	<div id="wrap">
		<h2 align="center">글 목록</h2>
		<br>
		<table>
			<tr class="fixed">
				<td width="20%">학번</td>
				<td width="20%">이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>
			
			<tbody id="scoreList" >
				<!-- 목록 출력 -->
			</tbody>		
		</table>
		<br>
		<div align="center">
			<c:if test="${startPage > 3}">
				<a href="scoreList.do?pg=${startPage - 1}" class="paging">이전</a> &nbsp;
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i}">
					<a href="scoreList.do?pg=${i}" class="currentPaging">${i}</a> &nbsp;
				</c:if>
				
				<c:if test="${pg != i}">
					<a href="scoreList.do?pg=${i}" class="paging">${i}</a> &nbsp;
				</c:if>
			</c:forEach>
			
			<c:if test="${endPage < totalP}">
				<a href="scoreList.do?pg=${endPage + 1}" class="paging">다음</a> &nbsp;
			</c:if>				
		</div>
		<a href="scoreWriteForm.do">성적입력</a>
	</div>
</body>
</html>