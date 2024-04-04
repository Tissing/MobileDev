public class task10 {
    private final static Object lock = new Object();
    public static int c = 1000;
    public static void main(String[] args){
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        synchronized (lock){
            thread1.start();
            thread2.start();
        }
//        MyThread1 thread1 = new MyThread1();
//        MyThread2 thread2 = new MyThread2();
//        thread1.start();
//        thread2.start();
    }

    public static void take(){
        c--;
    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        int taked = 0;
        while(task10.c > 0){
            task10.take();
            taked++;
        }
        System.out.println("ID: " + this.getId() + " NAME: " + this.getName() + " PRIORITY: " + this.getPriority() + " OUTPUT: " + taked);
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        int taked = 0;
        while(task10.c > 0){
            task10.take();
            taked++;
        }
        System.out.println("ID: " + this.getId() + " NAME: " + this.getName() + " PRIORITY: " + this.getPriority() + " OUTPUT: " + taked);
    }
}