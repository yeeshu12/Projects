import java.util.ArrayList;
import java.util.Scanner;

public class gamematrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> charmatrix = new ArrayList<>();
        int size = 10;
        int row = 0, col = 0;

        for (int i = 0; i < 0; i++) {
            charmatrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if(i == 0 && j == 0){
                    charmatrix.get(row).add("P");
                } else {
                    charmatrix.get(row).add("o");
                }
            }
        }
        while(true) {
            System.out.println("Enter move (w = up, a = left, s = down, d = right, q = quit): ");
            char move = sc.next().charAt(0);

            if (move == 'q') {
                System.out.println("Game over!");
                break;
            }
            int nrow = row;
            int ncol = col;

            switch (move) {
                case 'w': nrow = Math.max(0, nrow - 1);
                break;
                case 's': ncol = Math.min(0, ncol - 1);
            }
        }
    }
    
}
