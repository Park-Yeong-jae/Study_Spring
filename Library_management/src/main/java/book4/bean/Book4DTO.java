package book4.bean;

public class Book4DTO {
	private int book4_seq; 			// 글번호
	private String book4_code; 		// 도서코드
	private String book4_name; 		// 도서명
	private String book4_author; 	// 저자
	private String book4_publisher; // 출판사
	private int book4_price; 		// 가격
	private String book4_date; 		// 출시일

	// setter , getter

	public int getSeq() {
		return book4_seq;
	}

	public void setSeq(int seq) {
		this.book4_seq = seq;
	}

	public String getBook4_code() {
		return book4_code;
	}

	public void setBook4_code(String book4_code) {
		this.book4_code = book4_code;
	}

	public String getBook4_name() {
		return book4_name;
	}

	public void setBook4_name(String book4_name) {
		this.book4_name = book4_name;
	}

	public String getBook4_author() {
		return book4_author;
	}

	public void setBook4_author(String book4_author) {
		this.book4_author = book4_author;
	}

	public String getBook4_publisher() {
		return book4_publisher;
	}

	public void setBook4_publisher(String book4_publisher) {
		this.book4_publisher = book4_publisher;
	}

	public int getBook4_price() {
		return book4_price;
	}

	public void setBook4_price(int book4_price) {
		this.book4_price = book4_price;
	}

	public String getBook4_date() {
		return book4_date;
	}

	public void setBook4_date(String book4_date) {
		this.book4_date = book4_date;
	}
}
