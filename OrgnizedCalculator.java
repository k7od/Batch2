import java.util.InputMismatchException;
import java.util.Scanner;

public class OrgnizedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Scientific Calculator ===");

        while (keepRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                System.out.println(); // spacer

                switch (choice) {
                    case 1 -> Operations.performAddition(scanner);
                    case 2 -> Operations.performSubtraction(scanner);
                    case 3 -> Operations.performMultiplication(scanner);
                    case 4 -> Operations.performDivision(scanner);
                    case 5 -> Operations.performSquareRoot(scanner);
                    case 6 -> Operations.performPower(scanner);
                    case 7 -> Operations.performSine(scanner);
                    case 8 -> Operations.performCosine(scanner);
                    case 9 -> Operations.performTangent(scanner);
                    case 0 -> {
                        System.out.println("Thank you for using the calculator. Goodbye!");
                        keepRunning = false;
                    }
                    default -> System.out.println("❌ Invalid choice. Please select a valid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Input must be a number. Try again.");
                scanner.nextLine(); // clear buffer
            }

            System.out.println("\n----------------------------------------\n");
        }

        scanner.close();
    }

    // --- Menu Display ---
    public static void displayMenu() {
        System.out.println("""
                ┌──────────────────────────────────────┐
                │            Calculator Menu           │
                ├──────────────────────────────────────┤
                │ 1.  Addition           6.  Power      │
                │ 2.  Subtraction        7.  Sine       │
                │ 3.  Multiplication     8.  Cosine     │
                │ 4.  Division           9.  Tangent    │
                │ 5.  Square Root        0.  Exit       │
                └──────────────────────────────────────┘
                """);
    }

    // --- Modular Operations Class ---
    static class Operations {

        public static void performAddition(Scanner scanner) {
            double[] inputs = getTwoNumbers(scanner);
            System.out.printf("✅ Result = %.4f\n", inputs[0] + inputs[1]);
        }

        public static void performSubtraction(Scanner scanner) {
            double[] inputs = getTwoNumbers(scanner);
            System.out.printf("✅ Result = %.4f\n", inputs[0] - inputs[1]);
        }

        public static void performMultiplication(Scanner scanner) {
            double[] inputs = getTwoNumbers(scanner);
            System.out.printf("✅ Result = %.4f\n", inputs[0] * inputs[1]);
        }

        public static void performDivision(Scanner scanner) {
            try {
                double[] inputs = getTwoNumbers(scanner);
                if (inputs[1] == 0) throw new ArithmeticException("Cannot divide by zero.");
                System.out.printf("✅ Result = %.4f\n", inputs[0] / inputs[1]);
            } catch (ArithmeticException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        public static void performSquareRoot(Scanner scanner) {
            try {
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                if (num < 0) throw new ArithmeticException("Square root of negative number is undefined.");
                System.out.printf("✅ Result = %.4f\n", Math.sqrt(num));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input.");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        public static void performPower(Scanner scanner) {
            double[] inputs = getTwoNumbers(scanner, "base", "exponent");
            System.out.printf("✅ Result = %.4f\n", Math.pow(inputs[0], inputs[1]));
        }

        public static void performSine(Scanner scanner) {
            double angle = getOneAngle(scanner);
            System.out.printf("✅ sin(%.2f°) = %.4f\n", angle, Math.sin(Math.toRadians(angle)));
        }

        public static void performCosine(Scanner scanner) {
            double angle = getOneAngle(scanner);
            System.out.printf("✅ cos(%.2f°) = %.4f\n", angle, Math.cos(Math.toRadians(angle)));
        }

        public static void performTangent(Scanner scanner) {
            try {
                double angle = getOneAngle(scanner);
                if (angle % 180 == 90) throw new ArithmeticException("Tangent undefined at " + angle + "°.");
                System.out.printf("✅ tan(%.2f°) = %.4f\n", angle, Math.tan(Math.toRadians(angle)));
            } catch (ArithmeticException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        // --- Utility input methods ---
        private static double[] getTwoNumbers(Scanner scanner) {
            return getTwoNumbers(scanner, "first number", "second number");
        }

        private static double[] getTwoNumbers(Scanner scanner, String label1, String label2) {
            try {
                System.out.print("Enter " + label1 + ": ");
                double a = scanner.nextDouble();
                System.out.print("Enter " + label2 + ": ");
                double b = scanner.nextDouble();
                return new double[]{a, b};
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input.");
                scanner.nextLine();
                return new double[]{0, 0};
            }
        }

        private static double getOneAngle(Scanner scanner) {
            try {
                System.out.print("Enter angle in degrees: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input.");
                scanner.nextLine();
                return 0;
            }
        }
    }
}
