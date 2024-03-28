package utils;

import java.util.ArrayList;

public class ImportantFunctions {

    public static void printPrimalsList(ArrayList<Integer> primalsList) {
        if (primalsList.isEmpty()) {
            System.out.println("Lista vazia");
        }
        for (int num : primalsList) {
            System.out.println(num);
        }
    }

    public static Boolean primalVerifier(Integer number) {
        if (number > 0 && number <= 2) return true;

        for (int i=2; i<= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
