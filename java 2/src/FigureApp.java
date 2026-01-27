import java.util.ArrayList;
import java.util.Scanner;

public class FigureApp {
    static ArrayList<IFigure> figures;
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var str = "";
        figures = new ArrayList<>();
        do {
            System.out.println("1. Add figure");
            System.out.println("2. Show all");
            str = sc.nextLine();
            switch (str) {
                case "1" -> addFigure(sc);
                case "2" -> showAll();
            }
        }while (!str.equals("3"));
    }
    private static void showAll() {
        for (IFigure figure : figures) {
            figure.printInfo();
        }
    }
    private static void addFigure(Scanner sc) {
        System.out.println("Enter the type of the figure: ");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        var type = sc.nextLine();

        switch (type) {
            case "1" -> figures.add(Figure.registerFigure(sc));
            case "2" -> figures.add(Rectangle.registerFigure(sc));
            case "3" -> figures.add(Triangle.registerFigure(sc));
        }
    }
}