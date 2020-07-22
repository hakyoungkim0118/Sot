package controller.model;

public class Loans extends BankAccount {
	//200-
		private static int loansCount;
		public Loans() {
			// TODO Auto-generated constructor stub
			//freeSavingsCount++;
			accountNumber=String.format("200-%03d",++loansCount);
		}
	@Override
	public String toString() {  
		return "Loans []"+super.toString();
	}
	@Override
	public void bankBookPrint() {
//		System.out.println("Loan :bankBookPrint()");
	}
	@Override
	protected void calc() {
		this.interestRate = 3.0*0.01;
		double monthPay = this.price + (this.price* this.period*interestRate/12);
		System.out.println("Loan:calc()" + monthPay);
	}

}





