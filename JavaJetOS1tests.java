import java.util.Scanner;

public class JavaJetOS1tests
{
    public static int Calculator(RunAppAgain){
        Scanner sc = new Scanner(System.in);
        int RunAppAgain = 1;
        int RunCalcAgain;
        double a;
        double b;
        double x;
        double y;
        System.out.println("Which operation do you want to use: \n1.Multiplacation\n2.Divison\n3.Addition\n4.Substraction\n5.Square\n6.Sqaure Root\nEnter the Option Number: ");
        double op1 = (double)sc.nextInt();

        if (op1 == 1) {
            System.out.println("Enter your first value(a): ");
            a = sc.nextDouble();
            System.out.println("Enter your second value(b): ");
            b = sc.nextDouble();
            x = a * b;
            System.out.println("Your product is: " + x);
        }

        if (op1 == 2.0) 
        {
            System.out.println("Enter your first value(a): ");
            a = sc.nextDouble();
            System.out.println("Enter your second value(b): ");
            b = sc.nextDouble();
            x = a / b;
            y = a % b;
            System.out.println("The quotient is: " + x + "while the remainder is: " + y);
        }

        if (op1 == 3.0) {
            System.out.println("Enter your first value(a): ");
            a = sc.nextDouble();
            System.out.println("Enter your second value(b): ");
            b = sc.nextDouble();
            x = a + b;
            System.out.println("The sum is: " + x);
        }

        if (op1 == 4.0) {
            System.out.println("Enter your first value(a): ");
            a = sc.nextDouble();
            System.out.println("Enter your second value(b): ");
            b = sc.nextDouble();
            x = a - b;
            System.out.println("The answer is: " + x);
        }

        if (op1 == 5.0) {
            System.out.println("Enter your value(a): ");
            a = sc.nextDouble();
            x = a * a;
            System.out.println("The square is: " + x);
        }

        if (op1 == 6.0) {
            System.out.println("Enter your value(a): ");
            a = sc.nextDouble();
            x = Math.sqrt(a);
            System.out.println("The answer is:  " + x);
        }
        System.out.println("Would you like to repeat the program?1.Yes or 2.No\nEnter Option No: ");
        RunCalcAgain = sc.nextInt();

        while(RunCalcAgain==1)
        {
            System.out.println("Which operation would you want to use: \n1.Multiplacation\n2.Divison\n3.Addition\n4.Substraction\n5.Square\n6.Sqaure Root\nEnter the Option Number: ");
            op1=sc.nextInt();
            if (op1==1)
            {
                System.out.println("Enter your first value(a): ");
                a = sc.nextDouble();
                System.out.println("Enter your second value(b): ");
                b = sc.nextDouble();
                x = a * b;
                System.out.println("Your product is: " + x);
            }

            if (op1 == 2.0) {
                System.out.println("Enter your first value(a): ");
                a = sc.nextDouble();
                System.out.println("Enter your second valueb): ");
                b = sc.nextDouble();
                x = a / b;
                y = a % b;
                System.out.println("The quotient is: " + x + "while the remainder is: " + y);
            }

            if (op1 == 3.0) {
                System.out.println("Enter your first value(a): ");
                a = sc.nextDouble();
                System.out.println("Enter your second value(b): ");
                b = sc.nextDouble();
                x = a + b;
                System.out.println("The sum is: " + x);
            }

            if (op1 == 4.0) {
                System.out.println("Enter your first value(a): ");
                a = sc.nextDouble();
                System.out.println("Enter your second value(b): ");
                b = sc.nextDouble();
                x = a - b;
                System.out.println("The answer is: " + x);
            }

            if (op1 == 5.0) {
                System.out.println("Enter your value(a): ");
                a = sc.nextDouble();
                x = a * a;
                System.out.println("The square is: " + x);
            }

            if (op1 == 6.0) {
                System.out.println("Enter your value(a): ");
                a = sc.nextDouble();
                x = Math.sqrt(a);
                System.out.println("The answer is:  " + x);
            }
            System.out.println("Would you like to repeat the program?1.Yes or 2.No\nEnter Option No: ");
            RunCalcAgain = sc.nextInt();
        }

        if(RunCalcAgain==2){
            System.out.println("Would you like to run another app or shut down the OS?\nPress 1 to run another app and press 0 to shut down the OS.");
            RunAppAgain = sc.nextInt();
        }
    }
}


    public static void main(String[] args)
    {
        int AppToRun;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Welcome to JavaJetOS! Please enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();
        if (username.equals("default") && password.equals("Pass@123") )
        {
            System.out.println("Logged in and validated successfully! ");
            int RunAppAgain = 1;
            while (RunAppAgain == 1){
                System.out.println("Please enter the number of the application you would like to run: \n1)Calculator\n2)Number Guessing Game");
                AppToRun= sc.nextInt();
                if (AppToRun==1)
                {
                    Calculator();

                    
                }
                else if (AppToRun==3){
                    // Java program for the above approach

                    // Scanner Class
                        // Scanner sc = new Scanner(System.in)){
                    // Generate the numbers
                    int number = 1 + (int)(100
                                        * Math.random());

                    // Given K trials
                    System.out.println("How many guesses do you need: ");
                    int K;
                    K = sc.nextInt();
                    int i = 0; 
                    int guess = 0;

                    System.out.println
                    (
                        "A number is chosen"
                        + " between 1 to 100."
                        + "Guess the number."
                        );

                    // Iterate over K Trials
                    for (i = 0; i < K; i++) 
                    {

                        System.out.println(
                            "Guess the number: ");

                        // Take input for guessing
                        guess = sc.nextInt();

                        // If the number is guessed
                        if (number == guess) {
                            System.out.println(
                                " Congratulations!"
                                + " \nYou guessed the number.");
                            break;
                        }
                        if(guess > number - 5 && guess < number + 5 && i!= K-1)
                        {
                        System.out.println("You are extremely near the number.");
                        }
                        else if (guess > number - 10 && guess < number + 10
                                && i != K - 1) {
                            System.out.println(
                                " You are near it");
                        }
                        else if(number > guess && i!=K - 1)
                        {
                        System.out.println("The number is greater than your guess");
                        }
                        else if(number<guess && i!=K)
                        {
                        System.out.println("The number is smaller than your guess");
                        }
                    }

                    if (i == K) 
                    {
                        System.out.println(
                            "You have exhausted"
                            + " K trials.");

                        System.out.println(
                            "The number was " + number);
                    }
                    }
                    }

                    
                    

                        
                    
            }
    }  
}   







    



