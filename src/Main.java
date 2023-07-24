import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВедите выражение");
        String input = scanner.nextLine();
        System.out.println("Output: " + calc(input));
    }

    public static String calc(String input) {
        String[] lines = input.split(" ", 3);
        int ind1 = input.indexOf(" ");
        int ind2 = input.lastIndexOf(" ");
        String substr1 = input.substring(0, ind1);
        String substr2 = input.substring(ind2 + 1, input.length());
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VII", "VII", "IX", "X"};
        HashMap<String, String> RiMaRAB = new HashMap<String, String>();
        RiMaRAB.put("I", "1");
        RiMaRAB.put("II", "2");
        RiMaRAB.put("III", "3");
        RiMaRAB.put("IV", "4");
        RiMaRAB.put("V", "5");
        RiMaRAB.put("VI", "6");
        RiMaRAB.put("VII", "7");
        RiMaRAB.put("VIII", "8");
        RiMaRAB.put("IX", "9");
        RiMaRAB.put("X", "10");
        String b = null;
        if ((b == RiMaRAB.get(substr1)) && (b!= RiMaRAB.get(substr2))) {
            throw new InputMismatchException("incorrect value");
        }
        if ((b == RiMaRAB.get(substr2)) && (b!= RiMaRAB.get(substr1))) {
            throw new InputMismatchException("incorrect value");
        }
        if ((b == RiMaRAB.get(substr1)) && (b == RiMaRAB.get(substr2))) {
            int num1 = parseInt(lines[0]);
            int num2 = parseInt(lines[2]);
            if ((num1 < 0) || (num1 > 10) || (num2 < 0) || (num2 > 10))
                throw new InputMismatchException("incorrect value");
            if ((ind2 != -1) && (ind1 != -1)) {
                switch (lines[1]) {
                    case "+":
                        int otvet = num1 + num2;
                        String str21 = Integer.toString(otvet);
                        return str21;
                    case "-":
                        otvet = num1 - num2;
                        str21 = Integer.toString(otvet);
                        return str21;
                    case "*":
                        otvet = num1 * num2;
                        str21 = Integer.toString(otvet);
                        return str21;
                    case "/":
                        otvet = num1 / num2;
                        str21 = Integer.toString(otvet);
                        return str21;
                }
            }
        } else {
            int num1 = parseInt(RiMaRAB.get(substr1));
            int num2 = parseInt(RiMaRAB.get(substr2));
            switch (lines[1]) {
                case "+":
                    int otvet1 = num1 + num2;
                    String otvet = convertNumToRoman(otvet1);
                    return otvet;
                case "-":
                    otvet1 = num1 - num2;
                    otvet = convertNumToRoman(otvet1);
                    int o = otvet1;
                    if (o == 0) throw new InputMismatchException("0 not found");
                    return otvet;
                case "*":
                    otvet1 = num1 * num2;
                    otvet = convertNumToRoman(otvet1);
                    return otvet;
                case "/":
                    otvet1 = num1 / num2;
                    otvet = convertNumToRoman(otvet1);
                    o = otvet1;
                    if (o == 0) throw new InputMismatchException("0 not found");
                    return otvet;
            }
        }
        return substr1;
    }
    static String convertNumToRoman ( int numArabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
}