package com.rammar;

import java.util.Scanner;

public class MyScanner {
    private static final MyScanner instance = new MyScanner();
    private final Scanner scan;

    private MyScanner() {
        this.scan = new Scanner(System.in);
    }

    public static MyScanner getInstance() {
        return instance;
    }

    public Scanner getScanner() {
        return instance.scan;
    }
}
