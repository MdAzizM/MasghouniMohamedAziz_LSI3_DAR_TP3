package ACT2.Utils;

import java.io.Serializable;

public class Oper implements Serializable {

    private int num1;
    private int num2;
    private char operator;

    public Oper(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public char getOperator() { return operator; }
}

