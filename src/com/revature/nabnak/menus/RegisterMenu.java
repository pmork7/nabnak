package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.MenuRouter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegisterMenu extends Menu{
    public RegisterMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Register", "/register", terminalReader, menuRouter);
    }

    @Override
    public void render() throws Exception{
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

        menuRouter.transfer("/dashboard");
    }
}
