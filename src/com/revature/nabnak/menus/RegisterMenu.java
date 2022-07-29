package com.revature.nabnak.menus;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.services.MemberService;
import com.revature.nabnak.util.CustomLogger;
import com.revature.nabnak.util.MenuRouter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegisterMenu extends Menu{
    CustomLogger customLogger = CustomLogger.getLogger(true);
    public RegisterMenu(BufferedReader terminalReader, MenuRouter menuRouter) {
        super("Register", "/register", terminalReader, menuRouter);
    }

    @Override
    public void render() throws IOException{
        System.out.print("Please enter email: \n>"); // \n is a new line character, aka return or enter
        String email = terminalReader.readLine();

        System.out.print("Please enter your first and last name: \n>");
        String fullName = terminalReader.readLine();

        System.out.print("Please enter your experience in months: \n>");
        int experienceMonths = 0;
        try {
            experienceMonths = Integer.parseInt(terminalReader.readLine());
        } catch (NumberFormatException e){
            customLogger.warn("Invalid number enter please try the registration again");
            menuRouter.transfer("/register");
        }
        System.out.print("Please enter your password: \n>");
        String password = terminalReader.readLine();


        // TODO: What on god's green earth is LocalDateTime?
        String registrationDate = LocalDateTime.now().toString();

        // This is a form of logging
        // System.out.printf("New user has registerd under \n User:%s,%s,%s,%s", email, fullName, experienceMonths, registrationDate).println(); //printf is a formatter

        Member newMember = new Member(email, fullName, experienceMonths, registrationDate, password);
        //TODO: LOGG INFO AS ENTER customerLogger.log(arguments)
        MemberService memberService = new MemberService();
        memberService.registerMember(newMember);

        customLogger.info("Navigating to dashboard for " + newMember.getEmail());
        menuRouter.transfer("/dashboard");
    }
}
