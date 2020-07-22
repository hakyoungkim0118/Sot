package controller.model;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public abstract class BankAccount {
	protected String accountNumber;
	protected String name;
	protected int  price;
	protected static Calendar createDate;
	protected Calendar interestDate;
	protected double  interestRate;
	protected  int  interest;
	protected  int  period;
	protected long  totalAmount;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Calendar getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}
	public Calendar getInterestDate() {
		return interestDate;
	}
	public void setInterestDate(Calendar interestDate) {
		this.interestDate = interestDate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
    public static String dateFormat()
    {
        // 날짜를 통신용 문자열로 변경
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(createDate.getTime());
    }
	
	public BankAccount() {
		calc();
	}
	
	abstract public void  bankBookPrint() ;
	abstract protected void calc();
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", name=" + name + ", price=" + price + ", createDate="
				+ dateFormat() + ", interestDate=" + interestDate + ", interestRate=" + interestRate + ", interest="
				+ interest + ", period=" + period + ", totalAmount=" + totalAmount + "]";
	}
	
}

