package myappl.model;

public class Account {
	private int accNo;
	private String custName;
	private String lastName;
	private double acc_bal;
	
	public Account(int accNo, String custName, double acc_bal,String lastName) {
		this.accNo = accNo;
		this.custName = custName;
		this.acc_bal = acc_bal;
		this.setLastName(lastName);
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getAcc_bal() {
		return acc_bal;
	}
	public void setAcc_bal(double acc_bal) {
		this.acc_bal = acc_bal;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
