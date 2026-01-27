import java.util.Scanner;

public class Figure implements IFigure {
    public int a;

    public Figure(int a) {
        this.a = a;
    }

    public void printInfo() {
        System.out.println("Square: " + a + " P= " +  (4 * a) + " S=" + (a * a));
    }
    public static IFigure registerFigure(Scanner sc) {
        System.out.println("Enter Square side size: ");
        var side = Program.GetNumber(sc);
        return new Figure(side);
    }
}