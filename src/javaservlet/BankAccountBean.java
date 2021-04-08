package javaservlet;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class BankAccountBean implements java.io.Serializable {
	// automatically created serializable UID
	private static final long serialVersionUID = 1001L;

	// look at the access modifier of balance
    private double balance;
    private String account_type;
    
    private static final String PROP_BALANCE = "balance";
    private static final String PROP_ACCOUNTTYPE = "account_type";
    private PropertyChangeSupport propertySupport;
    
    // constructor: public, no argument
    public BankAccountBean() {
    	propertySupport = new PropertyChangeSupport( this );
    }
    
    // getter method
    public double getBalance() {
        return balance;
    }
    
    // setter method: balance is read write and bound 
    // whenever setting balance, fire a property change
    public void setBalance(double amount)
    {
    	double oldBalance = balance;
        this.balance = amount;
        propertySupport.firePropertyChange(PROP_BALANCE, oldBalance, balance);
    }
    
    // getter method for account type
    public String getAccountType() {
        return account_type;
    }
    
    // setter method for account type
    public void setAccountType(String ac_type)
    {
    	String oldAccountType = account_type;
        this.account_type = ac_type;
        propertySupport.firePropertyChange(PROP_ACCOUNTTYPE, oldAccountType, account_type);
    }
    
    // using setBalance method
    public void withdraw(double amount) {
    	if(balance >= amount)
    		setBalance(getBalance()-amount);
    }
    
    // using setBalance method
    public void deposit(double amount) {
    	setBalance(getBalance()+amount);
    }
      
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertySupport.removePropertyChangeListener(listener);
    }

    // the value of the object as a string
    public String toString()
    {
        return "Balance: �"+this.balance;
    }
 
}

