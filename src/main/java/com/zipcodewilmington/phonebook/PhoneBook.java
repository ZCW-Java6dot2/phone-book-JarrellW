package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        phonebook.put(name, phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> phoneNumbersList = Arrays.asList(phoneNumbers);
        phonebook.put(name, phoneNumbersList);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        List<String> numbers = phonebook.get(name);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == phoneNumber) {
                return true;
            }

        }
        return false;
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> p : phonebook.entrySet()) {
            if (p.getValue().contains(phoneNumber)) {
                return p.getKey();
            }

        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contacts = new LinkedList<>();
        for (String cn : phonebook.keySet()) {
            contacts.add(cn);

        }
        return contacts;

    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
