package com.example.trainsystem.util;

import java.util.Random;

public class GenerateCardNumber {
    public static String generateCardNumber(){
        Random random = new Random();

        // Generate a random number with 10 digits
        long randomNumber = Math.abs(random.nextLong() % 10000000000L);

        // Convert the random number to a string
        String randomString = String.valueOf(randomNumber);

        return randomString;
    }
}
