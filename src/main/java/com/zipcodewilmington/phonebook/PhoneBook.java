package com.zipcodewilmington.phonebook;
import java.util.*;
import java.util.HashMap;
/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 * ^^^what on earth is a hashmap
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;
    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }
    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }
    public void add(String name, String phoneNumber) {
        List<String> newNum = new ArrayList<>();
        newNum.add(phoneNumber);
        this.phonebook.putIfAbsent(name, newNum);
    }
    public void addAll(String name, String... phoneNumbers) {
        List<String> joeNum = phonebook.get(name);
        if (phonebook.containsKey(name)){
            for (int i = 0; i < phoneNumbers.length; i++) {
                joeNum.add(phoneNumbers[i]);
            }
            phonebook.put(name, joeNum);
        } else {
            List<String> newNumber = new ArrayList<>(Arrays.asList(phoneNumbers));
        }
//        phNumbers.add(phoneNumbers);
        phonebook.put(name, joeNum);
    }

    public void remove(String name) {
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {

        return null;
    }
}
