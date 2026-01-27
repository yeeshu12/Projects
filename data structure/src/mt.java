public class mt {

}
































/*public class mt {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.println("Fibonacci(" + i + ") = " + fibonacci(i));
        }
    }
}

 */




















/*import java.util.ArrayList;
import java.util.Random;

public class mt {
    public static int x = 0;
    public static int y = 0;
    public static int goalX = 4;
    public static int goalY = 4;
    public static int countM = 0;

    public static boolean[][] visited;
    public static ArrayList<ArrayList<Character>> matrix;

    public static void main(String[] args) {

        visited = new boolean[5][5];
        matrix = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                matrix.get(i).add('*');
            }
        }
        Random rand = new Random();
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(rand.nextInt(5), '#');
        }

        matrix.get(goalX).set(goalY, 'G');
        matrix.get(x).set(y, 'P');

        printMatrix();

        if (findPath(x, y)) {
            System.out.println("Path found.");
            win();
        } else {
            System.out.println("No path found.");
        }
    }

    private static boolean findPath(int cx, int cy) {
        if (cx == goalX && cy == goalY) {
            return true;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (isValidM(nx, ny)) {
                matrix.get(nx).set(ny, 'P');
                printMatrix();
                countM++;

                if (findPath(nx, ny)) {
                    return true;

                }
                matrix.get(nx).set(ny, '*');
            }
        }
        visited[cx][cy] = false;
        return false;
    }
    private static boolean isValidM(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && matrix.get(x).get(y) != '#' && matrix.get(x).get(y) != 'P';
    }

    public static void printMatrix() {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i));
        }
        System.out.println();
    }

    public static void win() {
        matrix.get(goalX).set(goalY, 'W');
        printMatrix();
        System.out.println("Only " + countM + " moves.");
    }
}

 */







//Scanner scan = new Scanner(System.in);
/*        while (true) {
            printMatrix();
            System.out.println("Enter controls W/S/A/D to move the character.");
            System.out.println("If you want to quit, press 'q' or 'Q'.");



            char input = scan.next().toLowerCase().charAt(0);
            if (input == 'q' || input == 'Q') {
                break;
            } else if (input == 'w') {
                if (x > 0 && matrix.get(x - 1).get(y) != '#') {
                    matrix.get(x).set(y, '*');
                    x--;
                    matrix.get(x).set(y, 'P');
                }
            } else if (input == 's') {
                if (x < 9 && matrix.get(x + 1).get(y) != '#') {
                    matrix.get(x).set(y, '*');
                    x++;
                    matrix.get(x).set(y, 'P');
                }
            } else if (input == 'd') {
                if (y < 9 && matrix.get(x).get(y + 1) != '#') {
                    matrix.get(x).set(y, '*');
                    y++;
                    matrix.get(x).set(y, 'P');
                }
            } else if (input == 'a'){
                if (y > 0 && matrix.get(x).get(y - 1) != '#') {
                    matrix.get(x).set(y, '*');
                    y--;
                    matrix.get(x).set(y, 'P');
                }
            }else {
                System.out.println("Invalid input.");
            }
        }*/


//davitzuroshvili@gmail.com