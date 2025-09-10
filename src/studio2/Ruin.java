import java.util.Scanner;

public class Ruin {

    public static void main (String[] args) {

        Scanner in = new Scanner (System.in);
        System.out.println("Enter the amount of money that you start with.");
        double startAmount = in.nextDouble();
        System.out.println("Enter the probability that you win a single play.");
        double winChance = in.nextDouble();
        System.out.println("Enter the win limit.");
        double winLimit = in.nextDouble();
        System.out.println("How many days would you like to play?");
        int totalSimulations = in.nextInt();
        
        // * number generate above limit, it's a win * number generate below limit, it's a loss 
        // keep running stimulation until win or loss is confirmed

        int winTimes = 0;
        int lossTimes = 0;

        int simulationPlayed = 0;

        while (simulationPlayed < totalSimulations) {

            while (startAmount > 0 && startAmount < winLimit) { 
                double rand = Math.random();
                if (rand > winChance) { 
                    startAmount++;
                    simulationPlayed++;
                } else {
                    startAmount--;;
                    simulationPlayed++;
                }
                System.out.println("Your amount of money is now " + startAmount);
        }

            if (startAmount == 0) {
                System.out.println("Ruin; you lost.");
                lossTimes++;
        }   else {
                System.out.println("Success; you win.");
             winTimes++;
        }
        }

        if (winChance == 0.5) {
            double ar = ((1-winChance)/winChance);
            double expectedRuin = 1 - (startAmount / winLimit);
            System.out.println("Ruin Rate from Simulation: " + ar);
            System.out.println("Expected Ruin Rate: " + expectedRuin);
        } else {
            double ar = ((1-winChance)/winChance);
            double expectedRuin = (Math.pow(ar, startAmount) - Math.pow(ar,winLimit)) / (1 - Math.pow(ar, winLimit));
            System.out.println("Ruin Rate from Simulation: " + ar);
            System.out.println("Expected Ruin Rate: " + expectedRuin);
        }

        System.out.println("You have won " + winTimes + "amount of times.");
        System.out.println("You have lost " + lossTimes + "amount of times.");
        



    }

}
