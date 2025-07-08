import java.util.*;
public class Randomnum{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome!");
        Random random=new Random();
        int max_attemps=10;
        int total_s=0;
        int curr_round=1;
        boolean play=true;
        while(play){
            int curr_score=0;
            System.out.println("Let us start round: "+curr_round);
            System.out.println("Choose a number between 1 to 100");
            int attemp=1;
            boolean won=false;
            int num=random.nextInt(100)+1;
            while(attemp<=max_attemps && !won){
                int choose=sc.nextInt();
                if(choose<1 || choose>100)
                {
                    System.out.println("choose a number between 1 to 100");
                    System.out.println("Oops! you lost a attemp");
                }
                else if(choose==num){
                    System.out.println("Your Guess is correct!");
                    curr_score=(max_attemps-attemp+1)*10;
                    total_s+=curr_score;
                    System.out.println("Your total score is "+curr_score);
                    won=true;
                    curr_round++;
                    break;
                }
                else if(choose< num){
                    System.out.println("Oops! choosen number is less ");
                    System.out.println("Try a bigger number");
                    System.out.println("Number of attemps left "+(max_attemps-attemp));
                    attemp++;
                }
                else 
                {
                     System.out.println("Oops! choosen number is large");
                     System.out.println("Try a smaller number");
                     System.out.println("Number of attemps left "+(max_attemps-attemp));
                     attemp++;
                }
            }
            if(!won){
                System.out.println("Sorry! out of attemps");
                System.out.println("Better luck next Time");
                //curr_round++;
            }
            System.out.println("Do you want to play again? \n if yes enter 1 \n if no enter 0");
            int cont_play=sc.nextInt();
            if(cont_play==0)
            {
                play=false;
            }
            else{
                play=true;
                System.out.println("Let us continue the game");
            }
        }
        System.out.println("Game Over!");
        System.out.println("Your total score is "+total_s);
    }
}