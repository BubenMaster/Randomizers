package com.yojik.password_generator;

import com.yojik.range_splitter.RangeRandomSplitter;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class SimulatorForPasswordGenerator {

    static int lengthOfPassword = 8;

    public static void main(String[] args) {
        ByteArrayOutputStream password = PasswordGenerator.generatePassword(lengthOfPassword);
        System.out.println();
        System.out.println("Generated " + lengthOfPassword + "-number password: " + password);

    }
}
