import java.util.Scanner;

public class Methoden {
    public static void sternenmuster1(int n){
        for (int row = 0; row < n; row++) {
            for (int s = n; s > row; s--) {
                System.out.print(" ");
            }
            for (int st = 0; st <= row; st++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void sternenmusterSMUEvorbereitung(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void sternenmusterSMUEbeispiel(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            for (int k = 0; k < (n-i)*2-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void sternenmuster2(int n){
        // Sternenmuster Code
        for (int row = 0; row < n; row++) {
            for (int s = 0; s < row; s++) {
                System.out.print(" ");
            }
            for (int st = n; st > row; st--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void sternenmuster3(int n){
        for (int row = 0; row < n; row++){
            for (int st = 0; st <= row; st++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------


    // SMÜ Beispiel
    public static void muster(int anzahlZeilen){
        for (int row = 0; row < anzahlZeilen; row++){
            for (int route = anzahlZeilen - 1; route > row; route--){
                System.out.print("#");
            }
            for (int quest = anzahlZeilen; quest > 0; quest--){
                System.out.print("?");
            }
            System.out.println();
        }
    }

    // ------------------------------------


    public static void testVorbereitung(int anzahlZeilen){
        for (int i = 0; i < anzahlZeilen; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("+");
            }
            for (int j = 0; j < anzahlZeilen; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    // ------------------------------------


    public static void testBeispiel(int anzahlZeilen){
        for (int i = 0; i < anzahlZeilen; i++){
            for (int j = anzahlZeilen - 1; j >= 0; j--){
                System.out.print("+");
            }
            for (int j = 0; j > (anzahlZeilen*(-1)+(anzahlZeilen+i)*2)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void beispiel2425(int anzahlZeilen){
        for (int row = 1; row <= anzahlZeilen; row++) {
            for (int space = 1; space <= row; space++) {
                System.out.print(" ");
            }
            for (int stars = 3; stars >= row; stars--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static void smueBeispiel(int anzahlZeilen){
        for (int i = anzahlZeilen; i > 0; i--){
            for (int k = 0; k < anzahlZeilen; k--){
                System.out.print("*");
            }
            for (int j = 0; j < anzahlZeilen; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    // ------------------------------------

    public static int scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Sterne wollen Sie haben?");
        return scanner.nextInt();
    }
}
