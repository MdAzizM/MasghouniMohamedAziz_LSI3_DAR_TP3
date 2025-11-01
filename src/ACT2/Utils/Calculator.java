package ACT2.Utils;

public class Calculator {
    public static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num2 != 0 ? num1 / num2 : 0;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
