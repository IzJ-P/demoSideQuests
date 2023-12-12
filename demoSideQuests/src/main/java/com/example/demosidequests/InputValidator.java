package com.example.demosidequests;

import java.time.LocalDate;

public class InputValidator {
    // THANK YOU, MR CONTI!
    // Learned in my C# class, creating a validation class for all data

    public static boolean isValidDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        return date != null && !date.isBefore(today);
    }
    public static boolean isValidName(String name){

        String stringName = "^[a-zA-Z]+$";
        return name.matches(stringName);

    }

    public static boolean isValidInteger(String value) {
        try {
            int intValue = Integer.parseInt(value);
            return intValue > 0;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
