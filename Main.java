package Project2;

import java.util.*;

public class Main {

    private static Scanner keyboard;

    public static void main(String[] args) throws Exception {
        keyboard = new Scanner(System.in);
        System.out.println("Welcome user! Let's play the state capital game!");
        while (true) {
            takeQuiz();
            System.out.println("Play another game? ");
            String answer = keyboard.nextLine();
            if (answer.equals("no")) {
                break;
            }
        }
    }

    public static void takeQuiz() throws Exception {
        Map<String, String> americanStates = XMLReader.getStates();
        // shuffle the map and present ten random questions
        List<String> keys = new ArrayList<String>(americanStates.keySet());

        Collections.shuffle(keys);

        int score = 0;

        Random rand = new Random();
        int num = rand.nextInt(50);
        int num2 = rand.nextInt(25);
        int num3 = rand.nextInt(10);


        for (int i = 0; i < 10; i++) {
            System.out.println("What is the state capital of " + keys.get(i) + "?");
            System.out.println();
            System.out.println("Choose right option: " + "\na. " + americanStates.get(keys.get(i + num3 + 1)) + "\nb. "
                    + americanStates.get(keys.get(i)) + "\nc. " + americanStates.get(keys.get((num - i + 1))) + "\nd. "
                    + americanStates.get(keys.get(i + num2 + 1)));

            System.out.println();
            System.out.print("Your Answer is: ");
            ;
            String answer = keyboard.nextLine();

            if (answer.equalsIgnoreCase((americanStates.get(keys.get(i))))) {
                System.out.println("Awesome, you got it right! ");
                score += 1;
            } else {
                System.out.println("Sorry wrong answer... " + " it is " + americanStates.get(keys.get(i)));
            }
        }
        System.out.println("Your score is " + score);
    }

}