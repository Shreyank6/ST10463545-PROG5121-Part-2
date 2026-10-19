
package mycompany.project1;

import java.util.Scanner;

public class Project1 {




    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Are you registering or logging in? (R/L)");
        String choice = input.nextLine();
        if(choice.equals("R"))
        {
            System.out.println("Registered");
        }
        else if(choice.equals("L"))
        {
            System.out.println("Logged in");
        }
        else{
            System.out.println("NO ENTRY");
        }
        
    }
}

