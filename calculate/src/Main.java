import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            System.out.println(calc(input));

        }
    }

    public static String calc(String itog) {
        String[] split = itog.split(" ");

        String one = split[0];
        String znak = split[1];
        String two = split[2];

        int oneInt = 0;
        int twoInt = 0;
        int result = 0;

        if (checkNumOrString(one) && checkNumOrString(two)) {
            oneInt = checkNum(one);
            twoInt = checkNum(two);
            result = count(oneInt, twoInt, znak);
            return String.valueOf(result);
        } else {
            oneInt = converterToNum(one);
            twoInt = converterToNum(two);
            result = count(oneInt, twoInt, znak);
            String romResult = converterToRom(result);
            return romResult;
        }

    }

    public static boolean checkNumOrString(String num) {
        char[] charArray = num.toCharArray();
        if (Character.isDigit(charArray[0])) {
            return true;
        } else {
            return false;
        }
    }

    public static int checkNum(String num) {
        if (Integer.parseInt(num) > 0 && Integer.parseInt(num) < 11) {
            return Integer.parseInt(num);

        } else {
            throw new RuntimeException("Введите число от 1 до 10");
        }
    }

    public static int count(int oneInt, int twoInt, String znak) {
        return switch (znak) {
            case "+" -> oneInt + twoInt;
            case "-" -> oneInt - twoInt;
            case "*" -> oneInt * twoInt;
            case "/" -> oneInt / twoInt;
            default -> throw new RuntimeException("Введите корректный арифметический знак");
        };
    }

    public static int converterToNum(String numRom) {
        return switch (numRom) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new RuntimeException("Введите число от I до X");
        };
    }

    public static String converterToRom(int num) {
        String[] roman = {
                null, " I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[num];
    }


}