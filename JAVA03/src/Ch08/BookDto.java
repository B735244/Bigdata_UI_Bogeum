package Ch08;
//bookCode, bookName,publisher,isbn 변수를 선언하고 private으로 선언했는데, private으로 선언해두면 외부에서 접근을 못함. 
//그래서 getter, setter 객체를 만들어야 했음.
public class BookDto {
	private Long bookCode;
	private String bookName;
	private String publisher;
	private String isbn;
//귀찮게 한개씩 초기화하지 않고 전체 필드를 초기화했음.
	public BookDto(Long bookCode, String bookName, String publisher, String isbn) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.publisher = publisher;
		this.isbn = isbn;
	}
//밑에 기본생성자 전까지의 함수들
	// getter, setter 함수를 통해 외부에서 접근 가능하다.
	//getter는 값을 가져올 떄
	//setter는 값을 수정할 때 호출
	public Long getBookCode() {
		return bookCode;
	}

	public void setBookCode(Long bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
//이것은 기본 생성자
	public BookDto() {
	
	}
//System.out.println();함수를 대신하는 함수
	@Override
	public String toString() {
		return "BookDto [bookCode=" + bookCode + ", bookName=" + bookName + ", publisher=" + publisher + ", isbn="
				+ isbn + "]";
	}

}
