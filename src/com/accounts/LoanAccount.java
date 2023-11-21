package com.accounts;

import java.time.LocalDate;

import java.time.LocalDateTime;


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

    public void takeLoan(int amount, int noOfMonths) {
        // Assuming loan interest is 5% for simplicity, you can modify it as per your requirements in account class
        double interestAmount = amount * Account.getInterestRate();// Calculate the loan interest
        startDate = LocalDate.now();  // Set the start date to the current date
        endDate = startDate.plusMonths(noOfMonths);// Calculate the end date by adding the number of months to the start date
        noOfEmi = noOfMonths;// Set the number of EMIs
        Paneltyamount = 0; // Assuming no penalty initially

        // Calculate the EMI amount (principal + interest)
        double emiAmount = (amount + interestAmount) / noOfMonths;

        // Calculate the next EMI date (assuming EMIs are monthly)
        nextEmiDate = startDate.plusMonths(1);

        // Update the account balance with the loan amount
        super.setBalance(super.getBalance() + amount);

        // Add a statement for the loan transaction
        LocalDateTime currentDateTime = LocalDateTime.now();
        super.statement[count++] = new Statement(true, amount, super.getBalance(), currentDateTime);

        // Print loan details
        System.out.println("Loan Taken Successfully");
        System.out.println("Loan Amount: " + amount);
        System.out.println("Loan Interest: " + interestAmount);
        System.out.println("EMI Amount: " + emiAmount);
        System.out.println("Number of EMIs: " + noOfEmi);
        System.out.println("Loan Start Date: " + startDate);
        System.out.println("Loan End Date: " + endDate);
        System.out.println("Next EMI Date: " + nextEmiDate);
    }

    public double calculatePenaltyAmount() {
        // Assuming a penalty rate of 2% per month for simplicity, you can modify it as per your requirements
        double penaltyRate = 0.02;

        // Calculate the penalty amount based on the outstanding loan amount
        double outstandingLoanAmount = super.getBalance();
        double penaltyAmount = outstandingLoanAmount * penaltyRate;

        // Update the penalty amount in the class variable
        Paneltyamount = penaltyAmount;

        return penaltyAmount;
    }

    @Override
    public void withdraw(double amount) {
        if(super.getBalance()-amount>0) {
            super.setBalance(super.getBalance() - amount);
            LocalDateTime currentDateTime = LocalDateTime.now();
            super.statement[count++] = new Statement(false, amount, super.getBalance(), currentDateTime);
            System.out.println("Withdraw Done Successfully");
        }else System.out.println("Insufficient Balance to Withdraw");
    }



}
