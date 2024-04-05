import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        double inf = Double.POSITIVE_INFINITY;
        HashMap<Integer, Double> dictNodes = new HashMap<>();
        int[] nodes = new int[]{1, 2, 3, 4, 5, 6};
        for (int i : nodes) dictNodes.put(i, inf);
        ArrayList<Integer> completeNodes = new ArrayList<>();
        int[][] edges = new int[][]{
                {0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0}
        };
        double[][] weights = new double[][]{
                {0, 7, 9, inf, inf, 14},
                {7, 0, 10, 15, inf, inf},
                {9, 10, 0, 11, inf, 2},
                {inf, 15, 11, 0, 6, inf},
                {inf, inf, inf, 6, 0, 9},
                {14, inf, 2, inf, 9, 0}
        };
        Scanner scanner = new Scanner(System.in);
        int startNode = 1;//Integer.parseInt(scanner.nextLine());
        dictNodes.put(startNode, 0.0);
        int endNode = 4;//Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> path = new ArrayList<>();
        int currentNode = startNode;
        while(completeNodes.size() != nodes.length) {
            double min = inf;
            int min_ind = -1;
            completeNodes.add(currentNode);
            for (int i = 0; i < edges[currentNode - 1].length; i++) {
                if (edges[currentNode - 1][i] == 1) {
                    if (dictNodes.get(i + 1) > dictNodes.get(currentNode) + weights[currentNode - 1][i]) {
                        dictNodes.put(i + 1, dictNodes.get(currentNode) + weights[currentNode - 1][i]);
                        if (i + 1 == endNode ){
                            path = (ArrayList<Integer>) completeNodes.clone();
                        }
                    }

                }
            }
            for(int i: dictNodes.keySet()){
                if(dictNodes.get(i) < min && !completeNodes.contains(i)){
                    min = dictNodes.get(i);
                    min_ind = i;
                }
            }

            currentNode = min_ind;
            System.out.println(dictNodes);
        }
        //System.out.println(completeNodes);
        System.out.println("Узел " + endNode + " = " + dictNodes.get(endNode));
        path.add(endNode);
        System.out.println(path);
    }
}
