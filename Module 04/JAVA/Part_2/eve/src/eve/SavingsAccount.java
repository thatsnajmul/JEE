
package eve;


public class SavingsAccount extends BankAccount{
    private final double sAinterestRate;

    public SavingsAccount(double savbalance, double savinterestRate) {
        super(savbalance);
        this.sAinterestRate = savinterestRate;
    }

    @Override
    public void savwithdraw(double amount) {
        if (amount >= 500 && balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public double savcalculateInterest() {
        return balance * sAinterestRate;
    }
    
    
}
