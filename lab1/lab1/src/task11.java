import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = Decoder.code(input, -1);
        System.out.println("Result: " + result);

        Decoder.decode(result);
    }
}
class Decoder{
    public static String code(String source, int bias){
        char[] chars = source.toUpperCase().toCharArray();
        String result = "";
        for(char i: chars){
            if(i + bias > 90 && bias > 0){
                result += Character.toString(64 + (i + bias - 90));
            } else if (i + bias < 65 && bias < 0){
                result += Character.toString(91 + (i + bias - 65));
            } else {
                result += Character.toString(i + bias);
            }
        }
        return result;
    }

    public static void decode(String source){
        char[] chars = source.toUpperCase().toCharArray();
        for(int bias = 1; bias <= 26; bias++){
            System.out.print("bias=" + bias + " ");
            for(char i: chars){
                if(i + bias > 90){
                    System.out.print(Character.toString(64 + (i + bias - 90)));
                } else {
                    System.out.print(Character.toString(i + bias));
                }
            }
            System.out.print("\n");
        }
    }
}
