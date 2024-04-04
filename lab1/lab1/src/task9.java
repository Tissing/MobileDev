import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args){
        int inf = Integer.MAX_VALUE;
        HashMap<Integer, Integer> dictNodes = new HashMap<>();
        int[] nodes = new int[]{1, 2, 3, 4, 5, 6};
        for(int i: nodes){
            dictNodes.put(i, inf);
        }
        ArrayList<Integer> completeNodes = new ArrayList<>(){};
        int[][] edges = new int[][]{
                {0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0}
                };
        int[][] weights = new int[][]{
                {0, 7, 9, inf, inf, inf, 6},
                {7, 0, 10, 15, inf, inf},
                {9, 10, 0, 11, inf, 2},
                {inf, 15, 11, 0, 6, inf},
                {inf, inf, inf, 6, 0, 9},
                {14, inf, 2, inf, 9, 0}
        };
        Scanner scanner = new Scanner(System.in);
        int startNode = Integer.parseInt(scanner.nextLine());
        int endNode = Integer.parseInt(scanner.nextLine());
        int currentNode = startNode;
        while (completeNodes.size() != nodes.length){
            int min = currentNode;
            for(int i = 0; i < edges[currentNode - 1].length; i++){
                if (edges[currentNode -1][i] == 1 && dictNodes.get(i + 1) > weights[currentNode - 1][i]){
                    dictNodes.put(i + 1, weights[currentNode - 1][i]);
                    if(weights[currentNode - 1][min] > weights[currentNode - 1][i])
                        min = i;
                }
            }
            completeNodes.add(currentNode);
            currentNode = min;
        }
        System.out.println(dictNodes);

    }
}
