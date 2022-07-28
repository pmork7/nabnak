package com.revature.nabnak.services;

import com.revature.nabnak.models.Member;
import com.revature.nabnak.util.exceptions.InvalidUserInputException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MemberService {

    public Member registerMember(Member newMember) {
        try {

            if (!isMemberValid(newMember)) {
                throw new InvalidUserInputException("User input was invalid");
            }
            File memoryFile = new File("resources/data.txt");
            // This beaut, is a try-with-resources block. This allows for anything that extends AutoClosable to be automatically closed
            try (FileWriter fileWriter = new FileWriter(memoryFile, true);) {

                System.out.println("New user has registered: " + newMember.toString());

                fileWriter.write(newMember.writeToFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            // TODO: LOGG THE INFO AS PERSISTED customerLogger.log(arguments)

            return newMember;

        } catch (InvalidUserInputException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isMemberValid(Member newMember){
        if(newMember == null) return false;
        // this || is the expression to signify to the conditional that if either of these are true then perform the action
        if(newMember.getEmail() == null || newMember.getEmail().trim().equals("")) return false;
        if(newMember.getFullName() == null || newMember.getFullName().trim().equals("")) return false;
        if(newMember.getExperienceMonths() == 0 || newMember.getExperienceMonths() < 0 ) return false;
        if(newMember.getRegistrationDate() == null || newMember.getRegistrationDate().trim().equals("")) return false;
        if(newMember.getPassword() == null || newMember.getPassword().trim().equals("")) return false;
        return true;
    }

    // TODO: IMPLEMENT MEEEEEEE!!!!!!!
    public boolean isEmailAvailable(){
        return false;
    }

}
