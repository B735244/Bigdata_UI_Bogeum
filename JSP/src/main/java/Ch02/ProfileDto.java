package Ch02;

public class ProfileDto {

	private String username;
	private String age;
	private String addr;
	
	private String bgColor;
	private String textColor;
	
	
	
	public ProfileDto() {}
	
	public ProfileDto(String username, String age, String addr, String bgColor,String textColor) {
		this.username=username;
		this.addr=addr;
		this.age=age;
		this.bgColor=bgColor;
		this.textColor=textColor;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ProfileDto [username=" + username + ", age=" + age + ", addr=" + addr + ", bgColor=" + bgColor
				+ ", textColor=" + textColor + "]";
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







	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
