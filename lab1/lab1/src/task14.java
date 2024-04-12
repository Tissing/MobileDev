import java.io.*;
import java.util.Arrays;

public class task14 {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("lab1/lab1/materials/file_for_code.txt");
        File file = new File("lab1/lab1/materials/new_file.txt");
        file.createNewFile();
        FileOutputStream out = new FileOutputStream("lab1/lab1/materials/new_file.txt");
        int bt = reader.read();
        int save = bt;
        byte count = 1;
        while((bt = reader.read()) != -1) {
            System.out.println(Arrays.toString(Character.toChars(bt)) + " " + bt);
            if (bt == save) {
                count++;
            } else {
                out.write(count);
                out.write(save);
                System.out.println("Запись " + save + " "+ count);
                save = bt;
                count = 1;

            }
        }
        out.write(count);
        out.write(save);
        out.close();
        reader.close();
        System.out.println("Запись " + save + " "+ count);

    }
}
