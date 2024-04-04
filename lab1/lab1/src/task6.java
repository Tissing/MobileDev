import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class task6 {
    public static void main(String[] args){
        ArrayList<String> namesOfEmployee = new ArrayList<>(Arrays.asList(new String[]{"Петр", "Иван", "Александр"}));
        System.out.println("ArrayList");
        System.out.println(namesOfEmployee);
        HashMap<String, Integer> employeeSalary = new HashMap<>();
        for(String i : namesOfEmployee)
        {
            employeeSalary.put(i, (int)(1000 + Math.random() * (8000 - 1000 + 1)));
        }
        System.out.println("HashMap");
        System.out.println(employeeSalary);

        System.out.println("Добавления элемента");
        namesOfEmployee.add("Василий");
        System.out.println(namesOfEmployee);

        employeeSalary.put("Василий", 5000);
        System.out.println(employeeSalary);

        System.out.println("Удаление элемента");
        namesOfEmployee.remove("Петр");
        System.out.println(namesOfEmployee);

        employeeSalary.remove("Петр");
        System.out.println(employeeSalary);
    }

}
