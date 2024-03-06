import java.io.*;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args){
        String path = "materials/Sample.txt";
        String new_sample_text = "12. Создать игру \"Крестики-нолики\" с возможностью игры против компьютера или другого игрока.";
        String found_text = "алгоритм";
        String replace = "программу";
        String replace_text = "приложение";
        readFile(path);
        writeText(path, new_sample_text);
        foundLines(path, found_text);
        replaceText(path, replace, replace_text);
    }

    public static void readFile(String path){
        System.out.println("Чтение файла " + path);
        System.out.println("------------------------------------------------------");
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------");
    }

    public static void writeText(String path, String text){
        System.out.println("Запись в файл " + path);
        System.out.println("Текст: " + text);
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Файл перезаписан.");
        System.out.println("------------------------------------------------------");

    }

    public static void foundLines(String path, String text){
        System.out.println("Поиск в файле " + path);
        System.out.println("Текст: " + text);
        System.out.println("------------------------------------------------------");
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.toLowerCase().contains(text)){
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------");
    }

    public static void replaceText(String path, String text, String replaceText){
        System.out.println("Замена текста в файле " + path);
        System.out.println("Текст: " + text);
        System.out.println("Замена: " + replaceText);
        System.out.println("------------------------------------------------------");
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String alltext = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                alltext += data + "\n";
            }
            myReader.close();
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            alltext = alltext.replaceAll(text, replaceText);
            bufferedWriter.write(alltext);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Текст заменен");
        System.out.println("------------------------------------------------------");
    }
}


