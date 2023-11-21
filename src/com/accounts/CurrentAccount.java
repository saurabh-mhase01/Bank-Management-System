package com.accounts;

import java.time.LocalDateTime;

public class CurrentAccount extends Account {

    private double overDraftAmount= -10000;

    public CurrentAccount(long accountNo, String name, long aadharNo, String address, int pin) {
        super(accountNo, name, aadharNo, address, pin);

    }
    public double  getOverDraftAmount() {
        return Math.abs(super.getBalance()- overDraftAmount);

    }
    @Override
    public void withdraw(double amount) {
        if((super.getBalance()-amount)>=overDraftAmount) {
            super.setBalance(super.getBalance()-amount);
            LocalDateTime currentDateTime = LocalDateTime.now();
            super.statement[count++] = new Statement(false,amount,super.getBalance(),currentDateTime);

        }else {
            System.out.println("Your OverDraft Limit has been Exceeded");
        }

    }

}
