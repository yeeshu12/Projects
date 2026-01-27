import java.util.Scanner;

/*public class BankClient {
    public String login;
    public String password;
    public double balance;
    public BankClient(String l, String p) {
        login  = l;
        password = p;
        balance = 100;//default 100$
    }
}*/
public class BankClient {
    private String login;
    private String password;
    private double balance;

    public BankClient(String l, String p) {
        login = l;
        password = p;
        balance = 100;//default 100$
    }

    public boolean validate(String l, String p) {
        return login.equals(l) && password.equals(p);
    }

    public void takemoney(Scanner sc) {
        var n = Program.GetNumber(sc);//from prev. lectures

        if (balance < n)
            System.out.println("Sorry, you have no money");
        else {
            balance -= n;
            System.out.println("Money: " + balance);
        }
    }

    public void addmoney(Scanner sc) {
        var n = Program.GetNumber(sc);//from prev. lectures
        balance += n;
        System.out.println("Money: " + balance);
    }

    public void printBalance() {
        System.out.println("Balance: " + balance);
    }
}
