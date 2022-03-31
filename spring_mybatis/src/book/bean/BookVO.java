package book.bean;

public class BookVO {
	private String book3_code;
	private String book3_name;
	private String book3_author;
	private String book3_publisher;
	private int book3_price;
	private String book3_date;
	
	@Override
	public String toString() {
		return "BookVO [book3_code=" + book3_code + ", book3_name=" + book3_name + ", book3_author=" + book3_author
				+ ", book3_publisher=" + book3_publisher + ", book3_price=" + book3_price + ", book3_date=" + book3_date
				+ "]";
	}
	
	public String getBook3_code() {
		return book3_code;
	}
	public void setBook3_code(String book3_code) {
		this.book3_code = book3_code;
	}
	public String getBook3_name() {
		return book3_name;
	}
	public void setBook3_name(String book3_name) {
		this.book3_name = book3_name;
	}
	public String getBook3_author() {
		return book3_author;
	}
	public void setBook3_author(String book3_author) {
		this.book3_author = book3_author;
	}
	public String getBook3_publisher() {
		return book3_publisher;
	}
	public void setBook3_publisher(String book3_publisher) {
		this.book3_publisher = book3_publisher;
	}
	public int getBook3_price() {
		return book3_price;
	}
	public void setBook3_price(int book3_price) {
		this.book3_price = book3_price;
	}
	public String getBook3_date() {
		return book3_date;
	}
	public void setBook3_date(String book3_date) {
		this.book3_date = book3_date;
	}
}
