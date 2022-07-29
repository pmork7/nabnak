package com.revature.nabnak.util;

import com.revature.nabnak.menus.DashboardMenu;
import com.revature.nabnak.menus.LoginMenu;
import com.revature.nabnak.menus.RegisterMenu;
import com.revature.nabnak.menus.WelcomeMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean isRunning;
    private final MenuRouter menuRouter;
    private final CustomLogger customLogger = CustomLogger.getLogger(true);

    public AppState(){
        isRunning = true;
        menuRouter = new MenuRouter();

        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

        WelcomeMenu welcomeMenu = new WelcomeMenu(terminalReader, menuRouter, customLogger);
        RegisterMenu registerMenu = new RegisterMenu(terminalReader, menuRouter, customLogger);
        DashboardMenu dashboardMenu = new DashboardMenu(terminalReader, menuRouter, customLogger);
        LoginMenu loginMenu = new LoginMenu(terminalReader, menuRouter, customLogger);

        menuRouter.addMenu(welcomeMenu);
        menuRouter.addMenu(registerMenu);
        menuRouter.addMenu(dashboardMenu);
        menuRouter.addMenu(loginMenu);

        customLogger.info("Application initialized");

    }

    public void startup(){
        while (isRunning) {
            customLogger.log("Routing to welcome meu...");
            menuRouter.transfer("/welcome");
        }
    }

    public static void shutdown(){

        isRunning = false;

    }
}
