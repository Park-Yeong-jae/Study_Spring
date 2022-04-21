// 입력 검사 
function doSubmit() {
	var frm = document.frm;

	if (!frm.imageId.value || frm.imageId.value == "img_") {
		alert("상품코드를 입력하세요");
		frm.imageId.focus();
	} else if (!frm.imageName.value) {
		alert("상품명을 입력하세요.");
		frm.imageName.focus();
	} else if (!frm.imagePrice.value) {
		alert("상품 단가를 입력하세요.");
		frm.imagePrice.focus();
	} else if (isNaN(frm.imagePrice.value)) {		
		alert("상품 단가를 숫자로 입력하세요.");
		frm.imagePrice.value = "";
		frm.imagePrice.focus();
	} else if (!frm.imageQty.value) {
		alert("상품 갯수를 입력하세요");
		frm.imageQty.focus();
	} else if (isNaN(frm.imageQty.value)) {
		alert("상품 갯수를 숫자로 입력하세요");
		frm.imageQty.value = "";
		frm.imageQty.focus();
	} else if (!frm.imageContent.value) {
		alert("내용을 입력하세요");
		frm.imageContent.focus();
	} else {
		frm.submit();
	}
}
// 수정화면의 입력검사
function doSubmit1() {
	var frm = document.imageboardWriteForm;
	
	// isNaN(str) : 숫자로 되어있는지 확인
	// str.trim() : 공백으로만 이루어져있는지 확인
	// str.replace(" ", "") : 첫번째 인자값을 두번째 인자값으로 변환
	
	if (!frm.imageId.value.trim() || frm.imageId.value=="img_") {	// default 값이 img_ 이기때문에 검사해줘야 한다
		alert("상품코드를 입력하세요");
		frm.imageId.value="img_";	// 초기화
		frm.imageId.focus();		// 커서
	} else if (!frm.imageName.value.trim()) {
		alert("상품명을 입력하세요");
		frm.imageName.value="";		// 초기화
		frm.imageName.focus();
	} else if (!frm.imagePrice.value.trim()) {
		alert("단가를 입력하세요");
		frm.imagePrice.value="";
		frm.imagePrice.focus();
	}  else if (isNaN(frm.imagePrice.value)) {
		alert("단가를 숫자로 입력하세요");
		frm.imagePrice.value="";
		frm.imagePrice.focus();
	}else if (!frm.imageQty.value.trim()) {
		alert("갯수를 입력하세요");
		frm.imageQty.value="";
		frm.imageQty.focus();
	}  else if (isNaN(frm.imageQty.value)) {
		alert("갯수를 숫자로 입력하세요");
		frm.imageQty.value="";
		frm.imageQty.focus();
	}else if (!frm.imageContent.value.trim()) {
		alert("내용을 입력하세요");
		frm.imageContent.value="";
		frm.imageContent.focus();
	} else {
		frm.submit();
	}
}