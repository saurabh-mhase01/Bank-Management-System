package com.bank;

import java.util.Scanner;
import com.accounts.*;

public class Main {
    static int accCount = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Account[] arr = new Account[50];
        int choice;
        do {
            System.out.println("Main Menu");
            System.out.println("1. Open New Account");
            System.out.println("2. Account Login");
            System.out.println("3. Admin login");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> OpenNewAccount(arr);
                case 2 -> AccountLogin(arr);
            }
        } while (choice != 4);

    }

    static void OpenNewAccount(Account[] arr) {
        long accountNo;
        String name,address;
        long aadharNo;
        int pin;

        System.out.println("Enter type of Account \n1.Saving\n2.Salary\n3.Current\n4.LoanAccount");
        int choice ;
        choice = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter the Account Holder Name: ");
        name = sc.nextLine();
        System.out.print("Enter the AccountNo: ");
        accountNo = sc.nextLong();
        System.out.print("Enter the AadharNo: ");
        aadharNo = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter the Address: ");
        address = sc.nextLine();
        System.out.print("Enter the Login pin: ");
        pin = sc.nextInt();

        switch (choice) {
            case 1 -> arr[accCount++] = new SavingAccount(accountNo, name, aadharNo, address, pin);
            case 2 -> arr[accCount++] = new SalaryAccount(accountNo, name, aadharNo, address, pin);
            case 3 -> arr[accCount++] = new CurrentAccount(accountNo, name, aadharNo, address, pin);
            case 4 -> arr[accCount++] = new LoanAccount(accountNo, name, aadharNo, address, pin);
        }

    }
    static void AccountLogin(Account[] arr) {

        long accountNo;
        int pin;

        System.out.println("Enter the Account Number: ");
        accountNo = sc.nextLong();

        boolean isaccfound =false;
        for(int i =0;i<accCount;i++) {
            if(arr[i].getAccountNo()==accountNo) {
                isaccfound = true;
                System.out.println("Account Found: ");

                System.out.println("Enter the Login pin: ");
                pin = sc.nextInt();

                if(arr[i].getPin()==pin) {
                    basicbankActivity(arr[i]);
                }
                break;
            }
        }
        if(isaccfound==false){
            System.out.println("Account Not Found: ");
        }


    }

    private static void basicbankActivity(Account account) {
        String type ;

        int choice;
        do {
            System.out.println("Welcome "+account.getName());
            System.out.println("1. Withdraw \n2. Deposit \n3. Check Balance \n4. Show Statement \n5. Other Options \n6 Logout");
            System.out.println("Enter the choice :");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    double amount;
                    System.out.println("Enter the amount to Withdraw");
                    amount = sc.nextDouble();
                    account.withdraw(amount);
                    System.out.println("Your Balance is : " + account.getBalance());
                }
                case 2 -> {
                    double amount;
                    System.out.println("Enter the amount to Deposit");
                    amount = sc.nextDouble();
                    account.deposit(amount);
                    System.out.println("Your Balance is : " + account.getBalance());
                }
                case 3 -> System.out.println("Your Balance is : " + account.getBalance());
                case 4 -> account.getTransections();
                case 5 -> otherOptions(account);
            }
        }while(choice !=6);
    }

    private static void otherOptions(Account account) {
        if(account instanceof SalaryAccount){
            SalaryAccount acc = (SalaryAccount)account;
            System.out.println("1. Account Unfreeze\n2.Setdate for freeze");
            int choice = sc.nextInt();
            switch(choice){
                case 1->{
                    acc.makeunFreeze();
                }
                case 2->{
                     System.out.println("Enter the date for Freeze in yyy-mm-dd format");
                     String date = sc.nextLine();
                     DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MMM-dd");
                     LocalDate lDate = new LocalDate().parse(date,format);
                     acc.setlasttransectiondate(lDate);
                }
            }
        }
        // if(account instanceof SavingAccount ){
            // nofunction to down cast

        // }
        if(account instanceof LoanAccount ){

        }
        if(account instanceof CurrentAccount){

        }
    }


}