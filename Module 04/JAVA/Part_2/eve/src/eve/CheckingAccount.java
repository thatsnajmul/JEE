
package eve;


public class CheckingAccount extends BankAccount {
    
    
    
    private final double cAwithdrawalLimit;
    private final double cAfee;
    
    

    public CheckingAccount(double balance, double withdrawalLimit, double fee) {
        super(balance);
        this.cAwithdrawalLimit = withdrawalLimit;
        this.cAfee = fee;
    }
    
    

    @Override
    public void cawithdraw(double amount) {
        if (amount >= 500) {
            if (amount <= cAwithdrawalLimit) {
                balance -= amount;
            } else if (balance >= amount + cAfee) {
                balance -= (amount + cAfee); //yarly
            }
        }
    }

    @Override
    public double cacalculateInterest() {
        return 0; 
    }
}
