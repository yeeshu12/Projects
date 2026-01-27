import java.util.Random;

public class charmatrixClass {
    static int size = 5;
    static char[][] grid = new char[size][size];
    static boolean[][] visited = new boolean[size][size];
    static int startX = 0, startY = 0;
    static int goalX = 4, goalY = 4;
    static int moveCount = 0;

    public static void main(String[] args) {
        initializeGrid();
        placeObstacles();
        grid[startX][startY] = 'P';
        grid[goalX][goalY] = 'G';
        printGrid();

        if (findPath(startX, startY)) {
            System.out.println("Path found in " + moveCount + " moves.");
            grid[goalX][goalY] = 'W';
        } else {
            System.out.println("No path found.");
        }
        printGrid();
    }

    static void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '*';
            }
        }
    }

    static void placeObstacles() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int randY = rand.nextInt(size);
            if ((i == startX && randY == startY) || (i == goalX && randY == goalY)) continue;
            grid[i][randY] = '#';
        }
    }

    static boolean findPath(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size || grid[x][y] == '#' || visited[x][y]) {
            return false;
        }
        if (x == goalX && y == goalY) {
            return true;
        }

        visited[x][y] = true;
        grid[x][y] = 'P';
        printGrid();
        moveCount++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            if (findPath(x + dx[i], y + dy[i])) {
                return true;
            }
        }

        grid[x][y] = '*';
        return false;
    }

    static void printGrid() {
        for (char[] row : grid) {
            System.out.println(row);
        }
        System.out.println();
    }
}
























        /*
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int size = 5, row = 0, col = 0;


        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                matrix.get(i).add('o');
            }
        }
        matrix.get(0).set(0, 'P');
        matrix.get(4).set(4, 'G');

        matrix.get(1).set(2, '#');
        matrix.get(1).set(3, '#');
        matrix.get(1).set(0, '#');
        matrix.get(2).set(3, '#');
        matrix.get(4).set(3, '#');


        printMatrix(matrix);

        while (true) {
            System.out.print("Enter move (w/a/s/d = move, t = teleport, q = quit): ");
            char move = scanner.next().charAt(0);
            if (move == 'q') break;

            int newRow = row, newCol = col;
            if (move == 't') {
                newRow = 4;
                newCol = 4;
            } else {
                if (move == 'w') newRow = Math.max(0, row - 1);
                if (move == 's') newRow = Math.min(size - 1, row + 1);
                if (move == 'a') newCol = Math.max(0, col - 1);
                if (move == 'd') newCol = Math.min(size - 1, col + 1);
            }
            if (matrix.get(newRow).get(newCol) != '#') {
                matrix.get(row).set(col, '.');
                matrix.get(newRow).set(newCol, 'P');
                row = newRow;
                col = newCol;
            }
            printMatrix(matrix);
        }
        scanner.close();
    }
    private static void printMatrix(ArrayList<ArrayList<Character>> matrix) {
        int size = matrix.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 0; j < size; j++) {
                    System.out.print("+---");
                }
                System.out.println("+");
            }
            System.out.print("  ");
            for (int j = 0; j < size; j++) {
                System.out.print("| " + matrix.get(i).get(j) + " ");
            }
            System.out.println("|");
            System.out.print("  ");
            for (int j = 0; j < size; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}

         */
/*
        using recurcsion to calculate end fibonacci number

 */
