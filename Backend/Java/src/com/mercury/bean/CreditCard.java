package com.mercury.bean;

import java.io.Serializable;

// serialize - deserialize

// 1. Serializable is a marker interface
// 2. use transient to hide a field from serialization
// 3. deserialization will create a new object, but NOT calling any constructor
// 4. static field will NOT be serialized
// 5. except serialVersionUID
public class CreditCard implements Serializable, Comparable<CreditCard> {
    transient private String number;
    private String holder;
    private String zipcode;
    public static String bank = "BOA";

    private static final long serialVersionUID = -1L;

    public CreditCard() {
        System.out.println("Creating cc");
    }

    public CreditCard(String number, String holder, String zipcode) {
        System.out.println("Creating cc with info");
        this.number = number;
        this.holder = holder;
        this.zipcode = zipcode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", holder='" + holder + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}' + " --- " + bank;
    }

    @Override
    public int compareTo(CreditCard input) {
        // comparing this vs input
        // return positive : this > input
        // return 0 : this = input
        // return negative : this < input

        // null check
//        return Integer.parseInt(this.number) - Integer.parseInt(input.number);
        return 1;
    }
}
