package com.algorithmspractice.array;
//Implement pow(x, n).
//
//        Example 1:
//
//        Input: 2.00000, 10
//        Output: 1024.00000
//        Example 2:
//
//        Input: 2.10000, 3
//        Output: 9.26100


public class PowXN {
    public static void main(String[] args) {
        System.out.println(myPow(2, -3));
        System.out.println(myPow(0, -3));
        System.out.println(myPow(-2, 3));
        System.out.println(myPow(-2, -3));
        System.out.println(myPow(2, Integer.MIN_VALUE));
    }
    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if( n == Integer.MIN_VALUE){
            return 1+ n;
        }
        if(n < 0){
            x = 1/x;
            n = -n;
        }

        double t = myPow(x, n/2);
        return n % 2 == 0 ? t*t: t*t*x;
    }
}
