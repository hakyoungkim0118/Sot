package controller.model;

public class FreeSavings extends BankAccount {

	//100-
	private static int freeSavingsCount;
	public FreeSavings() {
		accountNumber=String.format("100-%03d",++freeSavingsCount);
		totalAmount +=price;
	}

	@Override
	public String toString() {
		return "FreeSavings [accountNumber=" + accountNumber + ", name=" + name + ", price=" + price + ", createDate="
				+ dateFormat() + ", totalAmount=" + totalAmount + "]";
	}
	
	@Override
	public void bankBookPrint() {

	}
	@Override
	protected void calc() {
		
	}
	
	
}








