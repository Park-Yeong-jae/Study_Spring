function check() {	
	var frm = document.form;

	if (!frm.studNo.value) {
		alert("학번을 입력하세요.");
		frm.studNo.focus();
	} else if (!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
	} else if (!frm.kor.value) {
		alert("국어점수를 입력하세요.");
		frm.kor.focus();
	} else if (!frm.eng.value) {
		alert("영어점수를 입력하세요.");
		frm.eng.focus();
	} else if (!frm.mat.value) {
		alert("수학점수를 입력하세요.");
		frm.mat.focus();
	} else {
		frm.submit();
	}
}