import java.awt.*;
import java.util.Scanner;
import java.util.Scanner;

public class Rectangle extends Figure {

    public Rectangle(int a, int b) {
        super(a);
        this.b = b;
    }
    public final int b;
    @Override
    public void printInfo() {
        System.out.println("Rectangle: " + a + "," + b + " P=" + (2 * a * 2 * b) + " S=" + (a * b));
    }
    public static IFigure registerFigure(Scanner sc) {
        System.out.println("Enter Rectangle side A size: ");
        var sideA = Program.GetNumber(sc);
        System.out.println("Enter Rectangle side B size: ");
        var sideB = Program.GetNumber(sc);
        return new Rectangle(sideA, sideB);
    }
}

