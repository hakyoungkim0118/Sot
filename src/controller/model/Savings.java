package controller.model;

public class Savings extends BankAccount {

	@Override
	public String toString() {
		return "Savings [accountNumber=" + accountNumber + ", name=" + name + ", price=" + price + ", createDate="
				+ createDate + ", interestDate=" + interestDate + ", interestRate=" + interestRate + ", interest="
				+ interest + ", period=" + period + ", totalAmount=" + totalAmount + "]";
	}

	@Override
	public void bankBookPrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void calc() {
		this.interestRate = 2.5*0.01; 
		double totalReturn = this.price + (this.price* this.period*interestRate);
		System.out.println("FreeSavings:calc()" + totalReturn);
	}

}
