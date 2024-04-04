import java.util.ArrayList;

public class task5 {

    public static void main(String[] args){
        TODOlist taskList = new TODOlist();
        taskList.addTask("Выполнить лабораторную работу.");
        taskList.addTask("Закрыть сессию");
        taskList.addTask("Установить Android Studio и эмулятор Android");
        taskList.printList();
        System.out.println("\n-----------------------------------------\n");

        taskList.completeTask(2);
        taskList.completeTask(3);
        taskList.printList();
        System.out.println("\n-----------------------------------------\n");

        taskList.deleteTask(2);
        taskList.printList();
        System.out.println("\n-----------------------------------------\n");

    }



}

class TODOlist{
    ArrayList<Task> tasks = new ArrayList<>();
    public TODOlist(){}

    public void addTask(String task){
        tasks.add(new Task(task));
    }

    public void completeTask(int index){
        tasks.get(index - 1).Complete();
    }

    public void deleteTask(int index){
        tasks.remove(index - 1);
    }

    public void printList(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }
}

class Task {
    private final String text;
    private boolean completed;

    public Task(String text){
        this.text = text;
        completed = false;
    }

    public void Complete(){
        completed = true;
    }

    @Override
    public String toString() {
        return "Задача: " + text + "\n" + "Статус: " + (completed ? "Выполнено" : "Не выполнено");
    }
}