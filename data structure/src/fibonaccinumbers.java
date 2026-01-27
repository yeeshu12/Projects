public class fibonaccinumbers {
    public static int sumofdigits(int n) {
        System.out.println(n);

        if (n <= 1) {
            return n;
        } else {
            int resultofFunc = sumofdigits(n / 10);

            int result = (n % 10) + resultofFunc;

            System.out.println("calculated result for: " + n + " resultoffunc: " +
                    resultofFunc);

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(sumofdigits(1234));
    }
}