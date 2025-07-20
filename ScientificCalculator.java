import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Scientific Calculator ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int age = 0;
        double height = 0.0;

        try {
            System.out.print("Enter your age: ");
            age = scanner.nextInt();

            System.out.print("Enter your height in meters: ");
            height = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for age or height.");
            scanner.nextLine();
        }

        scanner.nextLine();

        System.out.println("\nHello, " + name + "!");
        System.out.println("You are " + age + " years old.");
        System.out.println("And you are " + height + " meters tall.");

        boolean keepRunning = true;

        while (keepRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> performAddition(scanner);
                    case 2 -> performSubtraction(scanner);
                    case 3 -> performMultiplication(scanner);
                    case 4 -> performDivision(scanner);
                    case 5 -> performSquareRoot(scanner);
                    case 6 -> performPower(scanner);
                    case 7 -> performSine(scanner);
                    case 8 -> performCosine(scanner);
                    case 9 -> performTangent(scanner);
                    case 0 -> {
                        System.out.println("Goodbye, " + name + "!");
                        keepRunning = false;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // --- Menu Display ---
    public static void displayMenu() {
        System.out.println("\n=== Calculator Menu ===");
        System.out.println("1. Add           2. Subtract");
        System.out.println("3. Multiply      4. Divide");
        System.out.println("5. Square Root   6. Power");
        System.out.println("7. Sine          8. Cosine");
        System.out.println("9. Tangent       0. Exit");
    }

    // --- Arithmetic Methods ---
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
        return a / b;
    }
    public static double calculateSquareRoot(double num) {
        if (num < 0) throw new ArithmeticException("Negative root not allowed.");
        return Math.sqrt(num);
    }
    public static double calculatePower(double base, double exp) { return Math.pow(base, exp); }
    public static double calculateSine(double deg) { return Math.sin(Math.toRadians(deg)); }
    public static double calculateCosine(double deg) { return Math.cos(Math.toRadians(deg)); }
    public static double calculateTangent(double deg) {
        if (deg % 180 == 90) throw new ArithmeticException("Tangent undefined.");
        return Math.tan(Math.toRadians(deg));
    }

    // --- Perform methods ---
    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            System.out.println("Result = " + add(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            System.out.println("Result = " + subtract(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performMultiplication(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            System.out.println("Result = " + multiply(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performDivision(Scanner scanner) {
        try {
            System.out.print("Enter dividend: ");
            double a = scanner.nextDouble();
            System.out.print("Enter divisor: ");
            double b = scanner.nextDouble();
            System.out.println("Result = " + divide(a, b));
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void performSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter number: ");
            double a = scanner.nextDouble();
            System.out.println("Result = " + calculateSquareRoot(a));
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void performPower(Scanner scanner) {
        try {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter exponent: ");
            double exp = scanner.nextDouble();
            System.out.println("Result = " + calculatePower(base, exp));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performSine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double angle = scanner.nextDouble();
            System.out.println("sin(" + angle + ") = " + calculateSine(angle));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performCosine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double angle = scanner.nextDouble();
            System.out.println("cos(" + angle + ") = " + calculateCosine(angle));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private static void performTangent(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double angle = scanner.nextDouble();
            System.out.println("tan(" + angle + ") = " + calculateTangent(angle));
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
}