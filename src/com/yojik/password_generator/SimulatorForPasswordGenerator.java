package com.yojik.password_generator;

import java.io.ByteArrayOutputStream;


public class SimulatorForPasswordGenerator {

    static int lengthOfPassword = 16;

    public static void main(String[] args) {
        ByteArrayOutputStream password = PasswordGenerator.generatePassword(lengthOfPassword);
        System.out.println();
        System.out.println("Generated " + lengthOfPassword + "-number password: " + password);

    }
}
