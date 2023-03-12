package com.zipcodewilmington.phonebook;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
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
        this.phonebook = new LinkedHashMap<>();
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
                joeNum.add(phoneNumbers[i]);  // intellij suggests copying to line 31 List newNumber
            }
            phonebook.put(name, joeNum);
        } else {
            List<String> newNumber = new ArrayList<>(Arrays.asList(phoneNumbers)); // this one
            phonebook.put(name, newNumber);
        }
    }
    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String s : phonebook.keySet())
            if (phonebook.get(s).contains(phoneNumber))
                return s;
//        for (Entry<String, List<String>> entry: phonebook.entrySet() )
//            if(Objects.equals(entry.getValue().toString(), phoneNumber)){
//                return entry.getKey();
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> holder = new ArrayList<>();
        for (String s : phonebook.keySet()) {
            holder.add(s);
        }
        return holder;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
