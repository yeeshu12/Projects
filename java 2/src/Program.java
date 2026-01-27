import java.util.Scanner;

public class Program {

    public static int GetNumber(Scanner sc) {
        var str = "";
        do {
            str = sc.nextLine();
        } while (str.isEmpty());

        try {
            var arr = str.toCharArray();
            for (char c : arr) {
                if (!Character.isDigit(c)) {
                    System.out.println("Invalid input. Please enter a number.");
                    return GetNumber(sc);
                }
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("input too large, TRY AGAIN!");
            return GetNumber(sc);
        }
    }
}

