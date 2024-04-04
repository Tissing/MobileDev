public class task4 {
    public static void main(String[] args){
        String[] names = {"Утюг", "Чайник", "Телевизор", "Плита", "Духовка", "Пылесос"};
        Device[] devices = new Device[10];
        System.out.println("Было:");
        for(int i = 0; i < 10; i++){
            int random_name = (int)(Math.random() * (names.length));
            devices[i] = new Device(names[random_name], (int)(2500 + Math.random() * (7500 - 2500 + 1)));
            System.out.println(devices[i]);
        }
        sort(devices);
        System.out.println("Стало:");
        for(int i = 0; i < 10; i++){
            System.out.println(devices[i]);
        }
    }
    public static void sort(Device[] devices){
        for(int i = 0; i < devices.length; i++){
            for(int j = 0; j < devices.length; j++) {
                if (devices[i].cost > devices[j].cost) {
                    var temp = devices[i];
                    devices[i] = devices[j];
                    devices[j] = temp;
                }
            }
        }
    }
}

class Device{
    String name;
    int cost;

    public Device(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "name: " + name + "\t\t cost: " + cost;
    }
}

