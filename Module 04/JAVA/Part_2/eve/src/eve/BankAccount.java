
package eve;

public abstract class BankAccount{
    
    
    protected double bAbalance;
    protected double cAbalance;

    public sABankAccount(double babalance) {
        this.bAbalance = babalance;
    }

    public void sAdeposit(double baamount) {
        if (baamount >= 500) {
            bAbalance += baamount;
        }
    }
    
    public cABankAccount(double cabalance) {
        this.cAbalance = cabalance;
    }

    public void cAdeposit(double amount) {
        if (amount >= 500) {
            cAbalance += amount;
        }
    }

    public abstract void savwithdraw(double amount);

    public abstract double savcalculateInterest(); 
    
    public abstract void cavwithdraw(double amount);

    public abstract double cacavcalculateInterest(); 
    
}
