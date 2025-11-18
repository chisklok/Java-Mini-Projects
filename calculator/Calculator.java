```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("a = ");
        double a = s.nextDouble();

        System.out.print("b = ");
        double b = s.nextDouble();

        System.out.print("Operator (+ - * /): ");
        char op = s.next().charAt(0);

        double r = 0;

        switch (op) {
            case '+': r = a + b; break;
            case '-': r = a - b; break;
            case '*': r = a * b; break;
            case '/': r = b != 0 ? a / b : 0; break;
            default: System.out.println("Invalid");
        }

        System.out.println("Result: " + r);
    }
}
