import java.util.Scanner;

public class pallindromeno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no: ");
        int n = sc.nextInt();
        sc.close();

        if (isPalindrome (n)) {
            System.out.println(sc + " is a Palindrome number.");
        }else{
            System.out.println(sc + " is not a Palindrome number.");
        }
    }
    public static boolean isPalindrome(int n) {
        int originalnum = n;
        int reversednum = 0;

        while (n != 0) {
            int digit = n % 10;
            reversednum = reversednum * 10 + digit;
            n /= 10;
        }
        return originalnum == reversednum;
    }
}
