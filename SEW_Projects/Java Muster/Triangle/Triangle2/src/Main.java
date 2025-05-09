public class Main {
   public static void main(String[] args) {
      int rows = 4;
      for (int i = 0; i < rows; i++) {
         for (int k = 4; k > i; k--) {
            System.out.print("*");
         }
         System.out.println();
      }
      System.out.println();
   }
}
