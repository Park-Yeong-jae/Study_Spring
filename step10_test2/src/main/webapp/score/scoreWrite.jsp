<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String studNo = request.getParameter("studNo");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int tot = kor + eng + mat;
	double avg = tot / 3.0;
	
	ScoreDTO dto = new ScoreDTO();
	dto.setStudNo(studNo);
	dto.setName(name);
	dto.setKor(kor);
	dto.setEng(eng);
	dto.setMat(mat);
	dto.setTot(tot);
	dto.setAvg(avg);
	
	ScoreDAO dao = new ScoreDAO();
	int result = dao.insertScore(dto);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function () {
		if (<%=result > 0 %>) {
			alert("저장 완료");
			location.href="scoreList.jsp";
		} else {
			alert("저장 실패");
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>