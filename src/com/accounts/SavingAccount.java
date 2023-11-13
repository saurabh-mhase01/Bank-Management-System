package com.accounts;

import java.time.LocalDateTime;

public class SavingAccount extends Account{

    private int min_balence= 2000;

    public SavingAccount(long accountNo, String name, long aadharNo, String address, int pin) {
        super(accountNo, name, aadharNo, address, pin);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void withdraw(double amount) {
        if(super.getBalance()-amount>min_balence) {
            super.setBalance(super.getBalance()-amount);
            LocalDateTime currentDateTime = LocalDateTime.now();
            super.statement[count++] = new Statement(false,amount,super.getBalance(),currentDateTime);
            System.out.println("Withdraw Done Successfully");
        }else {
            System.out.println("You have not sufficient Balence");
        }

    }

}
