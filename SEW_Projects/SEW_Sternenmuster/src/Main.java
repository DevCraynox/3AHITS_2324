public class Main {
    public static void main(String[] args) {
        // int aZ = 4;
        /*
        for (int i = 1; i <= aZ; i++){
            for (int j = 1; j <= aZ-i; j++){
                System.out.print("+");
            }
            for (int k = 1; k <= i*2-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        */
        /*
        +####
        ++####
        +++####
        ++++####
         */
        /*
        for (int i = 1; i <= aZ; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("+");
            }
            for (int k = 1; k <= aZ; k++){
                System.out.print("#");
            }
            System.out.println();
        }
         */

        /*
         #++++
         ##+++
         ###++
         ####+
         */
        /*
        for (int i = 1; i <= aZ; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("#");
            }
            for (int k = 1; k < aZ+2-i; k++){
                System.out.print("+");
            }
            System.out.println();
        }
         */
        int aZ = 5;
        for (int i = 1; i <= aZ; i++){
            for (int j = 1; j <= i-1; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= (aZ*2+1)-(i*2); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}