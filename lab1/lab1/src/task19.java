import java.util.Scanner;

public class task19 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Строка x: ");
        String x = scan.nextLine();
        System.out.print("Строка y: ");
        String y = scan.nextLine();
        int[][] matrix = createMatrix(x, y);
        String temp = "";
        int i = x.length() - 1, j = y.length() - 1;
        while (i >= 0 && j >= 0){
            if(x.charAt(i) == y.charAt(j)){
                temp += x.charAt(i);
                i--;
                j--;
            } else if (matrix[i-1][j] > matrix[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        for(int k = temp.length() - 1; k >= 0; k--){
            System.out.print(temp.charAt(k));
        }

    }

    public static int[][] createMatrix(String x, String y){
        int[][] result = new int[x.length() + 1][y.length() + 1];
        for(int i = 1; i < x.length(); i++){
            for(int j = 1; j < y.length(); j++){

                if (x.charAt(i) == y.charAt(j)){
                    result[i][j] = result[i - 1][j-1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j - 1], result[i-1][j]);
                }
            }
        }
        return result;
    }
}
