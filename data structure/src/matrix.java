import java.util.ArrayList;
public class matrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                matrix.get(i).add(j);
            }
        }
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i));
        }
        System.out.print("1Diagonal : ");
        for (int i = 0; i < matrix.size(); i++) {
            System.out.print(matrix.get(i).get(i));
        }
        System.out.println("\n2Diagonal :");
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i).get(matrix.size() - 1 - i));
        }
    }
}
        // 0 1 2 3 4 5
        // 0 5 1 4 2 3


//chart typr matrix 10*10 player character
/*
        */