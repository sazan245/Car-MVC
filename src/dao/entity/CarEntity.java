package dao.entity;


public class CarEntity {
	private  int pid;
	private String name;
	private String Number;
	private String color;
	private String vendor;
	private String model;
	private String address;
	private long price;
	private String userid;
	private String password;
	private String role;
	public CarEntity(int pid, String name, String number, String color, String vendor, String model, String address,
			long price, String userid, String password, String role) {
		super();
		this.pid = pid;
		this.name = name;
		this.Number = number;
		this.color = color;
		this.vendor = vendor;
		this.model = model;
		this.address = address;
		this.price = price;
		this.userid = userid;
		this.password = password;
		this.role = role;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

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

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "CarEntity [pid=" + pid + ", name=" + name + ", Number=" + Number + ", color=" + color + ", vendor="
				+ vendor + ", model=" + model + ", address=" + address + ", price=" + price + ", userid=" + userid
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	


	


   
}
