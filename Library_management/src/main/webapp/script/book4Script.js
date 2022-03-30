function checkBook4Write() {	
	var form = document.book4WriteForm;
	
	if(!form.book4_code.value) {
		alert("도서코드를 입력하세요.");
		form.book4_code.focus();
	} else if(!form.book4_name.value) {
		alert("도서명을 입력하세요.");
		form.book4_name.focus();
	} else if(!form.book4_author.value) {
		alert("저자를 입력하세요.");
		form.book4_author.focus();
	} else if(!form.book4_publisher.value) {
		alert("출판사를 입력하세요.");
		form.book4_publisher.focus();
	} else if(!form.book4_price.value) {
		alert("가격을 입력하세요.");
		form.book4_price.focus();
	} else if(!form.book4_date.value) {
		alert("출시일을 입력하세요.");
		form.book4_date.focus();
	} else {
		form.submit();
	}
}