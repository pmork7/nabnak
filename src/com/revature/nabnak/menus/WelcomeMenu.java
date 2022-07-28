package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;

import java.io.*;
import java.time.LocalDateTime;

public class WelcomeMenu extends Menu {

    public WelcomeMenu(BufferedReader terminalReader) {
        super("Welcome", "/welcome", terminalReader);
    }

    @Override // this indicates we are overriding the method we are inheriting
    public void render() {

        String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) View members", "4) Exit application"};

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
                    Member[] members = readFile();
                    for (Member member : members) { // enhanced for loop with arrays
                        System.out.println(member);
                    }
                    break;
                case "4":
                    System.out.println("User is now exiting. Hope to see you soon!");
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

    // Custom method to implement a registration process
    private void register() throws IOException { // throws + ExceptionName is known as ducking
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
        try (FileWriter fileWriter = new FileWriter(memoryFile, true);) {

            Member member = new Member(email, fullName, Integer.parseInt(experienceMonths), registrationDate);

            System.out.println(member.getPassword());

            member.setPassword("12345");
            System.out.println(member.getPassword());

            System.out.println("New user has registered: " + member.toString());

            Member member2 = new Member();
            fileWriter.write(member.writeToFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Member[] readFile() { // we want to return information from this method
        Member[] members = new Member[10];

        // try-with-resources automatically closes files for us
        try (
                FileReader fileReader = new FileReader("resources/data.txt");
                BufferedReader reader = new BufferedReader(fileReader);
        ) {

            String line = reader.readLine();
            int index = 0;

            while (line != null) {
                String[] info = line.split(",");
                Member member = new Member();
                member.setEmail(info[0]);
                member.setFullName(info[1]);
                // Wrapper classes auto box (can convert back to the primitive value)
                member.setExperienceMonths(Integer.parseInt(info[2])); // how does the Integer Class become the primitive int?
                member.setRegistrationDate(info[3]);
                member.setPassword(info[4]);
                members[index] = member; // swapped from String line to Member member (this requires a datatype of member)
                index++;
                line = reader.readLine(); // this reassign line and if there aare no more values in the file it will result in a null
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { //finally always executs
            System.out.println("Hello from the finally block");
        }

        return members;
    }

}
