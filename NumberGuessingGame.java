import java.util.Scanner;

 class Game {
    public int guess(int max,int min)
    {  
        return (int)(Math.random()*(max-min + 1) + min);
    }
    
}
public class NumberGuessingGame
{
    private static String anotherString;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Game gg = new Game();
        int totalAttempts = 0;
        int win = 0;
        while(true) 
        {
            System.out.println("Enter the Maximum Range");
            int max = sc.nextInt();
            System.out.println("Enter the Minimum Range");
            int min = sc.nextInt();
            sc.nextLine();

            int c_num = gg.guess(max, min);
            int attempts = 0;

            while(true)
            {
               System.out.println("Guess a number between "+max+" and "+min);
               int g_num = sc.nextInt();
               attempts++;

                if(g_num > c_num) 
                {
                    System.out.println("Too High");
                 }
                 else if(max < min) 
                 {
                    System.out.println("Too low");
                 }
                 else 
                 {
                    System.out.println("Correct Guess");
                    win++;
                    break;
                 }
            }
              totalAttempts += attempts;
              System.out.println("Attempts = " + attempts);
              System.out.println("Wins = " + win);

              double winrate = (double) win / totalAttempts*100;
              System.out.printf("Your winrate is %.2f%%\n", winrate);

              System.out.println("Do you want to play again(yes/no)");
              String playAgain = sc.next();
              
                if(!playAgain.equalsIgnoreCase("yes"))
              {
                sc.close();
                System.exit(0);
              }
              sc.nextLine();
            }
    }
}