package com.dbs.app;

import com.dbs.beans.PrimeChecker;

public class App_01 {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        PrimeChecker primeChecker=new PrimeChecker();
        System.out.println("17 is prime " + primeChecker.check(17));
        System.out.println("23 is prime " +primeChecker.check(23));
        System.out.println("25 is prime " +primeChecker.check(25));
    }
}
