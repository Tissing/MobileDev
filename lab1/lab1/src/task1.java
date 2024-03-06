public class task1 {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(2, 3, 5, 8);
        Circle circle = new Circle(0, 0, 2);
        Triangle triangle = new Triangle(1, 2, 3, 4, 5, 6);
        System.out.println("Прямоугольник. Площадь: " + String.valueOf(rectangle.getArea()) + ". Периметр: "
                + String.valueOf(rectangle.getPerimetr()) + ".");
        System.out.println("Круг. Площадь: " + String.valueOf(circle.getArea()) + ". Периметр: "
                + String.valueOf(circle.getPerimetr()) + ".");
        System.out.println("Треугольник. Площадь: " + String.valueOf(triangle.getArea()) + ". Периметр: "
                + String.valueOf(triangle.getPerimetr()) + ".");
    }

}

class Figure {

    float x;
    float y;
    public Figure(float x, float y){
        this.x = x;
        this.y = y;
    }
    public double getArea(){
        return 0.0d;
    }
    public double getPerimetr(){
        return 0.0d;
    }
}

class Rectangle extends Figure{
    float h;
    float w;
    public Rectangle(float x, float y, float h, float w){
        super(x, y);
        this.h = h;
        this.w = w;
    }

    public double getArea(){
        return h * w;
    }

    public double getPerimetr(){
        return 2 * h + 2 * w;
    }

}

class Circle extends Figure{
    float pi = 3.14f;
    float radius;
    public Circle(float x, float y, float radius){
        super(x, y);
        this.radius = radius;
    }
    public double getArea(){
        return 2 * pi * radius * radius;
    }
    public double getPerimetr(){
        return 2 * pi * radius;
    }

}

class Triangle extends Figure{
    double x2, x3;
    double y2, y3;

    double a,b,c;
    public Triangle(float x1, float y1,
                    float x2, float y2,
                    float x3, float y3){
        super(x1, y1);
        a = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        c = Math.sqrt(Math.pow(x - x3, 2) + Math.pow(y - y3, 2));
    }
    public double getArea(){
        double p = getPerimetr() / 2;
        return Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }

    public double getPerimetr(){
        return a + b + c;
    }


}


