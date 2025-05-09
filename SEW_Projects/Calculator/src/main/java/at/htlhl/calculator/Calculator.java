package at.htlhl.calculator;

public class Calculator {

    public Calculator() {

    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
        // so gibt es einen fehler -> return operand1 + operand2 ** + 2 **;
    }

    public int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int divide(int zaehler, int nenner) throws CalcException {
        if (nenner == 0) {
            throw new CalcException("Nenner darf nicht null sein!");
        }
        return zaehler / nenner;
    }

    public int absolutValue(int number) {
        if (number < 0) {
            return number * -1;
        }
        return number;
    }
}
