package secretaria;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um numero");

        try {

            int n = sc.nextInt();
                if (n >= 0) {
                    if (isPrime(n)) {
                        System.out.println(n + " numero é primo");
                    } else {
                        System.out.println(n + " nao é primo");
                    }
                } else {
                    System.out.println("entrada invalida");
                }
            }
         catch (Exception e) {
            System.out.println("entrada invalida");
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num / 2; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
