package board.controller;

// view 처리 파일이름 완성시키는 클래스
public class ViewResolver {
	private String prefix;	// 접두사
	private String suffix;	// 접미사
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;  // "./" + "boardList" + ".jsp" => "./boardList.jsp"
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
