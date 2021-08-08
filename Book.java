
public class Book {
	private String name;
	private String author;
	private String type;
	private int pageNum;
	private String pdf;
	public Book(String name, String author, String type, int pageNum, String pdf) {
		super();
		this.name = name;
		this.author = author;
		this.type = type;
		this.pageNum = pageNum;
		this.pdf = pdf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	

}
