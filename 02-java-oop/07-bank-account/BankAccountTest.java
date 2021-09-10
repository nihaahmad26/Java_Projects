public class BankAccountTest {
    public static void main(String[] args) {
            BankAccount b = new BankAccount();

            b.CheckDeposit(20000);
            b.CheckWithdrawal(250);
            b.SavingDeposit(40000);
            
            System.out.println("Number of Accounts = " + b.numberOfAccounts);
            
        }
}