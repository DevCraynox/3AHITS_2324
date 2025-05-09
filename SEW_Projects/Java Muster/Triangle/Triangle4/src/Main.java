public class Main {
   public static void main(String[] args) {
      int count = 5;
      for (int i = 1; i <= count; i++) {
         for (int k = 1; k <= i; k++) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
   }
}