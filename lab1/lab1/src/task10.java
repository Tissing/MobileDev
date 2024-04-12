public class task10 {
    private final static Object lock = new Object();
    public static void main(String[] args){
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();

    }

    public static synchronized void print(Thread thread){
        for(int i = 0; i < 5; i++){
            System.out.println(thread.getName() + " " + thread.getId() + " PRINT: " + i);
        }
    }

}

class MyThread extends Thread {
    @Override
    public void run(){
        task10.print(this);
    }

}
