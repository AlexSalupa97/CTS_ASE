package clase;

import exceptii.ExceptieDepunere;
import exceptii.ExceptieRetragere;

public class BankAccount {
    double balance;
    double limit;
    double lowestBalance;

    public BankAccount(double b, double l, double lb){
        balance=b;
        limit=l;
        lowestBalance=lb;
    }

    //Retrage bani
    public void withdraw(double amount){
        if(amount>balance||amount>limit||amount<=0)
            throw new ExceptieRetragere();
        balance=balance-amount;
    }

    //Depozit
    public void deposit(double amount){
        if(amount<=0)
            throw new ExceptieDepunere();
        balance=balance+amount;
    }

    //Get the value of balance
    public double getBalance(){
        return balance;
    }
}
