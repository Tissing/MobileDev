import java.util.Arrays;

public class task17 {
    static public void main(String[] args){
        System.out.println("MyRandom.randValue(1, 10): " + MyRandom.randValue(1, 10));
        System.out.println("MyRandom.randValue(1.0, 10.0): " + MyRandom.randValue(1.0, 10.0));
        System.out.println("MyRandom.randomRange(1, 10, 5): ");
        System.out.println(Arrays.toString(MyRandom.randomRange(1, 10, 5)));
        System.out.println("MyRandom.randomRange(1.0, 10.0, 5): ");
        System.out.println(Arrays.toString(MyRandom.randomRange(1.0, 10.0, 5)));
    }
}

class MyRandom{
    public static double randValue(double min, double max){
        return min + (Math.random() * (max - min)) + Math.random();
    }

    public static int randValue(int min, int max){
        return min + (int)(Math.random() * (max - min));
    }

    public static int[] randomRange(int min, int max, int n){
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = randValue(min, max);
        }
        return result;
    }

    public static double[] randomRange(double min, double max, int n){
        double[] result = new double[n];
        for(int i = 0; i < n; i++){
            result[i] = randValue(min, max);
        }
        return result;
    }
}
