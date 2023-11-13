package com.bank;

import java.time.LocalDate;
import java.util.Date;
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
            System.out.println("1. Add Account");
            System.out.println("2. Account Login");
            System.out.println("2. Admin login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice) {
                case  1:{
                    addAccount(arr);
                }break;
                case 2:{

                }
            }
        } while (choice != 6);

    }

    static void addAccount(Account[] arr) {


        long accountNo;
        String name,address;
        long aadharNo;
        int pin;

        System.out.println("Enter type of Account \n 1.Saving\n2.Salary\n3.Current\n4.LoanAccount");
        int choice ;
        choice = sc.nextInt();

        System.out.println("Enter the Account Holder Name: ");
        name = sc.next();
        System.out.println("Enter the AccountNo: ");
        accountNo = sc.nextLong();
        System.out.println("Enter the AadharNo: ");
        aadharNo = sc.nextLong();
        System.out.println("Enter the Address: ");
        address = sc.nextLine();
        System.out.println("Enter the Login pin: ");
        pin = sc.nextInt();

        switch(choice) {
            case 1:{
                arr[accCount++]= new SavingAccount( accountNo,  name,  aadharNo,  address,  pin);
            }
            break;
            case 2:{
                arr[accCount++]= new SalaryAccount( accountNo,  name,  aadharNo,  address,  pin);
            }
            break;
            case 3:{
                arr[accCount++]= new CurrentAccount( accountNo,  name,  aadharNo,  address,  pin);
            }
            break;
            case 4:{
                arr[accCount++]= new LoanAccount( accountNo,  name,  aadharNo,  address,  pin);
            }
            break;
        }

    }
    static void AccountLogin(Account[] arr) {

        long accountNo;
        int pin;

        System.out.println("Enter the Account Holder Name: ");
        accountNo = sc.nextLong();
        System.out.println("Enter the Login pin: ");
        pin = sc.nextInt();

        for(int i =0;i<accCount;i++) {
            if(arr[i].getAccountNo()==accountNo) {
                System.out.println("Account Found: ");

                System.out.println("Enter the Login pin: ");
                pin = sc.nextInt();
                if(arr[i].getPin()==pin) {

                }

            }
        }


    }
}