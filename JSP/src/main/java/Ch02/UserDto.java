package Ch02;

public class UserDto {
	private String userid;
	private String password;
	private String re_password;
	private String username;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String phone1;
	private String phone2;
	private String phone;
	private String email;
	private String birth;
	
	public UserDto() {}
	
	
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRe_password() {
		return re_password;
	}



	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getAddr1() {
		return addr1;
	}



	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}



	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public String getPhone1() {
		return phone1;
	}



	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}



	public String getPhone2() {
		return phone2;
	}



	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public UserDto(String userid, String password,String re_password,String username,String zipcode, String addr1, String addr2,String birth) 
	{
		this.userid=userid;
		this.password= password;
		this.re_password =re_password;
		this.username=username;
		this.zipcode= zipcode;
		this.addr1 =addr1;
		this.addr2=addr2;
		this.phone=phone;
		this.phone1=phone1;
		this.phone2=phone2;
		this.email=email;
	
		this.birth = birth;
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	

	
	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", password=" + password + ", re_password=" + re_password + ", username="
				+ username + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone=" + phone + ", email=" + email + ", birth=" + birth + "]";
	}



	public static void main(String[] args) {
	

	}

}
