package Ch02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDto {

	
	private String username;
	private String age;
	private String addr;
	private LocalDateTime date;
	private String bgColor;
	private String textColor;
	
	
	public TestDto(String username, String age, String addr, LocalDateTime date, String bgColor, String textColor) {
		super();
		this.username = username;
		this.age = age;
		this.addr = addr;
		this.date = date;
		this.bgColor = bgColor;
		this.textColor = textColor;
	}



	@Override
	public String toString() {
		return "TestDto [username=" + username + ", age=" + age + ", addr=" + addr + ", date=" + date + ", bgColor="
				+ bgColor + ", textColor=" + textColor + "]";
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public void setStringtoDate(String date) {
		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		this.date = LocalDateTime.parse(date,fmtin);
	}



	public String getBgColor() {
		return bgColor;
	}



	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}



	public String getTextColor() {
		return textColor;
	}



	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}



	public TestDto() {}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
