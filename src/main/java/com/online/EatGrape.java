package com.online;

import org.junit.Test;

import java.util.Scanner;

public class EatGrape {
    long solution(long a, long b, long c){
        long res = a + b + c;
        long X = 0, Y = 0, Z = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    X = i + b - j;
                    Y = k + a - i;
                    Z = j+ c - k;
                    long mv = Math.max(X, Math.max(Y, Z));
                    res = res < mv ? res : mv;
                }
            }
        }

        return res;
    }

    @Test
    public void t(){
        System.out.println(this.solution(3,4, 5));
    }

    public static void main(String[] args) {
        long n, a, b, c;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while(n > 0){
            long[] arr = new long[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = scanner.nextInt();
            }


            a = arr[0];
            b = arr[1];
            c = arr[2];
            long res = a + b + c;
            long X = 0, Y = 0, Z = 0;
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    for (int k = 0; k <= c; k++) {
                        X = i + b - j;
                        Y = k + a - i;
                        Z = j+ c - k;
                        long mv = Math.max(X, Math.max(Y, Z));
                        res = res < mv ? res : mv;
                    }
                }
            }

            System.out.println(res);
            n--;
        }

    }
}
