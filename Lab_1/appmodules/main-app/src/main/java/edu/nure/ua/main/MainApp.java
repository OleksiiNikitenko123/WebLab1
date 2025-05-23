package edu.nure.ua.main;

import edu.nure.ua.bank.impl.BankImpl;
import edu.nure.ua.service.impl.ServiceImpl;
import edu.nure.ua.dto.BankCardType;
import edu.nure.ua.dto.User;
import edu.nure.ua.service.api.Service;
import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        var user1 = new User("John", "Doe", LocalDate.of(1960, 2, 2));
        var user2 = new User("Doe", "John", LocalDate.of(2015, 3, 3));
        var user3 = new User("Tom", "Tommy", LocalDate.of(2008, 4, 4));


        var bank = new BankImpl();
        var creditCard1 = bank.createBankCard(user1, BankCardType.CREDIT);
        var creditCard2 = bank.createBankCard(user2, BankCardType.CREDIT);
        var creditCard3 = bank.createBankCard(user3, BankCardType.DEBIT);

        var service = new ServiceImpl();
        service.subscribe(creditCard1);
        service.subscribe(creditCard2);
        service.subscribe(creditCard3);

        var subscription = service.getSubscriptionByBankCardNumber(creditCard1.getNumber());
        subscription.ifPresent(sub -> System.out.println("Subscription: " + sub + "\n"));

        var allUsers = service.getAllUsers();
        System.out.println("All users: " + allUsers + "\n");

        System.out.println("Average age: " + service.getAverageUsersAge() + "\n");


        System.out.println(" Is payable " + user1.getName() + " " + user1.getSurname() + "? - " + Service.isPayableUser(user1));
        System.out.println(" Is payable " + user2.getName() + " " + user2.getSurname() + "? - " + Service.isPayableUser(user2));
        System.out.println(" Is payable " + user3.getName() + " " + user3.getSurname() + "? - " + Service.isPayableUser(user3));
    }
}