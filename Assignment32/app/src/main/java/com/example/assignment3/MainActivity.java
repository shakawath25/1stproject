package com.example.assignment3;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String USERNAME_REGEX = "^[A-Za-z]\\w{5,29}$";
    private static final String NAME_REGEX = "^[A-Za-z]{2,30}$";

    private boolean isValidEmail(String email) {
        return validateWithRegex(email, EMAIL_REGEX);
    }

    private boolean isValidUsername(String username) {
        return validateWithRegex(username, USERNAME_REGEX);
    }

    private boolean isValidName(String name) {
        return validateWithRegex(name, NAME_REGEX);
    }

    private boolean validateWithRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public String registerUser(String username, String email, String password, String confirmPassword, String name, String mobile) {
        if (!isValidUsername(username)) {
            return "Invalid username. Must be alphanumeric, start with a letter, and be 6-30 characters.";
        }
        if (!isValidEmail(email)) {
            return "Invalid email format.";
        }
        if (!isValidName(name)) {
            return "Invalid name. Only letters allowed and length must be 2-30 characters.";
        }
        if (!password.equals(confirmPassword)) {
            return "Passwords do not match.";
        }
        if (mobile.length() != 10) {
            return "Invalid mobile number. Must be 10 digits.";
        }

        return "Registration successful!";
    }

    public void onRegisterClick(Context context, String username, String email, String password, String confirmPassword, String name, String mobile) {
        String result = registerUser(username, email, password, confirmPassword, name, mobile);
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

    public void onLoginClick(Context context) {
        Toast.makeText(context, "Login clicked", Toast.LENGTH_SHORT).show();
    }
}