
package eve;


public class Calculate{

    public static void main(String[] args) {
        
        
        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.02);
        
        savingsAccount.sAdeposit(1000);
        savingsAccount.savwithdraw(500);
        
        
        double interest = savingsAccount.savcalculateInterest();
        
        System.out.println("Savings Account Balance: " + savingsAccount.balance);
        System.out.println("Savings Account Interest: " + interest);

        
        CheckingAccount checkingAccount = new CheckingAccount(1000, 500, 500);
        
        checkingAccount.cAdeposit(500);
        checkingAccount.cawithdraw(500);
        checkingAccount.cawithdraw(500); //fee
        System.out.println("Checking Account Balance: " + checkingAccount.balance);
    }
    
}
