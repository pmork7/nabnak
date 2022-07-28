package com.revature.nabnak;

/* Nabnak is a kanband board for professional developers aimed to be the next best virtual board on the internet.
    The goal is to allow members to join the application, be assigned part of a team and shard their kanban cards.
*/

import com.revature.nabnak.menus.WelcomeMenu;
import com.revature.nabnak.models.Member;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

public class MainDriver {


    public static void main(String[] args) {

        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader);

        welcomeMenu.render();

    }



}
