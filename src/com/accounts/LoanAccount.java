package com.accounts;

import java.time.LocalDate;

import java.util.Date;

public class LoanAccount extends Account {

    private LocalDate startDate;
    private LocalDate endDate;
    private int noOfEmi;
    private double loanIntrest;
    private double Paneltyamount;
    private LocalDate nextEmiDate;

    public LoanAccount(long accountNo, String name, long aadharNo, String address, int pin) {
        super(accountNo, name, aadharNo, address, pin);
    }

    public void takeLoan(int amount,int noOfMonths) {

        startDate= LocalDate.now();


    }
    @Override
    public void withdraw(double amount) {


    }



}
