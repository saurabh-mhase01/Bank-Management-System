package com.accounts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends SavingAccount{

    private boolean statusFrozen = false;
    private LocalDate lastTransectionDate ;
    private int LimitDays = 61;

    public SalaryAccount(long accountNo, String name, long aadharNo, String address, int pin) {
        super(accountNo, name, aadharNo, address, pin);

    }

    public boolean isFrozen() {
        LocalDate currentDate = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(lastTransectionDate, currentDate);//this function gives different of two day
        if(daysDifference > LimitDays) {
            this.statusFrozen = true ;
        }
        return this.statusFrozen;
    }
    public void makeunFreeze() {
        this.statusFrozen = false;
    }
    public void setlasttransectiondate(LocalDate date ){
        this.lastTransectionDate = date;
    }

    public void deposit(double amount) {
        super.deposit(amount);
        if(isFrozen()==false) {
            this.lastTransectionDate = LocalDate.now();
        }else {
            System.out.println("Your Account has been frozen");
        }
    }
    @Override
    public void withdraw(double amount) {
        if(isFrozen()==false) {
            if(super.getBalance()-amount>0) {
                super.setBalance(super.getBalance() - amount);
                LocalDateTime currentDateTime = LocalDateTime.now();
                super.statement[count++] = new Statement(false, amount, super.getBalance(), currentDateTime);
                lastTransectionDate = LocalDate.now();
                System.out.println("Withdraw Done Successfully");
            }else System.out.println("Insufficient Balance to Withdraw");
        }else {
            System.out.println("Your Account has been frozen\nYou Cannot withdraw Money");
        }

    }

}
