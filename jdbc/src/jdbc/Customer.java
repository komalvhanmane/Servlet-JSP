package jdbc;

public class Customer {
	private int c_no;
	private String c_name;
	private String c_city;
	private String c_mobile;
	public Customer( String c_name, String c_city, String c_mobile) {
		super();
		this.c_name = c_name;
		this.c_city = c_city;
		this.c_mobile = c_mobile;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_city() {
		return c_city;
	}
	public void setC_city(String c_city) {
		this.c_city = c_city;
	}
	public String getC_mobile() {
		return c_mobile;
	}
	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}
	
}
