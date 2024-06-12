
//   *********** NUMBER GAME *************

import java.util.Scanner;

class rangen {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rangen rg = new rangen();
        int totalAttempts = 0;
        int win = 0;

        System.out.println("Do you want to guess a number or let the computer generate one? (guess/generate)");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("guess")) {
            while (true) {
                System.out.println("Enter the maximum number");
                int max = sc.nextInt();
                System.out.println("Enter the minimum number");
                int min = sc.nextInt();
                sc.nextLine();

                int cnum = rg.generate(max, min);
                int attempts = 0;

                while (true) {
                    System.out.println("Guess a number between " + min + " and " + max);
                    int gnum = sc.nextInt();
                    attempts++;

                    if (gnum > cnum) {
                        System.out.println("It's Greater");
                    } else if (gnum < cnum) {
                        System.out.println("It's Lower");
                    } else {
                        System.out.println("Correct Guess!");
                        win++;
                        break;
                    }
                }
                totalAttempts += attempts;
                System.out.println("Attempts = " + attempts);
                System.out.println("Wins = " + win);

                double winrate = (double) win / totalAttempts * 100;
                System.out.printf("Your win rate is %.2f%%\n", winrate);

                System.out.println("Do you want to play again? (yes/no)");
                String playAgain = sc.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    sc.close();
                    System.exit(0);
                }
                sc.nextLine();
            }
        } else if (choice.equalsIgnoreCase("generate")) {
            System.out.println("Enter the maximum number");
            int max = sc.nextInt();
            System.out.println("Enter the minimum number");
            int min = sc.nextInt();
            sc.nextLine();

            int cnum = rg.generate(max, min);
            int attempts = 0;

            while (true) {
                System.out.println("Guess a number between " + min + " and " + max);
                int gnum = sc.nextInt();
                attempts++;

                if (gnum > cnum) {
                    System.out.println("It's Greater");
                } else if (gnum < cnum) {
                    System.out.println("It's Lower");
                } else {
                    System.out.println("Correct Guess!");
                    win++;
                    break;
                }
            }
            totalAttempts += attempts;
            System.out.println("Attempts = " + attempts);
            System.out.println("Wins = " + win);

            double winrate = (double) win / totalAttempts * 100;
            System.out.printf("Your win rate is %.2f%%\n", winrate);
        } else {
            System.out.println("Invalid choice. Please choose 'guess' or 'generate'.");
        }
        sc.close();
    }
}
