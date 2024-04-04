

public class task7 {
    public static void main(String[] args){
        float costItem1 = 999.99f;
        float costItem2 = 100000;
        float costItem3 = 80000.99f;

        System.out.println("Товар 1. Скидка: 20%. Налог: 13%. Цена: " + calculate(costItem1, 0.2f, 0.13f));
        System.out.println("Товар 2. Скидка: 50%. Налог: 0%. Цена: " + calculate(costItem2, 0.5f, 0f));
        System.out.println("Товар 3. Скидка: 0%. Налог: 30%. Цена: " + calculate(costItem3, 0f, 0.3f));
        System.out.println("Товар 1. Скидка: 0%. Налог: 0%. Цена: " + calculate(costItem1, 0f, 0f));
    }
    static float calculate(float cost, float discount, float tax){
        return cost * (1 - discount +  tax);
    }
}
