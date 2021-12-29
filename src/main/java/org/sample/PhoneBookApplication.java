package org.sample;

import java.util.Scanner;

public class PhoneBookApplication {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        Contact contact1 = new Contact("Ada", "0907865467", "oiuy@email.com");
        Contact contact2 = new Contact("Aria", "0807865467", "oiiip");
        Contact contact4 = new Contact("ida", "0909865467", "oiuy@email.com");
        Contact contact3 = new Contact("hria", "0817865467", "oiiip");

        phoneBook.add(contact1);
        phoneBook.add(contact2);
        phoneBook.add(contact3);
        phoneBook.add(contact4);

        consoleApp(phoneBook);

    }

    public static void consoleApp(PhoneBook phoneBook) {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("list of available function for phone book:");
        System.out.println("press 1 to create new contact");
        System.out.println("press 2 to view a contact");
        System.out.println("press 3 to view contact list");
        System.out.println("press 4 to to filter contact list by alphabet");
        System.out.println("press q to quit app");

        String instruction = input.next();

        switch (instruction) {
            case "1":
                createContact(phoneBook, input);
                return;
            case "2":
                getUniqueContact(phoneBook, input);
                return;
            case "3":
                getContactList(phoneBook);
                return;
            case "4":
                getContactListByAlphabet(phoneBook, input);
                return;
            case "q":
                return;
            default:
                System.out.println("invalid instruction inputted");
                consoleApp(phoneBook);
        }
    }

    static void createContact(PhoneBook phoneBook, Scanner input) {
        System.out.println();
        System.out.println("Create New Contact");
        System.out.println("-------------------");

        System.out.println("input phone number");
        String phoneNumber = input.next();

        System.out.println();
        System.out.println("input contact name");
        String name = input.next();

        System.out.println("input contact email");
        String email = input.next();

        Contact contact = new Contact(name, phoneNumber, email);

        try {
            phoneBook.add(contact);
            System.out.println("contact added to phone book");
        } catch (Exception ex) {
            System.out.print("Error: ");
            System.out.println(ex.getMessage());
            System.out.println("Contact not created");
        }
        consoleApp(phoneBook);
    }

    static void getUniqueContact(PhoneBook phoneBook, Scanner input) {
        System.out.println();
        System.out.println("Get Contact by Phone Number");
        System.out.println("---------------------------");

        System.out.println("input contact phone number");
        String phoneNumber = input.next();

        Contact contact = phoneBook.getUniqueContact(phoneNumber);
        if (contact == null)
            System.out.printf("contact with phone number: %s does not exist", phoneNumber);

        System.out.println(contact);
        consoleApp(phoneBook);
    }

    static void getContactList(PhoneBook phoneBook) {
        System.out.println();
        System.out.println("Contact List");
        System.out.println("-------------");
        printPhoneBook(phoneBook);

        consoleApp(phoneBook);
    }

    static void getContactListByAlphabet(PhoneBook phoneBook, Scanner input) {
        System.out.println();
        try {
            System.out.println("input alphabet for filter");
            String alphabet = input.next("[a-z]");

            System.out.println("Contact List With Alphabet");
            System.out.println("---------------------------");
            printPhoneBook(phoneBook.getListOfContactByAlphabet(alphabet));
        } catch (Exception ex) {
            System.out.println("required input, has to be a character between a - z");
        }
        consoleApp(phoneBook);
    }

    static void printPhoneBook(PhoneBook phoneBook) {
        System.out.println("{");
        for (Contact contact : phoneBook)
            System.out.println(contact);
        System.out.println("}");
    }
}
