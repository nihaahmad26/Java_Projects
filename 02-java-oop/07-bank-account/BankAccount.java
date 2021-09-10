public class BankAccount {
    private double checkings;
    private double savings;
    public static double numberOfAccounts = 0;
    public BankAccount() {
        checkings = 0;
        savings = 0;
        numberOfAccounts++;
    }
    public double CheckDeposit(double amount) {
        checkings += amount;
        System.out.println("Checking Account Balance" + " " +  checkings);
        return checkings;
    }
    public double CheckWithdrawal(double amount) {
        checkings -= amount;
        System.out.println("Checking Account Balance" + " " +  checkings);
        return checkings;
    }
    public double SavingDeposit(double amount) {
        savings += amount;
        System.out.println("Savings Account Balance" + " " +  savings);
        return savings;
    }
    public double SaveWithdrawal(double amount) {
        savings -= amount;
        System.out.println("Savings Account Balance" + " " +  savings);
        return savings;
    }

}
