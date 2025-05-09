public class Main {
   public static void main(String[] args) {
      
      int row = 5;
      int column = 4;

      for (int i = 0; i < row; i++) {
         for (int k = column; k >= 0; k--) {
            System.out.print(k + " ");
         }
         System.out.println();
      }
      
   }
}