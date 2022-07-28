package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.MenuRouter;

import java.io.*;
import java.time.LocalDateTime;

public class WelcomeMenu extends Menu {

    public WelcomeMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Welcome", "/welcome", terminalReader, menuRouter);
    }

    @Override // this indicates we are overriding the method we are inheriting
    public void render() throws Exception {

        String[] welcomeMessages = {"Welcome to Nabnak", "1) Login", "2) Register", "3) View members", "4) Exit application"};

        System.out.println(welcomeMessages[0]);
        System.out.println(welcomeMessages[1]);
        System.out.println(welcomeMessages[2]);
        System.out.println(welcomeMessages[3]);

        String firstInput = terminalReader.readLine(); // it throws an IOException, this MUST be handled before compile time (checked)

        // if your switch cases don't handle control flow it will result in fall-through
        // can be advantageous
        switch (firstInput) {
            case "1": // if firstInput.equals("1") then this case will execute
                System.out.println("User has selected login....");
                break; // the keyword break prevents any fall-through
            case "2":
                System.out.println("User has selected register....");
                menuRouter.transfer("/register");
                break;
            // case "i": // example of fall through
            case "3":
                System.out.println("User wishes to view other members");

                break;
            case "4":
                System.out.println("User is now exiting. Hope to see you soon!");
                break;

            default:
                System.out.println("User has not selected valid input....");

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
