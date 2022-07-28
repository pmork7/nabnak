package com.revature.nabnak;

/* Nabnak is a kanband board for professional developers aimed to be the next best virtual board on the internet.
    The goal is to allow members to join the application, be assigned part of a team and shard their kanban cards.
*/

import com.revature.nabnak.models.Member;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

public class MainDriver {

    // Problem we run into is actually receiving information from a user
    // Instance of BufferedReader to get user input from the terminal
    // DRY Princle = DONT REPEAT YOURSELF
    static BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        boolean isRunning = true;
        // Define the datatype in the array and this is the only acceptable datatype
        // Arrays are fixed in size
        while(isRunning){ // while loop is when you have no idea how many iterations are required
        String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) View members","4) Exit application"};

        System.out.println(welcomeMessages[0]);
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);

        // try-catch blocks are a major way to handle exceptions
        try { // try-block leverages risky code that might throw an Exception
            String firstInput = terminalReader.readLine(); // it throws an IOException, this MUST be handled before compile time (checked)

            // if your switch cases don't handle control flow it will result in fall-through
            // can be advantageous
            switch (firstInput) {
                case "1": // if firstInput.equals("1") then this case will execute
                    System.out.println("User has selected login....");
                    break; // the keyword break prevents any fall-through
                case "2":
                    System.out.println("User has selected register....");
                    register(); // register() the () INVOKE the method189
                    break;
                // case "i": // example of fall through
                case "3":
                    System.out.println("User wishes to view other members");
                    String[] members = readFile();
                    for(String member: members){ // enhanced for loop with arrays
                        System.out.println(member);
                    }
                    break;
                case "4":
                    System.out.println("User is now exiting. Hope to see you soon!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("User has not selected valid input....");
            }
        } catch (IOException e) { // Catches that exception and assigns to variable e
            e.printStackTrace();
        }
        // Please for the love of all that is beautiful in the world DO NOT DO THIS
        //main(args); // This is known as recursion, it's a method calling itself
    }
    }

    // Custom method to implement a registration process
    public static void register() throws IOException{ // throws + ExceptionName is known as ducking
        // ducking means passing the responsibilty of handling that exception to the code that's calling it
        // Problem terminalReader is not within this scope? Solution:
        System.out.print("Please enter email: \n>"); // \n is a new line character, aka return or enter
        String email = terminalReader.readLine();

        System.out.print("Please enter your first and last name: \n>");
        String fullName = terminalReader.readLine();

        System.out.print("Please enter your experience in months: \n>");
        String experienceMonths = terminalReader.readLine();

        // TODO: What on god's green earth is LocalDateTime? 
        String registrationDate = LocalDateTime.now().toString();

        // This is a form of logging
        // System.out.printf("New user has registerd under \n User:%s,%s,%s,%s", email, fullName, experienceMonths, registrationDate).println(); //printf is a formatter

        File memoryFile = new File("resources/data.txt");
        // This beaut, is a try-with-resources block. This allows for anything that extends AutoClosable to be automatically closed
        try(FileWriter fileWriter = new FileWriter(memoryFile, true);) {

            Member member = new Member(email, fullName, Integer.parseInt(experienceMonths), registrationDate);

            System.out.println(member.getPassword());

            member.setPassword("12345");
            System.out.println(member.getPassword());

            System.out.println("New user has registered: " + member.toString());

            Member member2 = new Member();
            fileWriter.write(member.writeToFile());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String[] readFile(){ // we want to return information from this method
        String[] members = new String[10];

        // try-with-resources automatically closes files for us
        try(
                FileReader fileReader = new FileReader("resources/data.txt");
                BufferedReader reader = new BufferedReader(fileReader);
                ) {

            String line = reader.readLine();
            int index = 0;

            while(line != null){
                members[index] = line;
                index++;
                line = reader.readLine(); // this reassign line and if there aare no more values in the file it will result in a null
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally { //finally always executs
            System.out.println("Hello from the finally block");
        }

        return members;
    }
}
