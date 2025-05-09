package at.htlhl.recursion;

/**
 * Liefert die Fibonacci Zahlen (1 1 2 3 5 8 …)
 */
public class Fibonacci {

    private final static int N = 6;

    public Fibonacci() {
        // Liefert eine bestimmte Stelle der Fibonacci Folge
        System.out.println(N + ". Stelle der Fibonacci Folge: " + fib(N));

        // Liefert die Fibonacci Folge
        System.out.println("Fibonacci Folge bis zur " + N + ". Stelle: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        new Fibonacci();
    }
}
