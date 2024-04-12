import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
public class task13 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("lab1/lab1/materials/file.txt"));
        HashMap<String, Integer> words = new HashMap<>();
        HashMap<Character, Integer> chars = new HashMap<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().replaceAll("[^\\w\\sa-яА-Я]|_", "");
            System.out.println(input);
            for(String i: input.split(" ")){
                if(words.containsKey(i) && i.equals(" ")){
                    words.put(i, words.get(i) + 1);
                } else {
                    words.put(i, 1);
                }
            }
            for(char i: input.toCharArray()){
                if(chars.containsKey(i)){
                    chars.put(i, chars.get(i) + 1);
                } else {
                    chars.put(i, 1);
                }
            }
        }
        scanner.close();
        ArrayList<String> wordsGreater4 = new ArrayList<>();
        for(String key: words.keySet()){
            if(key.length() > 4) wordsGreater4.add(key);
        }
        ArrayList<String> topFive = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            String max = "";
            for(String word: wordsGreater4){
                if(!topFive.contains(word))
                {
                    max = word;
                    break;
                }
            }
            for(String word: wordsGreater4){
                if(words.get(max) < words.get(word) && !topFive.contains(word)){
                    max = word;
                }
            }
            topFive.add(max);
        }

        System.out.println("Кол-во каждого слова:");
        System.out.println(words);
        System.out.println();
        System.out.println("Кол-во каждого символа:");
        System.out.println(chars);
        System.out.println("Ключевые слова:");
        for(String word: topFive){
            System.out.println(word + " " + words.get(word));
        }

    }
}
