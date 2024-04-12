import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.*;

public class task16 {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Чтение из файла lab1/lab1/materials/response.json");
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("lab1/lab1/materials/response.json");
        JSONObject resp = (JSONObject) parser.parse(reader);
        reader.close();
        System.out.println(resp);

        System.out.println("Обновление");
        resp.put("car", "Lexus");
        System.out.println(resp);
        FileWriter writer = new FileWriter("lab1/lab1/materials/response.json");
        writer.write(resp.toJSONString());
        writer.close();
        reader = new FileReader("lab1/lab1/materials/response.json");
        resp = (JSONObject) parser.parse(reader);
        reader.close();
        System.out.println("После обновления");
        System.out.println(resp);

        JSONObject json = new JSONObject();
        json.put("name", "Дмитрий");
        json.put("car", "Suzuki");
        System.out.println("Создание JSON");
        System.out.println(json);
        writer = new FileWriter("lab1/lab1/materials/output.json");

        writer.write(json.toJSONString());
        writer.close();
    }
}
