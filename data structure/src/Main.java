import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int size = 5;
        int playerRow = 0, playerCol = 0;
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if (i == 0 && j == 0) {
                    matrix.get(i).add('p');
                } else {
                    matrix.get(i).add('.');
                }
            }
        }
        printMatrix(matrix);
        while (true) {
            System.out.print("Enter move (w = up, a = left, s = down, d = right, q = quit): ");
            char move = scanner.next().charAt(0);

            if (move == 'q') {
                System.out.println("Game over!");
                break;
            }
            int newRow = playerRow;
            int newCol = playerCol;

            switch (move) {
                case 'w': newRow = Math.max(0, playerRow - 1); break;
                case 's': newRow = Math.min(size - 1, playerRow + 1); break;
                case 'a': newCol = Math.max(0, playerCol - 1); break;
                case 'd': newCol = Math.min(size - 1, playerCol + 1); break;
                default:
                    System.out.println("Invalid input! Use w, a, s, d to move, or q to quit.");
                    continue;
            }
            matrix.get(playerRow).set(playerCol, '.');
            matrix.get(newRow).set(newCol, 'p');
            playerRow = newRow;
            playerCol = newCol;
            printMatrix(matrix);
        }
        scanner.close();
    }
    private static void printMatrix(ArrayList<ArrayList<Character>> matrix) {
        for (ArrayList<Character> row : matrix) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
