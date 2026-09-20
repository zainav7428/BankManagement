package game;
import java.util.*;

public class RockPaperScissors {
    static String checkWinner( int choice, int computerChoice) {

        if (choice == computerChoice) {
            return "Draw";
        }
        else if((choice == 1 && computerChoice == 3)|| (choice == 2 && computerChoice==1)||(choice == 3 && computerChoice == 2)){
            return "You win";
        }else{
            return "computer win";
        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();


        int userScore = 0;
        int computerScore = 0;
        int drawCount = 0;
        System.out.println("===== ROCK PAPER SCISSORS =====");
        while (true) {

            System.out.println("\n1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("Enter your choice (1-3):");
            int choice = sc.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("You chose Rock");
                    break;
                case 2:
                    System.out.println("Your choice Paper");
                    break;
                case 3:
                    System.out.println("Your coice Scissor");
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
                // Case 2 aur Case 3 tum add karo
            }


            int computerChoice = rand.nextInt(3) + 1;
            switch (computerChoice) {
                case 1:
                    System.out.println("Computer chose Rock");
                    break;
                case 2:
                    System.out.println("Computer chose Paper");
                    break;
                case 3:
                    System.out.println("Computer cose Scissors");
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
            String result = checkWinner(choice, computerChoice);
            System.out.println(result);


            if (result.equals("You win")) {
                userScore++;
            } else if (result.equals("computer win")) {
                computerScore++;
            } else {
                drawCount++;
                System.out.println("Match Draw! Game Over.");
                break;
            }

// Display score
            System.out.println("Your Score: " + userScore);
            System.out.println("Computer Score: " + computerScore);
            System.out.println("Draws: " + drawCount);
        }
    }
}
