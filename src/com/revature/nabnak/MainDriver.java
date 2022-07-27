package com.revature.nabnak;

/* Nabnak is a kanband board for professional developers aimed to be the next best virtual board on the internet.
    The goal is to allow members to join the application, be assigned part of a team and shard their kanban cards.
*/

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

public class MainDriver {
    public static void main(String[] args) {

        // Define the datatype in the array and this is the only acceptable datatype
        // Arrays are fixed in size
        String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) Exit application"};

        System.out.println(welcomeMessages[0]);
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        // System.out.println(welcomeMessages[3]);
        welcomeMessages[3] = "3) Exit Application"; // values at indices can be reassigned but not mutated
        // At line 18, the "3) Exit application is removed from the String and memory via garbage collection
        // Note: GC, cannot be FORCED. It can be suggested like the command below
        // System.gc(); // One of those questions
        System.out.println(welcomeMessages[3]);

        // System.out.println(welcomeMessages[4]); // this will throw an ArrayIndexOutOfBoundsException

        // Problem we run into is actually receiving information from a user
        // Instance of BufferedReader to get user input from the terminal
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        // try-catch blocks are a major way to handle exceptions
        try { // try-block leverages risky code that might throw an Exception
            String firstInput = terminalReader.readLine(); // it throws an IOException, this MUST be handled before compile time (checked)
//
//            if(firstInput.equals("1")){
//                System.out.println("User has selected login....");
//            } else if(firstInput.equals("2")){
//                System.out.println("User has selected register....");
//            } else if (firstInput.equals("3")) {
//                System.out.println("User is not exiting. Hope to see you soon!");
//            } else {
//                System.out.println("User has not selected anything");
//            }

            // if your switch cases don't handle control flow it will result in fall-through
            // can be advantageous
            switch (firstInput){
                case "1": // if firstInput.equals("1") then this case will execute
                    System.out.println("User has selected login....");
                    break; // the keyword break prevents any fall-through
                case "2":
                    System.out.println("User has selected register....");

                    System.out.print("Please enter email: \n>"); // \n is a new line character, aka return or enter
                    String email = terminalReader.readLine();

                    System.out.print("Please enter your first and last name: \n>");
                    String fullName = terminalReader.readLine();

                    System.out.print("Please enter your experience in months: \n>");
                    String experienceMonths = terminalReader.readLine();

                    String registrationDate = LocalDateTime.now().toString();

                    // This is a form of logging
                    System.out.printf("New user has registerd under \n User:%s,%s,%s,%s", email, fullName, experienceMonths, registrationDate).println(); //printf is a formatter

                    File memoryFile = new File("resources/data.txt");

                    // This beaut, is a try-with-resources block. This allows for anything that extends AutoClosable to be automatically closed
                    try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {
                        String output = email + "," + fullName + "," + experienceMonths + "," + registrationDate + "\n";
                        fileWriter.write(output);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                   // fileWriter.close(); // be mindful to always close

                    break;
                // case "i": // example of fall through
                case "3":
                    System.out.println("User is now exiting. Hope to see you soon!");
                    break;
                default:
                    System.out.println("User has not selected valid input....");


            }
        } catch (IOException e){ // Catches that exception and assigns to variable e
            e.printStackTrace();
        }
    }

    public static void register(){


    }
}
