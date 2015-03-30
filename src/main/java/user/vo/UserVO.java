package user.vo;

public class UserVO {
	
	private String userid;
	private String userpwd;
	private String username;
	private String email;
	private String phone;
	private String address;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	// default 생성자 함수 생성
	// 만드는 것이 좋음
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String userid, String userpwd, String username) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
	}

	public UserVO(String userid, String userpwd, String username, String email,
			String phone, String address) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpwd=" + userpwd
				+ ", username=" + username + ", email=" + email + ", phone="
				+ phone + ", address=" + address + "]";
	}
	
	
}
