package snippets;
public class UserSession {
   private static final ThreadLocal<String> userSession = ThreadLocal.withInitial(() -> null);
   public static void set(String user) {
       userSession.set(user);
   }

   public static String get() {
       return userSession.get();
   }

   public static void remove() {
       userSession.remove();
   }

   public static void main(String[] args) {
       Runnable session1 = () -> {
              UserSession.set("User1");
              System.out.println("session1: "
       + UserSession.get());
              UserSession.remove();
              };

       Runnable session2 = () -> {
              UserSession.set("User2");
              System.out.println("session2: "
       + UserSession.get());
              UserSession.remove();
       };


       Thread user1 = new Thread(session1);
       Thread user2 = new Thread(session2);

       user1.start();
       user2.start();

   }
}
