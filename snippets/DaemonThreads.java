

public static void main(String[] args) {
  Thread t = new Thread( () -> {
    
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e ){
      System.out.println("Thread Interrupted!");
    }
    System.out.println("yo!");
  });
  t.setDaemon(true);
  t.start();
  System.out.println("main");

}

