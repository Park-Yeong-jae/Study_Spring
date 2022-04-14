package score.controller;

public class ViewResolver {
	private String prefix;   // 접두사  "./"
	private String suffix;   // 접미사  ".jsp"
	
	public String getView(String viewName) {		// "scoreList"
		return prefix + viewName + suffix;			// "./" + "scoreList" + ".jsp
	}												// "./scoreList.jsp"
	
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
