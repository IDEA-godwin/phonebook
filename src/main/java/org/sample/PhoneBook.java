package org.sample;

import java.util.HashSet;
import java.util.stream.Collectors;

public class PhoneBook extends HashSet<Contact> {

    public PhoneBook() {
        super();
    }

    @Override
    public boolean add(Contact contact) {
        boolean exists = this.stream()
            .anyMatch(c -> c.getPhoneNumber().equals(contact.getPhoneNumber()));
        if (exists) {
            throw new ContactExistenceException("contact with phone number exists");
        }
        return super.add(contact);
    }

    public Contact getUniqueContact(String phoneNumber) {
        return this.stream()
            .filter(c -> c.getPhoneNumber().equals(phoneNumber))
            .findFirst()
            .orElse(null);
    }

    public PhoneBook getListOfContactByAlphabet(String alphabet) {
        return this.stream()
            .filter(c -> c.getName().toLowerCase().startsWith(alphabet))
            .collect(Collectors.toCollection(PhoneBook::new));
    }

    private static class ContactExistenceException extends RuntimeException {
        public ContactExistenceException(String message) {
            super(message);
        }
    }
}
