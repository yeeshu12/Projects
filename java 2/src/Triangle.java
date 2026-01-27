import java.util.Scanner;

public class Triangle extends Rectangle {
    public Triangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public int c;

    @Override
    public void printInfo() {
        System.out.println("Triangle: " + a + "," + b + "," + c + " P=" + (a + b + c) + " S=" + (a * b / 2));
    }

    public static IFigure registerFigure(Scanner sc) {
        System.out.println("Enter Rectangle side A size: ");
        var sideA = Program.GetNumber(sc);
        System.out.println("Enter Rectangle side B size: ");
        var sideB = Program.GetNumber(sc);
        System.out.println("Enter Rectangle side C size: ");
        var sideC = Program.GetNumber(sc);
        return new Triangle(sideA, sideB, sideC);
    }
}