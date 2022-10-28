import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            throw new Exception("No arguments provided");

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        fillStacks(numbers, operators, args[0]);

        System.out.println("Result: " + calculate(numbers, operators));
    }

    private static void fillStacks(Stack<Integer> numbers, Stack<Character> operators, String arguments)
            throws Exception {
        for (int i = 0; i < arguments.length(); ++i) {
            if (Character.isDigit(arguments.charAt(i))) {
                numbers.push(Integer.parseInt(arguments.charAt(i) + ""));
            } else {
                if (arguments.charAt(i) != '+'
                        && arguments.charAt(i) != '-'
                        && arguments.charAt(i) != '*'
                        && arguments.charAt(i) != '/') {
                    throw new Exception("Invalid operator");
                }
                operators.push(arguments.charAt(i));
            }
        }
    }

    private static int calculate(Stack<Integer> numbers, Stack<Character> operators) throws Exception {
        if (0 == numbers.size() || 0 == operators.size()) {
            throw new Exception("Invalid input");
        }

        if (numbers.size() != operators.size() + 1) {
            throw new Exception("Invalid expression");
        }

        int result = numbers.pop();
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            int number = numbers.pop();

            result = switch (operator) {
                case '+' -> add(result, number);
                case '-' -> subtract(result, number);
                case '*' -> multiply(result, number);
                case '/' -> divide(result, number);
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
        }

        return result;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
