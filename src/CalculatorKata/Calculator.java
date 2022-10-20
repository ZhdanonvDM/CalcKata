package CalculatorKata;

import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        String str = in.nextLine();
        System.out.println("Результат:");
        System.out.println(calc (str));
    }

    public static String calc(String s) throws Exception {
        String[] subStr;
        boolean checkOperator = false;
        char o1, o2; // для проверки является ли операнд римской
        // или арабской цифрой (А - арабское число, R - римское, N - ни то, ни другое)
        String CheckExpression;
        String delimeter = " "; // Разделитель
        subStr = s.split(delimeter); // Разделения строки str с помощью метода split()

// Проверяем длину строки - не более 3-х символов
        if (subStr.length != 3) {
            throw new Exception("Слишком много/мало аргументов");
        }

// Проверяем, чтобы оператор был длиной не более 2-х символов
        if (subStr[1].length() > 1) {
            throw new Exception("Так нельзя, " + subStr[1] + " - это не матемитический оператор");
        }
        o1 = RimOrArab.valid(subStr[0]);
        o2 = RimOrArab.valid(subStr[2]);
        String s1 = null;
        if (o1 == 'N' || o2 == 'N') {
            throw new Exception("Проверьте правильность ввода чисел");
        }
        CheckExpression = String.valueOf(o1) + String.valueOf(o2);
        switch (CheckExpression) {
            case "AA":
                s1 = RimOrArab.arabOperation(subStr[0], subStr[2], subStr[1]);
               break;
            case "RR":
                s1 = RimOrArab.rimOperation(subStr[0], subStr[2], subStr[1]);
               break;
            case "AR":
            case "RA":
                throw new Exception("Используются одновременно разные системы счисления");
            case "NN":
                System.out.println("Введенные вами числа не проходят по условиям");
                break;
        }
        return s1;
    }
}






