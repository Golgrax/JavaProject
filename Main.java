import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Questions for the quiz
    private static String[] questions = {
            "What does 'OOP' mean in Java?\nA) Object-Oriented Programming\nB) Object-Oriented Protocol\nC) Object-Oriented Process\nD) Object-Oriented Procedure",
            "How do you consider an 'array' in Java?\nA) List of elements\nB) Group of elements\nC) Tree of elements\nD) Set of elements",
            "What is the 'Java Virtual Machine (JVM)'?\nA) It executes Java bytecode\nB) It allows Java programs to run\nC) It debugs Java code\nD) It compiles Java code",
            "What is the difference between '== and .equals()' in Java?\nA) Both compare object references\nB) Both compare object content\nC) '==' compares object references, while '.equals()' compares object content\nD) '==' compares object content, while '.equals()' compares object references",
            "How do you call a method that returns a value in Java?\nA) Void method\nB) Non-returning method\nC) Returnless method\nD) Method with a return type",
            "What is a 'constructor' in Java?\nA) Method that creates an object\nB) Method that destroys an object\nC) Method that updates an object\nD) Method that assigns a value to an object",
            "What is a 'Java package' and how is it used?\nA) It provides organizational structure to Java code\nB) It provides extra features to Java\nC) It implements GUI in Java\nD) It retains data in Java",
            "How do you declare a 'variable' in Java?\nA) data type variableName;\nB) variableName data type;\nC) data type = variableName;\nD) variableName = data type;",
            "What is a 'Java interface' and how is it used?\nA) It provides a graphical user interface\nB) It is a blueprint of a class with abstract methods\nC) It destroys objects in Java\nD) It executes Java bytecode",
            "How do you avoid 'NullPointerException' in Java?\nA) Avoid using pointers\nB) Check for null before accessing object properties or methods\nC) Set all variables to null\nD) Use a 'try-catch' block to handle the exception"
    };

    // Correct answers for each question
    private static char[] correctAnswers = {'A', 'B', 'A', 'C', 'D', 'A', 'A', 'A', 'B', 'B'};

    // Key for starting quiz or taking a break
    private static final String START_KEY = "p";
    private static final String BREAK_KEY = "b";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Greet the user for the Java Quiz
        System.out.println("Java Quiz! Enter 'p' to start the quiz and 'b' to take a break.");

        // Get user input for starting or taking a break
        String userKey = scanner.nextLine().toLowerCase();

        // Check the user's key input
        if (userKey.equals(START_KEY)) {
            // Start the quiz
            startQuiz(scanner);
        } else if (userKey.equals(BREAK_KEY)) {
            // Take a break
            System.out.println("Take a break. Come back later to start the quiz.");
        } else {
            // If incorrect key, prompt the user to try again
            System.out.println("Incorrect key. Please try again.");
        }

        scanner.close();
    }

    // Method to start the quiz
    private static void startQuiz(Scanner scanner) {
        int score = 0;

        // Iterate through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion #" + (i + 1) + ": " + questions[i]);

            // Get the user's answer using the getMultipleChoiceInput method
            char userAnswer = getMultipleChoiceInput(scanner);

            // Check if the user's answer is correct
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The correct answer is: " + correctAnswers[i]);
            }

            // Wait for user input before showing the next question
            if (i < questions.length - 1) {
                System.out.println("\nNext question coming up... (press any key to continue)");
                scanner.nextLine(); // Wait for the user to press Enter before showing the next question
            }
        }

        // Display the user's score after the quiz
        System.out.println("\nQuiz is over. Your score is: " + score + "/" + questions.length);

        // Show feedback based on the user's score
        displayScoreFeedback(score, questions.length);
    }

    // Method to get user input for multiple choice
    private static char getMultipleChoiceInput(Scanner scanner) {
        char userAnswer;
        do {
            System.out.print("Answer (A, B, C, D): ");
            try {
                userAnswer = scanner.nextLine().toUpperCase().charAt(0);
            } catch (InputMismatchException e) {
                // If incorrect input, clear the scanner and print an error message
                scanner.nextLine();
                System.out.println("Incorrect input. Try again.");
                userAnswer = ' '; // Set userAnswer to space to re-enter the loop
            }
        } while (userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C' && userAnswer != 'D');

        return userAnswer;
    }

    // Method to display feedback based on the user's score
    private static void displayScoreFeedback(int score, int totalQuestions) {
        double percentage = ((double) score / totalQuestions) * 100;

        // Provide feedback based on the percentage of the score
        if (percentage == 100) {
            System.out.println("Wow! You got all answers right. Excellent!");
        } else if (percentage >= 75) {
            System.out.println("Great! Your score is high.");
        } else if (percentage >= 50) {
            System.out.println("Not bad. You can improve.");
        } else {
            System.out.println("You need to study some Java concepts further.");
        }
    }
}
