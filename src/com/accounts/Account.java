package com.accounts;

import java.time.LocalDateTime;

public abstract class Account {
    private long accountNo;
    protected String name;
    private double balance =0;
    private long aadharNo;
    private String address;
    private int pin;
    private static float interestRate;
    protected int count =0;
    protected Statement[] statement= new Statement[20];

    public Account(long accountNo, String name ,long aadharNo, String address, int pin) {
        this.accountNo = accountNo;
        this.name = name;
        this.aadharNo = aadharNo;
        this.address = address;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public long getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void getTransections(){
        // todo remain of styling of statement printing
        for(int i =0;i<count;i++){
            System.out.println(statement[i].toString());
        }
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        this.balance +=amount;
        LocalDateTime currentDateTime = LocalDateTime.now();
        statement[count++] = new Statement(true,amount,this.balance,currentDateTime);
        System.out.println("Deposite Done Successfully");

    }
}
