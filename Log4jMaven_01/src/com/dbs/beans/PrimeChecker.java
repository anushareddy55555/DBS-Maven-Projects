package com.dbs.beans;

public class PrimeChecker {
    public boolean check(int num) {
        System.out.println("checking the number " +num);
        for(int c=2;c<num;c++) {
            if(num%c==0){
                System.out.println("returning true with " +num);
                return false;
            }
        }
        System.out.println("returning true with " +num);
        return true;
    }
}
