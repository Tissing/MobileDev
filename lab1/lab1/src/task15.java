import java.util.Scanner;

public class task15 {
    public static void main(String[] args){
        MyFunc func = new MyFunc();
        System.out.println("Решение уравнения ax^2 + bx + c = 0");
        Scanner scan = new Scanner(System.in);
        System.out.print("a = ");
        double a = Double.parseDouble(scan.nextLine());
        System.out.print("b = ");
        double b = Double.parseDouble(scan.nextLine());
        System.out.print("c = ");
        double c = Double.parseDouble(scan.nextLine());
        double[] solve = MathLib.SolveEquation(a, b, c);
        if(solve.length != 0){
            for(int i = 0; i < solve.length; i++){
                System.out.println("x" + (i + 1) + " = " + solve[i]);
            }
        } else {
            System.out.println("Корней нет");
        }
        System.out.println("Численное вычесление интеграла");
        System.out.print("a = ");
        a = Double.parseDouble(scan.nextLine());
        System.out.print("b = ");
        b = Double.parseDouble(scan.nextLine());
        System.out.print("n (Число разбиений) = ");
        int n = Integer.parseInt(scan.nextLine());
        System.out.println("Интеграл равен: " + MathLib.TrapezeSolution(a, b, n, func));
    }
}

class MathLib{
    public static double[] SolveEquation(double a, double b, double c){
        double D = b * b - 4 * a * c;
        if (D > 0){
            double x1 = (- b + Math.sqrt(D)) / (2 * a),
                   x2 = (- b - Math.sqrt(D)) / (2 * a);
            return new double[]{x1, x2};
        } else if (D == 0){
            return new double[]{- b/ (2 * a)};
        } else {
            return new double[]{};
        }
    }
    static public double TrapezeSolution(double a, double b, int n, Function func)
    {
        double h = (b - a) / n;
        double sum_y = 0;

        for(int i = 1; i < n; i++)
        {
            sum_y += func.getY(a + h * i);
        }

        sum_y += (func.getY(a) + func.getY(b)) / 2;

        return h * sum_y;
    }

}

interface Function {
    double getY(double X);
}
class MyFunc implements Function {
    public double getY(double x){
        return 1 / (x + 1);
    }
}
