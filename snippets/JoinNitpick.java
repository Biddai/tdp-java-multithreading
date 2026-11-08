public static void main(String[] args)
        throws InterruptedException {

    Thread t = new Thread(() -> {
        System.out.println("worker");
    });

    t.join();
    t.start();

    System.out.println("main");
}