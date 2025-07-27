package com.example.pan_validator.utils;
import java.util.regex.Pattern;

public class PanUtils {


    // Regex for PAN format: 5 letters + 4 digits + 1 letter (e.g., "ABCDE1234F")
    private static final String PAN_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";

    // Validate PAN format
    public static boolean isValidPanFormat(String pan) {
        return Pattern.matches(PAN_REGEX, pan);
    }

    // (Optional) Mock govt verification (replace with actual scraping later)
    public static boolean isGovtVerified(String pan) {
        // Simulate govt verification (e.g., via NSDL API)
        return isValidPanFormat(pan) && pan.charAt(4) == '1'; // Mock: 5th char must be '1'
    }


}
