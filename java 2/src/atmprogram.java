import java.util.ArrayList;
import java.util.Scanner;

public class atmprogram {
    public static ArrayList<BankClient> clients;
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        do {
            clients = getClients();
            var client = AuthorizeClient(sc);
            var inp = "";
            do {
                printMenu();
                inp = sc.nextLine().trim();
                switch (inp) {
                    case "1" -> client.addmoney(sc);
                    case "2" -> client.takemoney(sc);
                    case "3" -> System.out.println("logout");
                    default -> System.out.println("Invalid input");
                }
            } while (!inp.equals("3"));
        } while (true);
    }
    private static void printMenu() {
        System.out.println("1. add money");
        System.out.println("2. take money");
        System.out.println("3. exit");
    }
    private static BankClient AuthorizeClient(Scanner sc) {
        do {
            System.out.println("Enter username: ");
            var username = sc.nextLine();
            System.out.println("Enter password: ");
            var password = sc.nextLine();
            for (var client : clients) {
                if(client.validate(username, password)) {
                    return client;
                }
            }
            System.out.println("Access denied");
        }while (true);
    }
    private static ArrayList<BankClient> getClients() {
        var result = new ArrayList<BankClient>();
        result.add(new BankClient("a", "a"));
        result.add(new BankClient("a1", "a1"));
        return result;
    }
}
